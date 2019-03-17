package com.zookeeper.core.wather;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * 测试  Watcher
 * @author reyco
 *
 */
public class ZookeeperWatcher implements Watcher{
	private AtomicInteger seq = new AtomicInteger();
	/**
	 *       session失效时间
	 */
	private static final Integer SESSION_OUTTIME =  10000;
	/**
	 *       zk连接地址
	 */
	private static final String CONNECTION_ADDR = "192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	/**
	 * zk父节点设置/p
	 */
	private static final String PARENT_PATH = "/p";
	/**
	 *  zk子节点设置  /p/c
	 */
	private static final String CHIlDREN_PATH = "/p/c";
	/**
	 * zk子节点设置   /p/c/c1
	 */
	private static final String CHIlDREN_CHILDREN_PATH = "/p/c/c1";
	/**
	 * main线程标识
	 */
	private static final String MAIN = "【main】";
	/**
	 * wather线程标识
	 */
	private static final String WATHER = "【wather】";
	/**
	 * 
	 */
	private ZooKeeper zk = null;
	/**
	 * 阻塞程序执行,用于zookeeper等待连接成功，发送成功信号
	 */
	public static final CountDownLatch  countDownLatch = new CountDownLatch(1);
	/**
	 * wather
	 */
	@Override
	public void process(WatchedEvent event) {
		System.out.println("进入process.....event="+event);
		if(null == event) {
			return ;
		}
		//  连接状态
		KeeperState keeperState = event.getState();
		//事件类型
		EventType eventType = event.getType();
		//受影响的path
		String path = event.getPath();
		//原子对象seq,记录进入process的次数
		String logPreFix = "【wather-"+this.seq.incrementAndGet()+"】";
		System.out.println(logPreFix+"收到wather连接通知.....keeperState="+keeperState+",eventType="+eventType);
		if(KeeperState.SyncConnected == keeperState) {
			if(eventType.None == eventType) {
				System.out.println(logPreFix+"连接成功.....");
				countDownLatch.countDown();
			}else if(eventType.NodeCreated == eventType){
				System.out.println(logPreFix+"NodeCreated.....");
			}else if(eventType.NodeDeleted == eventType){
				System.out.println(logPreFix+"NodeDeleted.....");
			}else if(eventType.NodeDataChanged == eventType){
				System.out.println(logPreFix+"NodeDataChanged.....");
			}else if(eventType.NodeChildrenChanged == eventType){
				System.out.println(logPreFix+"NodeChildrenChanged.....");
			}
		}else if(KeeperState.Disconnected == keeperState ) {
			System.out.println("连接失败.....");
		}else if(KeeperState.Expired == keeperState ) {
			System.out.println("连接过期.....");
		}else if(KeeperState.AuthFailed == keeperState ) {
			System.out.println("认证失败.....");
		}
	}
	/**
	 * 创建连接
	 * @param connectionAddr
	 * @param sessionOutTime
	 */
	public void createConnection(String connectionAddr , Integer sessionOutTime) {
		this.close();
		try {
			zk = new ZooKeeper(CONNECTION_ADDR, SESSION_OUTTIME, this);
			System.out.println(MAIN+"开启连接zk服务器");
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭连接
	 */
	public void close() {
		if(null != this.zk) {
			try {
				zk.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean createPath(String path,String data,boolean needWath) {
		try {
			this.zk.exists(path, needWath);
			this.zk.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(MAIN +"创建节点,path==="+path+",数据,data=="+data.getBytes()+","+Ids.OPEN_ACL_UNSAFE+",永久存储"+CreateMode.PERSISTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean changeData(String path,String data,boolean needWath) {
		try {
			this.zk.exists(path, needWath);
			this.zk.setData(path, data.getBytes(), -1);
			System.out.println(MAIN +"更新节点,path==="+path+",数据,data=="+data.getBytes()+","+Ids.OPEN_ACL_UNSAFE+",永久存储"+CreateMode.PERSISTENT);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean getData(String path,boolean needWath) {
		try {
			System.out.println("读取节点,"+new String(this.zk.getData(path, needWath, null)));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<String> getChildren(String path,boolean needWath) {
		try {
			List<String> children = this.zk.getChildren(path, needWath);
			return children;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean exists(String path,boolean needWath) {
		try {
			this.zk.exists(path,needWath);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		ZookeeperWatcher zookeeperWather = new ZookeeperWatcher();
		zookeeperWather.createConnection(CONNECTION_ADDR, SESSION_OUTTIME);
		
		//System.out.println(MAIN+"创建/p节点");
		//创建/p节点,数据ppp,是否需要wather
		//zookeeperWather.createPath(PARENT_PATH, "ppp", true);
		
		//System.out.println(MAIN+"更新节点: /p");
		//更新节点： /p,数据: ccc,是否需要：wather
		//zookeeperWather.changeData(PARENT_PATH, "ccc", true);
		
		//System.out.println(MAIN+"获取节点: /p");
		//zookeeperWather.exists(PARENT_PATH, true);
		//获取节点： /p,是否需要：wather
		//zookeeperWather.getData(PARENT_PATH, true);
		
		//监听一下子节点
		zookeeperWather.getChildren(PARENT_PATH,true);
		System.out.println(MAIN+"创建子节点:/p/c");
		//创建/p/c节点,数据ccc,是否需要wather
		zookeeperWather.createPath(CHIlDREN_PATH, "ccc", true);
		
		//监听一下子节点
		zookeeperWather.getChildren(CHIlDREN_PATH,true);
		System.out.println(MAIN+"创建子节点:/p/c/c1");
		//创建/p/c/c1节点,数据c1c1,是否需要wather
		zookeeperWather.createPath(CHIlDREN_CHILDREN_PATH, "c1c1", true);
		
		//关闭连接
		zookeeperWather.close();
	}
}
