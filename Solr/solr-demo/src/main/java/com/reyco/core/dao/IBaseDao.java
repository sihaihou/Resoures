package com.reyco.core.dao;

import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 新增
	 * @param t
	 */
	public abstract void insert(T t);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public abstract T searchById(Integer id);
	
	/**
	 * 根据id更新
	 * @param t
	 */
	public abstract void updateById(T t);
	
	/**
	 * 分页搜索
	 * @param t
	 * @return
	 */
	public abstract List<T> searchPage(T t);
	
}
