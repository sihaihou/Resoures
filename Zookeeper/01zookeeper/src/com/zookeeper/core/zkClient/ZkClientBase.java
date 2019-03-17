package com.zookeeper.core.zkClient;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 *    测试  zkClient
 * @author reyco
 *
 */
@SuppressWarnings("all")
public class ZkClientBase{
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
		
		//创建临时节点
		//zkc.createEphemeral("/temp");
		//递归创建节点
		//zkc.createPersistent("/super/temp", true);
		//Thread.sleep(10000);
		//递归删除节点
		//zkc.deleteRecursive("/super");
		//Thread.sleep(10000);
		
		// 获取节点
		/*zkc.createPersistent("/temp", "temp");
		zkc.createPersistent("/temp/temp1", "temp1的内容");
		zkc.createPersistent("/temp/temp2", "temp2的内容");
		List<String> list = zkc.getChildren("/temp");
		for (String node : list) {
			System.out.println(node);
			node = "/temp/"+node;
			Object data = zkc.readData(node);
			System.out.println(data);
		}
		zkc.deleteRecursive("/temp");*/
		
		// 更新内容
		//zkc.createPersistent("/super", "旧内容");
		zkc.writeData("/super", "新内容");
		Object data = zkc.readData("/super");
		boolean flag = zkc.exists("/super");
		System.out.println(data);
		System.out.println(flag);
		
		zkc.close();
	}

}
