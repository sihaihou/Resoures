package com.reyco.core.dao;

import java.util.List;

import com.reyco.core.pojo.Base;

public interface BaseDao extends IBaseDao<Base> {
	/**
	 * 登录
	 * @param name
	 * @return
	 */
	public Base login(String name);
	/**
	 * 查询记录数
	 * @param name
	 * @return
	 */
	public int searchCount(Base base);
	
	/**
	 * 批量新增
	 * @param list
	 */
	public void batchInsert(List<Base> list);
	
}
