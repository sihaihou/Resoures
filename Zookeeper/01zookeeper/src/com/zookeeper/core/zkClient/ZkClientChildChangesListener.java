package com.zookeeper.core.zkClient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 *    测试  ZkClientListener
 * @author reyco
 *
 */
@SuppressWarnings("all")
public class ZkClientChildChangesListener{
	/**
	 *       session失效时间
	 */
	private static final Integer SESSION_OUTTIME =  20000;
	/**
	 *       zk连接地址
	 */
	private static final String CONNECTION_ADDR = "192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	
	public static void main(String[] args) throws InterruptedException {
		ZkClient zkc = new ZkClient(new ZkConnection(CONNECTION_ADDR), SESSION_OUTTIME);
		if(null == zkc) {
			return;	
		}
		System.out.println("连接成功!");
		
		//监听当前节点及子节点的新增和删除
		zkc.subscribeChildChanges("/super", new IZkChildListener() {
			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				System.out.println("---subscribeChildChanges---");
				System.out.println("parentPath=="+parentPath);
				System.out.println("currentChilds=="+currentChilds);
			}
		});
		Thread.sleep(3000);
		zkc.createPersistent("/super");
		Thread.sleep(1000);
		
		zkc.createPersistent("/super/c1");
		Thread.sleep(1000);
		
		zkc.createPersistent("/super/c2");
		Thread.sleep(1000);
		
		zkc.writeData("/super", "super新内容");
		Thread.sleep(1000);
		
		zkc.writeData("/super/c1", "c1新内容");
		Thread.sleep(1000);
		
		zkc.readData("/super").toString();
		Thread.sleep(1000);
		
		zkc.readData("/super/c1").toString();
		Thread.sleep(1000);
		
		zkc.delete("/super/c1");
		Thread.sleep(1000);
		
		zkc.delete("/super/c2");
		Thread.sleep(1000);
		
		zkc.delete("/super");
		Thread.sleep(1000);
		
		zkc.close();
	}

}
