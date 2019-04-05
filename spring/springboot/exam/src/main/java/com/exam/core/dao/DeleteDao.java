package com.exam.core.dao;

import java.util.List;

public interface DeleteDao<T> {
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
