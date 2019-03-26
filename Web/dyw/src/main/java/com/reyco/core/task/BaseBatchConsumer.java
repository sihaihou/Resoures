package com.reyco.core.task;

import java.util.List;

import com.reyco.core.pojo.Base;

/**
 * 消费者对象
 * @author reyco
 *
 */
public class BaseBatchConsumer implements Runnable{
	/**
	 * 共同的资源   
	 */
	private Bases bases;   
	/**
	 * 消费次数
	 */
	private int size;
	
	public BaseBatchConsumer(Bases bases, List<Base> list) {
		this.bases = bases;
		//初始化
		init(list);
	}
	/**
	 * 初始化
	 * @param list
	 */
	private void init(List list) {
		int listSize = list.size();
		int count = 333;
		//根据数据大小,每次消费数量
		if(listSize >= 1 && listSize < 1000) {
			count = 333;
		}else if(listSize >= 1000 && listSize < 10000) {
			count = 1333;
		}else {
			count = 5000;
		}
		this.size = (listSize/count)+1;
	}
	@Override
	public void run() {
		//循环消费
		for(int i=0;i<size;i++){
			bases.consumer();;
		}		
	}	
}