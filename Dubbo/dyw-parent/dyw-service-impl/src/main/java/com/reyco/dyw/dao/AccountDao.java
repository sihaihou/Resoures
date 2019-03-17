package com.reyco.dyw.dao;

import com.reyco.dyw.domain.Account;

public interface AccountDao {
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Account login(String name);
	
}
