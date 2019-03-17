package com.reyco.core.service;

import java.util.List;

import com.reyco.core.pojo.Base;

public interface BaseService extends IBaseService<Base>{
	/**
	 * 登录
	 * @param name
	 * @return
	 */
	public Base login(String name);
	/**
	 * 查询列表
	 * @param name
	 * @return
	 */
	public List<Base> searchList(String name);
	/**
	 * 查询记录数
	 * @param name
	 * @return
	 */
	public int searchCount(String name);
	
	/**
	 * 批量新增
	 * @param list
	 */
	public void batchInsert(List<Base> list);
	
}
