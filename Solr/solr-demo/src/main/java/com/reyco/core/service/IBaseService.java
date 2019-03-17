package com.reyco.core.service;

import com.github.pagehelper.PageInfo;

public interface IBaseService<T> {
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
	public abstract PageInfo<T> searchPage(T t);
	
}
