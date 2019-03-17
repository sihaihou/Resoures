package com.zookeeper.core.test1;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 *   测试  获取节点、子节点
 * @author reyco
 *
 */
public class Test3 {
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
		//String node = zk.create("/testRoot", "testRoot".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//System.out.println(node);
		//创建子节点
		//String nodeA = zk.create("/testRoot/nodeA", "aaaaaaaa".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//System.out.println(nodeA);
		//String nodeB = zk.create("/testRoot/nodeB", "bbbbbbbb".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//System.out.println(nodeB);
		//String nodeC = zk.create("/testRoot/nodeC", "cccccccc".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		//System.out.println(nodeC);
		
		System.out.println("------get-------------");
		//  获取节点内容
		byte[] data = zk.getData("/testRoot", false, null);
		System.out.println(new String(data));
		
		//获取子节点
		List<String> list = zk.getChildren("/testRoot", false);
		for (String path : list) {
			System.out.println(path);
			String realPath = "/testRoot/"+path;
			byte[] realPathData = zk.getData(realPath, false, null);
			System.out.println(new String(realPathData));
		}
		
		
		System.out.println("-----------set----------");
		zk.setData("/testRoot", "setsetsetset".getBytes(), -1);
		data = zk.getData("/testRoot", false, null);
		System.out.println(new String(data));
		
		System.out.println("-----------exists----------");
		//判断节点是否存在: 返回值null表示节点不存在
		Stat flag = zk.exists("/testRoot", false);
		System.out.println(flag.getDataLength());
		
		
		//关闭连接
		zk.close();
		System.out.println("关闭连接");
	}
	
}
