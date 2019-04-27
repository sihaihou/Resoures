package com.reyco.dyw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.reyco.dyw.dao.AccountDao;
import com.reyco.dyw.domain.Account;
import com.reyco.dyw.service.AccountDubboService;

public class AccountDubboServiceImpl implements AccountDubboService{
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Boolean login(String name, String password) {
		Account account = accountDao.login(name);
		if(null == account) {
			return false;
		}
		if(!account.getPassword().equals(password)) {
			return false;
		}
		return true;
	}
	
}
