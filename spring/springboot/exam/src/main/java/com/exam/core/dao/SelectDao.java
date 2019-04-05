package com.exam.core.dao;

import java.util.List;

public interface SelectDao<T> {
	/**
	 * 分页
	 * @param obj
	 */
	List<T> searchPage(T t);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T searchById(Integer id);
	/**
	 * 查询
	 * @param obj
	 */
	List<T> searchList(T t);
}
