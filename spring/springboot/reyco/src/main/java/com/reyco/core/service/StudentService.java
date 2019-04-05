package com.reyco.core.service;

public abstract class StudentService<T> implements BaseService<T>{
	
	public abstract T login(String no);
	
}
