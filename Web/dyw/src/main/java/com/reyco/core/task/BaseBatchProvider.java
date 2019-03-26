package com.reyco.core.task;

import java.util.ArrayList;
import java.util.List;

import com.reyco.core.pojo.Base;

/**
 * 批量新增 ----生产者对象
 * @author reyco
 */
public class BaseBatchProvider implements Runnable{
	/**
	 * 共同的资源   
	 */
	private Bases bases;
	
	private List<Base> list;
	/**
	 * 每次生产数量
	 */
	private int count;
	/**
	 * 数据大小
	 */
	private int listSize;
	/**
	 * 生产次数
	 */
	private int size;
	public BaseBatchProvider(Bases bases,List<Base> list) {
		super();
		this.bases = bases;
		this.list = list;
		//初始化
		init();
	}
	/**
	 * 初始化
	 */
	private void init() {
		//数据大小
		this.listSize = this.list.size();
		//根据数据大小,每次消费数量
		if(listSize >= 1 && listSize < 1000) {
			this.count = 333;
		}else if(listSize >= 1000 && listSize < 10000) {
			this.count = 1333;
		}else {
			this.count = 5333;
		}
		this.size = (this.listSize/this.count)+1;
	}
	@Override
	public void run() {
		//生产
		for(int i=0;i<size;i++) {
			List<Base> newList = new ArrayList<Base>();
			if((i+1) == size) {
				newList = list.subList(i*count, listSize);
			}else {
				newList = list.subList(i*count, (i+1)*count);
			}
			bases.provider(newList);
		}
	}
}
