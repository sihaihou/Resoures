package com.reyco.core.task;

import java.util.List;

import com.reyco.core.pojo.Base;
/**
 * 生产者对象
 * @author reyco
 */
public class BaseProvider implements Runnable{
	/**
	 * 共同的资源   
	 */
	private Bases bases;
	/**
	 * 生产数据
	 */
	private List<List<Base>> list;
	public BaseProvider(Bases bases, List<List<Base>> list) {
		super();
		this.bases = bases;
		this.list = list;
	}
	@Override
	public void run() {
		//生产
		for (List<Base> baseList : list) {
			bases.provider(baseList);
		}
	}
}
