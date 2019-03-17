package com.reyco.core.thread;

import java.util.List;

import com.reyco.core.pojo.Base;

/**
 * 消费者对象
 * @author reyco
 *
 */
public class EatSome implements Runnable{
	/**
	 * 共同的资源   
	 */
	private Bases bases;
	
	private List<List<Base>> list;
	/**
	 * 消费次数
	 */
	private int size;
	public EatSome(Bases bases,List<List<Base>> list) {
		super();
		this.bases = bases;
		this.size = list.size();
	}
	@Override
	public void run() {
		//循环消费
		for(int i=0;i<size;i++){
			bases.eatSome();
		}		
	}	
}