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
		Integer amount = account.getAmount();
		Account ac = getAccountById(accountId);
		Integer oldAmount = ac.getAmount();
		// 余额
		amount = oldAmount + amount;
		ac.setAmount(amount);
		// 修改金额
		accountDao.updateAccountById(ac);
	}

	@Override
	public Account getAccountById(Integer accountId) {
		return accountDao.getAccountById(accountId);
	}

}
