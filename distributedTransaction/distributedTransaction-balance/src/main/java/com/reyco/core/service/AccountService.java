package com.reyco.core.service;

import com.reyco.core.domain.Account;

public interface AccountService {
	/**
	 * 查询余额
	 * @param accountId
	 * @return
	 */
	Account getAccountById(Integer id);
	/**
	  *      转账---收钱
	 * @param accountId   转账人id
	 * @param amount      转账金额
	 */
	void updateAccountById(Account account);
}
