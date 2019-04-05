package com.exam.core.dao;

public interface UpdateDao<T> {
	/**
	 * 根据Id更新
	 * @param obj
	 */
	void updateById(T t);
}
