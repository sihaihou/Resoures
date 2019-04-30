package com.reyco.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.AccountDao;
import com.reyco.core.domain.Account;
import com.reyco.core.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired 
	private AccountDao accountDao;
	
	@Override
	public void updateAccountById(Account account)  {
		Integer accountId = account.getId();
		Account ac = getAccountById(accountId);
		if(null == ac) {
			return;
		}
		// 修改金额
		accountDao.updateAccountById(account);
	}

	@Override
	public Account getAccountById(Integer accountId) {
		return accountDao.getAccountById(accountId);
	}

}
