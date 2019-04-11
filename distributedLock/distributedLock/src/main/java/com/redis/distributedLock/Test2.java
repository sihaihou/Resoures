package com.redis.distributedLock;

public class Test2 {
	public static void main(String[] args) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<5;i++) {
			new Thread(new Runnable() {
				public void run() {
					DistributedLock distributedLock = new DistributedLock();
					String str = distributedLock.lock("12306", 5000, 10000);
					if (null != str && !str.equals("")) {
						try {
							System.out.println(str + ":"+Thread.currentThread().getName() + ":执行任务2...");
							// 休息一段时间，模拟业务执行耗时
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						// 释放锁
						distributedLock.unlock("12306",str);
					}
				}
			}).start();
		}
	}
}
