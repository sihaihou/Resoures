package com.zookeeper.distributedLock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

/**
 * Zookeeper 超时机制+临时节点
 * 
 * @author reyco
 *
 */
public class DistributedLock implements Lock {
	private static final String ZK_ADDRESS = "192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	/**
	 * 父节点
	 */
	private String distributedLock = "/distributedLock";
	/**
	 * 子节点
	 */
	private static final String LOCKNAME = "/lock_";
	/**
	 * 当前节点
	 */
	private static ThreadLocal<String> currentPath = new ThreadLocal<>();
	/**
	 * 前一个节点
	 */
	private static ThreadLocal<String> beforePath = new ThreadLocal<>();
	/**
	 * zkc
	 */
	private ZkClient zkClient;
	/**
	 * 超时时间
	 */
	private static final int TIMIOUT = 5000;

	/**
	 * 
	 * @param rootPath
	 */
	public DistributedLock(String rootPath) {
		this.distributedLock = rootPath;
		zkClient = new ZkClient(new ZkConnection(ZK_ADDRESS, TIMIOUT));
		if (!zkClient.exists(distributedLock)) {
			zkClient.createPersistent(distributedLock);
		}
		zkClient.setZkSerializer(new ZkSerializer() {
			@Override
			public byte[] serialize(Object data) throws ZkMarshallingError {
				return String.valueOf(data).getBytes();
			}
			@Override
			public Object deserialize(byte[] bytes) throws ZkMarshallingError {
				return new String(bytes);
			}
		});
	}

	@Override
	public void lock() {
		// 尝试获取锁
		if (!tryLock()) {
			// 等待
			waitForLock();
			// 获取锁
			lock();
		}
	}

	/**
	 * 
	 */
	private void waitForLock() {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		// 注册监听
		IZkDataListener listener = new IZkDataListener() {
			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				System.out.println(Thread.currentThread().getName()+",监听节点被删除。。。" + dataPath);
				countDownLatch.countDown();
			}

			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				System.out.println("监听节点数据变化。。。" + data);
			}
		};
		zkClient.subscribeDataChanges(this.beforePath.get(), listener);
		try {
			if (this.zkClient.exists(this.beforePath.get())) {
				countDownLatch.await();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		zkClient.unsubscribeDataChanges(this.beforePath.get(), listener);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	/**
	 * 尝试获取锁
	 */
	@Override
	public boolean tryLock() {
		// 如果存在就不创建了
		if (null == this.currentPath.get()) {
			// 创建临时顺序节点
			currentPath.set(this.zkClient.createPersistentSequential(distributedLock + LOCKNAME, "lockName"));
		}
		// 获取所有子节点
		List<String> children = this.zkClient.getChildren(distributedLock);
		// 排序children
		Collections.sort(children);
		// 判断是否最小节点
		if (currentPath.get().equals(distributedLock + "/" + children.get(0))) {
			return true;
		}
		// 获取前一个节点
		else {
			// 获取当前节点的索引号
			int currentIndex = children.indexOf(currentPath.get().substring(distributedLock.length()+1));
			beforePath.set(distributedLock + "/"+children.get(currentIndex - 1));
		}
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void unlock() {
		zkClient.delete(this.currentPath.get());
	}

	@Override
	public Condition newCondition() {
		return null;
	}

	public static void main(String[] args) throws InterruptedException {
		String path =  "/distributedLock";
		List<String> list = new ArrayList<>();
		int threadSize = 10;
		CountDownLatch countDownLatch = new  CountDownLatch(threadSize);
		ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
		for (int i = 0; i < threadSize; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					DistributedLock distributedLock = new DistributedLock(path);
					try {
						distributedLock.lock();
						list.add("asdw ");
						countDownLatch.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						distributedLock.unlock();
					}
				}
			});
		}
		countDownLatch.await();
		threadPool.shutdown();
		System.out.println(list.size());
	}
}
