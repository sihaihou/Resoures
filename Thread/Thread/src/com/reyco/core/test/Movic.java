package com.reyco.core.test;

import com.reyco.core.entity.Base;

/**
 * 一个场景    共同的资源
 * 生产者消费者模式  信号灯法
 * wait()等待；释放锁，   sleep 不释放锁
 * notify()/notifyAll() 唤醒
 * 	与synchronized 一起使用
 * @author 侯四海
 */
public class Movic {
	private Base base;
	/**
	 * 信号灯
	 * flag 为 true 生产者生产，消费者等待  生产完成后通知消费
	 * flag 为 false 消费者消费，生产者等待  消费完成后通知生产
	 */
	private boolean flag=true;
	//播放
	public  synchronized void play(Base base) {
		if(!flag){		//生产者等待 
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产了："+this.base);
		this.base=base;
		//生产完毕
		
		//通知消费
		this.notify();
		//停止生产
		this.flag=false;
	}
	//观看
	public synchronized void watch()  {
		if(flag){	//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费了："+base);
		//消费完毕
		
		//通知生产
		this.notifyAll();
		//通知消费
		this.flag=true;
	}
}
