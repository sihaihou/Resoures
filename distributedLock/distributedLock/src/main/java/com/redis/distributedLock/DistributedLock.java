package com.redis.distributedLock;

import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis 分布式锁
 * @author reyco
 *
 */
public class DistributedLock {

	private Jedis jedis;

	public DistributedLock() {
		super();
		this.jedis = new Jedis("39.107.247.102", 6379);
		this.jedis.auth("123456");
	}
	
	/**
	 * 加锁
	 * 
	 * @param lockName
	 *            锁的名称
	 * @param acquireTimeout
	 *            获取锁的超时时间,单位毫秒数
	 * @param timeout
	 *            key的超时时间,单位毫秒数
	 */
	public String lock(String lockName, long acquireTimeout, long timeout) {
		// 返回标识
		String identifier = null;
		try {
			// key
			String lockKey = "lock_" + lockName;
			// key所对应的value值
			String lockValue = UUID.randomUUID().toString();
			// 计算key的超时时间
			Integer expireTime = (int) timeout / 1000;
			// 获取锁的超时时间
			long end = System.currentTimeMillis() + acquireTimeout;
			// 循环获取锁
			while (System.currentTimeMillis() <= end) {
				// key是否存在
				if (jedis.setnx(lockKey, lockValue) == 1) {
					// 如果不存在，设置key过期时间
					jedis.expire(lockKey, expireTime);
					identifier = lockValue;
					return identifier;
				}
				// 如果设置过期时间异常，那么下一次必须设置key过期时间，否则可能出现死锁
				if (jedis.ttl(lockKey) == -1) {
					jedis.expire(lockKey, expireTime);
				}
				// 设置一个时间间隔，避免频繁尝试获取锁
				Thread.sleep(20);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return identifier;
	}

	/**
	 * 手动释放锁
	 * 
	 * @param lockName
	 * 			锁的名称
	 */
	public void unlock(String lockName) {
		try {
			// key
			String lockKey = "lock_" + lockName;
			if (jedis.exists(lockKey)) {
				// 手动删除key,释放锁
				jedis.del(lockKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					DistributedLock distributedLock = new DistributedLock();
					String str = distributedLock.lock("12306", 5000, 10000);
					if (null != str && !str.equals("")) {
						try {
							System.out.println(str + ":"+Thread.currentThread().getName() + ":执行任务...");
							// 休息一段时间，模拟业务执行耗时
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						// 释放锁
						distributedLock.unlock("12306");
					}
				}
			}).start();
		}
	}
}
