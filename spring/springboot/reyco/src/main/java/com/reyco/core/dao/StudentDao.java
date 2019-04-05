package com.reyco.core.dao;

public interface StudentDao<T> extends BaseDao<T>{

	T login(String no);
	
}
