package com.reyco.dyw.service;

public interface AccountDubboService {
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Boolean login(String name,String password);
}
