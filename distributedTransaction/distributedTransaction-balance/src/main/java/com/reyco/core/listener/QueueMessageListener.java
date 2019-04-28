package com.reyco.core.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.reyco.core.domain.Account;
import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.AccountService;
import com.reyco.core.service.MessageService;

@Component("messageListener")
public class QueueMessageListener implements MessageListener {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MessageService messageService;
	
	/**
	  *    收款流程：
	 *          1，监听消息,拿到MQ消息;
	 *          2，到消息表查询该消息是否消费过;
	 *          3，该消息如未消费(没有查到该消息)，执行本地事务;
	 *          4，执行本地事务1，首先修改账号金额;
	 *          5，执行本地事务2，向消息表新增消息；
	 *          6，回调
	 */
	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage om = (ObjectMessage) message;
				Object data = om.getObject();
				if (data instanceof MessageMQ) {
					MessageMQ mcMQ = (MessageMQ) data;
					Integer mcMQId = mcMQ.getId();
					// 先去查询是否消费过
					Integer count = messageService.countMessageById(mcMQId);
					// 没有消费过
					if (0 == count) {
						Integer accountId = mcMQ.getAccountId();
						Integer amount = mcMQ.getPrice();
						Account account = new Account();
						account.setId(accountId);
						account.setAmount(amount);
						// 收钱
						accountService.updateAccountById(account);
						mcMQ.setStatus(0);
						System.out.println("新增前-----------------"+mcMQ);
						// 新增消息
						messageService.insertMessage(mcMQ);
						System.out.println("新增后-----------------"+mcMQ);
						RestTemplate restTemplate = this.getRestTemplate();
						// 请求参数
						//JSONObject jsonObject = new JSONObject();
						//jsonObject.put("messageId", mc.getId());
						//jsonObject.put("respCode", 200);
						//String url = "http://localhost:80/alipay/account/callback.do?param=" + jsonObject.toString();
						//ResponseEntity<Object> response = restTemplate.getForEntity(url, null);
						String url = "http://localhost:80/alipay/account/callback.do?param=" + mcMQ.getId();
						String response = restTemplate.getForObject(url, String.class);
						if("fail".equals(response)) {
							logger.error("回调失败。。。" + message);
							throw new RuntimeException("回调失败。。。" + message);
						}else {
							logger.info("回调成功。。。" + message);
						}
					} else {
						logger.info("#################异常转账。。。");
					}
				}
			}
		} catch (Exception e) {
			logger.error("消息消费失败。。。" + message);
			throw new RuntimeException("消息消费失败。。。" + message);
		}
	}

	/**
	 *   请求工具
	 * @return
	 */
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(3000);
		simpleClientHttpRequestFactory.setReadTimeout(3000);
		return new RestTemplate(simpleClientHttpRequestFactory);
	}
}
