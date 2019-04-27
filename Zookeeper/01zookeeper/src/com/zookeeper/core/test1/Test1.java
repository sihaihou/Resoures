package com.zookeeper.core.test1;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 *    测试  创建节点
 * @author reyco
 *
 */
public class Test1 {
	/**
	 * zookeeper连接地址
	 */
	public static final String CONNECT_ADDR="192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	/**
	 *   session超时时间 单位毫秒
	 */
	public static final Integer SESSION_OUTTIME=5000; 
	/**
	 * 阻塞程序执行,用于zookeeper等待连接成功，发送成功信号
	 */
	public static final CountDownLatch  countDownLatch = new CountDownLatch(1);
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				KeeperState zeeperState = event.getState();
				EventType evenType = event.getType();
				if(KeeperState.SyncConnected == zeeperState) {
					if(EventType.None == evenType) {
						//如果建立连接,则发送信号，让后续阻塞程序继续执行
						countDownLatch.countDown();
						System.out.println("zk 连接成功！");
					}
				}
			}
		});
		countDownLatch.await();
		System.out.println("zk 使用");
		
		//创建节点
		//String node = zk.create("/reyco", "reyco".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//System.out.println(node);
		
		//创建临时节点-------创建临时节点可以,做分布式锁。
		String node = zk.create("/reyco/core", "core".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println(node);
		
		//关闭连接
		zk.close();
		System.out.println("关闭连接");
	}
	
}
