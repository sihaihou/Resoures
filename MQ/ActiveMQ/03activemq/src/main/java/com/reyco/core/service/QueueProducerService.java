package com.reyco.core.service;

import com.reyco.core.domain.MailContent;

public interface QueueProducerService {
	/**
	 * 发送queue消息
	 * @param msg
	 * @return
	 */
	public void sendTextMessage(MailContent mailContent);
	/**
	 * 发送邮件
	 * @param mailContent  邮件实体
	 */
	public void sendMail(MailContent mailContent);
	
	
	
}
