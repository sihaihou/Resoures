package com.exam.core.service;

import java.util.List;

public interface SelectService<T> {
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
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T searchById(Integer id);

}
