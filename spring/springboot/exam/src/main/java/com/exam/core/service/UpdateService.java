package com.exam.core.service;

public interface UpdateService<T> {
	/**
	 * 根据Id更新
	 * @param obj
	 */
	void updateById(T t);
}
