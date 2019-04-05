package com.exam.core.dao;

//@Mapper
public interface StudentDao<T> extends BaseDao<T>{

	 T login(String no);
	
}
