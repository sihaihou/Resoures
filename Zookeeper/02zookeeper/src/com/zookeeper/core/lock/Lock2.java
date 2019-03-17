package com.zookeeper.core.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;


public class Lock2 {

	static final String CONNECT_ADDR = "192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	static final int SESSION_OUTTIME = 5000;
	
	public static CuratorFramework createCuratorFramework(){
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
		CuratorFramework cf = CuratorFrameworkFactory.builder()
					.connectString(CONNECT_ADDR)
					.sessionTimeoutMs(SESSION_OUTTIME)
					.retryPolicy(retryPolicy)
					.build();
		return cf;
	}

	public static void main(String[] args) throws Exception {
		final CountDownLatch coutdown = new CountDownLatch(1);
		for(int i = 0; i < 10; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					CuratorFramework cf = createCuratorFramework();
					cf.start();
					final InterProcessMutex lock = new InterProcessMutex(cf, "/super");
					final ReentrantLock reentrantLock = new ReentrantLock();
					try {
						coutdown.await();
						lock.acquire();
						reentrantLock.lock();
						System.out.println(Thread.currentThread().getName() + "执行业务逻辑..");
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							//释放
							lock.release();
							//reentrantLock.unlock();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			},"t" + i).start();
		}
		Thread.sleep(2000);
		coutdown.countDown();
		 
	}
}
