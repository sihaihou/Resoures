package com.reyco.core.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 分页
	 * @param obj
	 */
	List<T> searchPage(T t);
	/**
	 * 查询
	 * @param obj
	 */
	List<T> searchList(T t);
	/**
	 * 新增
	 * @param obj
	 */
	void insert(T t);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T searchById(Integer id);

	/**
	 * 根据Id更新
	 * @param obj
	 */
	void updateById(T t);

	/**
	 * 根据Id删除
	 * @param obj
	 */
	void deleteById(Integer id);
	
	/**
	 * 根据List批量删除
	 * @param list
	 */
	void deleteByList(List<Integer> list);
	
}
