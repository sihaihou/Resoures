package com.reyco.core.dao;

import com.reyco.core.domain.Account;

public interface AccountDao {
	/**
	 * 查询余额
	 * @param accountId
	 * @return
	 */
	Account getAccountById(Integer id);
	/**
	 *      转账-->出钱
	 * @param accountId   转账人id
	 * @param amount      转账金额
	 * @param messageId   消息id
	 */
	void updateAccountById(Account account);

}
