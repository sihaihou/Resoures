package com.reyco.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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
	private TransactionTemplate transactionTemplate;

	@Autowired
	private QueueProducerService queueProducerService;

	/**
	 * 转账流程:  
	 * 			 1,修改金额; 
	 *           2,修改金额成功,新增一条未确认消息,修改金额失败,不新增消息; 
	 *           3,新增消息成功,向MQ发送一条消息。
	 *     如果向MQ发送消息失败(消息丢失),用一个定时任务，定时扫描未确认的消息用于消息(发送MQ消息).
	 */
	public boolean transfer(Integer id, Integer amount) {
		// 未提交状态
		Integer stats = 1;
		MessageMQ message = new MessageMQ(id,amount,stats);
		Boolean flag = transactionTemplate.execute(new TransactionCallback<Boolean>() {
			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				try {
					logger.info("###########支付宝方查询余额操作###########id==" + id);
					Account account = accountDao.getAccountById(id);
					Integer oldAmount = account.getAmount();
					logger.info("###########支付宝方查询当前账号余额###########OldAmount==" + oldAmount);
					if (oldAmount < amount) {
						logger.info("###########支付宝方余额不足###########" + account);
						return false;
					}
					// 设置余额
					account.setAmount(amount);
					logger.info("###########支付宝方扣款操作###########" + account);
					accountDao.updateAccountById(account);
					logger.info("###########支付宝方添加消息操作###########" + message);
					// 新增一条消息
					messageService.insertMessage(message);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		});
		// 失败
		if (!flag) {
			return false;
		}
		// 获取新增message的id
		Integer messageId = message.getId();
		// 向MQ发送一条消息
		logger.info("###########支付宝方向MQ发送消息###########" + message);
		queueProducerService.sendObjectMessage(message);
		return true;
	}

	/**
	 * 转账流程: 
	 *         1,修改金额; 
	 *         2,修改金额成功,新增一条未确认消息,修改金额失败,不新增消息; 
	 *         3,新增消息成功,向MQ发送一条消息。
	 *      如果向MQ发送消息失败(消息丢失),用一个定时任务，定时扫描未确认的消息用于消息(发送MQ消息).
	 */
	@Transactional(rollbackFor = Throwable.class)
	public boolean transfer1(Integer id, Integer amount) {
		logger.info("###########支付宝方查询余额操作###########id==" + id);
		Account account = accountDao.getAccountById(id);
		Integer oldAmount = account.getAmount();
		logger.info("###########支付宝方查询当前账号余额###########OldAmount==" + oldAmount);
		if (oldAmount < amount) {
			logger.info("###########支付宝方余额不足###########" + account);
			return false;
		}
		// 设置余额
		account.setAmount(amount);
		logger.info("###########支付宝方扣款操作###########" + account);
		accountDao.updateAccountById(account);
		// 未确认状态
		Integer stats = 1;
		MessageMQ message = new MessageMQ(id, amount, stats);
		logger.info("###########支付宝方添加消息操作###########" + message);
		// 新增一条消息
		messageService.insertMessage(message);
		// 获取新增message的id
		Integer messageId = message.getId();
		// 向MQ发送一条消息
		if (null != messageId) {
			logger.info("###########支付宝方向MQ发送消息###########" + message);
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

	@Override
	public void testUpdateAccountById(Account account) {
		Boolean flag = (Boolean) transactionTemplate.execute(new TransactionCallback<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus status) {
				try {
					account.setAmount(100);
					System.out.println("第一次" + account);
					accountDao.updateAccountById(account);
					account.setAmount(10000);
					System.out.println("第一次" + account);
					accountDao.updateAccountById(account);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		});
		System.out.println("###############flag###########" + flag);
	}

}
