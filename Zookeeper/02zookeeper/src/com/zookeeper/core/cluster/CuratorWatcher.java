package com.zookeeper.core.cluster;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorWatcher {

	/** 父节点path */
	static final String PARENT_PATH = "/super";
	
	public static final String CONNECT_ADDR = "192.168.2.107:2181,192.168.2.108:2181,192.168.2.110:2181";
	
	public static final int SESSION_TIMEOUT = 30000;
	
	public CuratorWatcher() throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
		CuratorFramework cf = CuratorFrameworkFactory.builder()
					.connectString(CONNECT_ADDR)
					.sessionTimeoutMs(SESSION_TIMEOUT)
					.retryPolicy(retryPolicy)
					.build();
		//3 建立连接
		cf.start();
		
		//4 创建跟节点
		if(cf.checkExists().forPath(PARENT_PATH) == null){
			cf.create().withMode(CreateMode.PERSISTENT).forPath(PARENT_PATH,"super init".getBytes());
		}

		PathChildrenCache cache = new PathChildrenCache(cf, PARENT_PATH, true);
		cache.start(StartMode.POST_INITIALIZED_EVENT);
		cache.getListenable().addListener(new PathChildrenCacheListener() {
			/**
			 * <B>方法名称：</B>监听子节点变更<BR>
			 * <B>概要说明：</B>新建、修改、删除<BR>
			 * @see org.apache.curator.framework.recipes.cache.PathChildrenCacheListener#childEvent(org.apache.curator.framework.CuratorFramework, org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent)
			 */
			@Override
			public void childEvent(CuratorFramework cf, PathChildrenCacheEvent event) throws Exception {
				switch (event.getType()) {
				case CHILD_ADDED:
					System.out.println("CHILD_ADDED :" + event.getData().getPath());
					System.out.println("CHILD_ADDED :" + new String(event.getData().getData()));
					break;
				case CHILD_UPDATED:
					System.out.println("CHILD_UPDATED :" + event.getData().getPath());
					System.out.println("CHILD_UPDATED :" + new String(event.getData().getData()));
					break;
				case CHILD_REMOVED:
					System.out.println("CHILD_REMOVED :" + event.getData().getPath());
					System.out.println("CHILD_REMOVED :" + new String(event.getData().getData()));
					break;
				default:
					break;
				}
			}
		});
	}

}
