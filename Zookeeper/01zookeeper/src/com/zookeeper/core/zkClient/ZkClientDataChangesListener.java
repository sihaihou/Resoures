package com.zookeeper.core.zkClient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 *    测试  ZkClientListener --- subscribeDataChanges
 * @author reyco
 *
 */
@SuppressWarnings("all")
public class ZkClientDataChangesListener{
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
		
		zkc.createPersistent("/super");
		
		//监听当前节点的更新和删除
		zkc.subscribeDataChanges("/super", new IZkDataListener() {
			@Override
			public void handleDataDeleted(String path) throws Exception {
				System.out.println("删除的节点=="+path);
			}
			@Override
			public void handleDataChange(String path, Object data) throws Exception {
				System.out.println("更新的节点=="+path+",变更内容为=="+data);
			}
		});
		
		zkc.writeData("/super", "456", -1);
		Thread.sleep(1000);
		
		zkc.delete("/super");
		Thread.sleep(1000);
		
		zkc.close();
	}

}
