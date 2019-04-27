package com.reyco.service;

public interface AccountService {
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Boolean login(String name,String password);	
}
