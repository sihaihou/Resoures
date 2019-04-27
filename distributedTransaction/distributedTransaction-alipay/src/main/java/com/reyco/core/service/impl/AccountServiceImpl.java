package com.reyco.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reyco.core.dao.AccountDao;
import com.reyco.core.domain.Account;
import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.AccountService;
import com.reyco.core.service.MessageService;
import com.reyco.core.service.QueueProducerService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private MessageService messageService;

	@Autowired
	private QueueProducerService queueProducerService;
	/**
	  *      转账流程: 1,修改金额;
	  *      	  2,修改金额成功,新增一条未确认消息,修改金额失败,不新增消息;
	  *           3,新增消息成功,向MQ发送一条消息。
	  *          如果向MQ发送消息失败(消息丢失),用一个定时任务，定时扫描未确认的消息用于消息(发送MQ消息).
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	public boolean transfer(Integer id, Integer amount) {
		// 查询余额
		Account account = this.getAccountById(id);
		Integer oldAmount = account.getAmount();
		// 余额不足，直接返回
		if (oldAmount < amount) {
			return false;
		}
		// 余额
		oldAmount = oldAmount - amount;
		account.setAmount(oldAmount);
		// 修改金额
		this.updateAccountById(account);
		// 未提交状态
		Integer status = 1;
		MessageMQ message = new MessageMQ(id, amount, status);
		System.out.println("message..."+message);
		// 新增一条消息
		messageService.insertMessage(message);
		Integer messageId = message.getId();
		// 向MQ发送一条消息
		if (null != messageId) {
			logger.info(message.toString());
			queueProducerService.sendObjectMessage(message);
		}
		return true;
	}

	@Override
	public Account getAccountById(Integer accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public void updateAccountById(Account account) {
		accountDao.updateAccountById(account);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void testUpdateAccountById(Account account) {
		account.setAmount(100);
		System.out.println("第一次" + account);
		this.updateAccountById(account);
		account.setAmount(10000);
		System.out.println("第一次" + account);
		this.updateAccountById(account);
		throw new RuntimeException();
	}

}
