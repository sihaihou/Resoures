package com.reyco.core.task;

import java.util.List;

import com.reyco.core.pojo.Base;
import com.reyco.core.service.BaseService;
import com.reyco.core.util.SpringContextHolder;

/**
 * 
 * @author reyco
 *
 */
public class Bases {

	private BaseService baseService = SpringContextHolder.getBean("baseService");

	private List<Base> list;
	/**
	 * 信号灯 flag 
	 * 			    为 true  生产者生产，消费者等待 生产完成后通知消费
	 *            为 false 消费者消费，生产者等待 消费完成后通知生产
	 */
	private boolean flag = true;

	// 生产者
	public synchronized void provider(List<Base> list) {
		// 生产者等待
		try {
			if (!flag) {
				this.wait();
			}
			// 开始生产
			this.list = list;
			// 通知消费
			this.notify();
			// 停止生产
			this.flag = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 消费者
	public synchronized void consumer() {
		// 消费者等待
		try {
			if (flag) { 
				this.wait();
			}
			// 开始消费
			baseService.batchInsert(list);
			// 消费完毕
			// 通知生产
			this.notifyAll();
			// 通知消费
			this.flag = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
