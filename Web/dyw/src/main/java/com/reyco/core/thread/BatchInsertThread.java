package com.reyco.core.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reyco.core.pojo.Base;
import com.reyco.core.service.BaseService;
import com.reyco.core.util.SpringContextHolder;
/**
 * batchInsert线程类
 * @author reyco
 *
 */
public class BatchInsertThread implements Runnable{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private BaseService baseService = SpringContextHolder.getBean("baseService");
	List<Base> list;
	CountDownLatch begin;
	CountDownLatch end;
	public BatchInsertThread() {
	}
	public BatchInsertThread(List<Base> list, CountDownLatch begin, CountDownLatch end) {
		this.list = list;
		this.begin = begin;
		this.end = end;
	}
	@Override
	public void run() {
		try {
			baseService.batchInsert(list);
            //执行完让线程直接进入等待
            begin.await();
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
		}finally {
			//这里要主要了，当一个线程执行完了计数要减一不要这个线程会被一直挂起
            //，end.countDown()，这个方法就是直接把计数器减一的
            end.countDown();
		}
	}
	public List<Base> getList() {
		return list;
	}
	public void setList(List<Base> list) {
		this.list = list;
	}
	public CountDownLatch getBegin() {
		return begin;
	}
	public void setBegin(CountDownLatch begin) {
		this.begin = begin;
	}
	public CountDownLatch getEnd() {
		return end;
	}
	public void setEnd(CountDownLatch end) {
		this.end = end;
	}
}