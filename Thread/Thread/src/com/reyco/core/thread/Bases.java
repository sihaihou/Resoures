package com.reyco.core.thread;

import com.reyco.core.entity.Base;

public class Bases {
	Base base;
	boolean flag = true;
	// 播放
	public synchronized void shengChan(Base base) {
		if (!flag) { // 生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始生产
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.base = base;
		System.out.println("----生产了-----" + this.base);
		// 生产完毕

		// 通知消费
		this.notify();
		// 停止生产
		this.flag = false;
	}

	// 消费
	public synchronized void xiaoFei() {
		if (!flag) { // 消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//开始消费
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("------消费了-----"+base);
		// 消费完毕

		// 通知消费
		this.notifyAll();
		// 停止生产
		this.flag = true;
	}

}
