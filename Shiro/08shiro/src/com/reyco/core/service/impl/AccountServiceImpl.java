package com.reyco.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.AccountDao;
import com.reyco.core.pojo.Account;
import com.reyco.core.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account searchUserByUserName(String username) {
		return accountDao.searchUserByUserName(username);
	}

}
