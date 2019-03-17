package com.zookeeper.core.atomicinteger;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

public class CuratorAtomicInteger {

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
		//cf.delete().forPath("/super");

		//4 使用DistributedAtomicInteger
		DistributedAtomicInteger atomicIntger = new DistributedAtomicInteger(cf, "/super", new RetryNTimes(3,1000));
		
		AtomicValue<Integer> value = atomicIntger.add(1);
		System.out.println(value.succeeded());
		System.out.println(value.postValue());	//最新值
		System.out.println(value.preValue());	//原始值
		
	}
}
