package com.exam.core.dao;

public interface InsertDao<T> {
	/**
	 * 新增
	 * @param obj
	 */
	void insert(T t);
}
