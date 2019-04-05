package com.exam.core.service;

public abstract class StudentService<T> implements BaseService<T>{
	
	public abstract T login(String no);
	
}
