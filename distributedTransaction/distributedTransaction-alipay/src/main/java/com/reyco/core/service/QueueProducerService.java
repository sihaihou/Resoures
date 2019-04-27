package com.reyco.core.service;

import com.reyco.core.domain.MessageMQ;

public interface QueueProducerService {
	/**
	  *  发送Object queue消息
	 * @param message 消息内容
	 * @return
	 */
	public void sendObjectMessage(MessageMQ message);
	/**
	  *  发送text queue消息
	 * @param message 消息内容
	 * @return
	 */
	public void sendTextMessage(String message);
	
}
