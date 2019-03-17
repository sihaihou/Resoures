package com.zookeeper.core.cluster;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Test {
	
	static final String CONNECT_ADDR = "192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	static final int SESSION_OUTTIME = 5000;
	
	public static void main(String[] args) throws Exception {
		
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
		CuratorFramework cf = CuratorFrameworkFactory.builder()
					.connectString(CONNECT_ADDR)
					.sessionTimeoutMs(SESSION_OUTTIME)
					.retryPolicy(retryPolicy)
					.build();
		cf.start();
		
		Thread.sleep(3000);
		System.out.println(cf.getChildren().forPath("/super").get(0));
		
		//4 创建节点
//		Thread.sleep(1000);
//		cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/super/c1","c1内容".getBytes());
//		Thread.sleep(1000);
//		cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/super/c2","c2内容".getBytes());
//		Thread.sleep(1000);
//		
//		//5 读取节点
//		Thread.sleep(1000);
//		String ret1 = new String(cf.getData().forPath("/super/c1"));
//		System.out.println(ret1);
//
//		//6 修改节点
//		Thread.sleep(1000);
//		cf.setData().forPath("/super/c2", "修改的新c2内容".getBytes());
//		String ret2 = new String(cf.getData().forPath("/super/c2"));
//		System.out.println(ret2);	
//		
//		//7 删除节点
//		Thread.sleep(1000);
//		cf.delete().forPath("/super/c1");
	}
}
