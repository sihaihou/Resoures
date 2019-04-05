package com.exam.core.dao;

/**
 * 所有dao接口
 * @author reyco
 *
 * @param <T>
 */
public interface BaseDao<T> extends SelectDao<T>,InsertDao<T>,UpdateDao<T>,DeleteDao<T>{
	
}
