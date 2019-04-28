package com.reyco.core.service;

import com.reyco.core.domain.Account;

public interface AccountService {
	
	Account getAccountById(Integer accountId);
	/**
	  *      转账
	 * @param accountId   转账人id
	 * @param amount      转账金额
	 * @param messageId   消息id
	 * @param messageStatus 消息状态
	 */
	void updateAccountById(Account account);
	/**
	 * 
	 * @param accountId
	 * @param amount
	 * @return
	 */
	boolean transfer(Integer accountId, Integer amount);
	
	void testUpdateAccountById(Account account);
}
