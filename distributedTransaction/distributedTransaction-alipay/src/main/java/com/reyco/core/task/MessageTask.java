package com.reyco.core.task;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.QueueProducerService;

/**
  * 消费信息任务
 * 
 * @author reyco
 *
 */
public class MessageTask {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 信息集合
	 */
	private List<MessageMQ> messages;
	
	private QueueProducerService queueProducerService;

	public void setMessages(List<MessageMQ> messages) {
		this.messages = messages;
	}
	public void setQueueProducerService(QueueProducerService queueProducerService) {
		this.queueProducerService = queueProducerService;
	}
	public void run() {
		Integer size = messages.size();
		Integer countSize = this.getCountSize(size);
		Integer threalPoolSize = size / countSize + 1;
		List<MessageMQ> newMessages = new ArrayList<>();
		for (int i = 0; i < threalPoolSize; i++) {
			if((i+1) == threalPoolSize) {
				int startIndex =  i * countSize;
				int endIndex = size;
				newMessages = messages.subList(startIndex, endIndex);
			}else {
				int startIndex = i * countSize;
				int endIndex = (i+1) * countSize;
				newMessages = messages.subList(startIndex, endIndex);
			}
			logger.info("################newMessages size################"+newMessages.size());
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(MessageMQ message : messages) {
						logger.info("################定时任务向MQ发送消息################"+message);
						queueProducerService.sendObjectMessage(message);
					}				
				}
			}).start();
		}

	}
	/**
	  *    获取每个线程池执行任务数
	 * 
	 * @param messages
	 * @return
	 */
	private Integer getCountSize(int size) {
		Integer countSize = 10;
		if (null == messages) {
			return 0;
		}
		if (size < 5) {
			countSize = 5;
		} else if (size >= 5 && size < 33) {
			countSize = 5;
		} else if (size >= 33 && size < 133) {
			countSize = 10;
		} else if (size >= 133 && size < 533) {
			countSize = 20;
		} else if (size >= 533 && size < 1333) {
			countSize = 30;
		} else if (size >= 1333 && size < 5000) {
			countSize = 60;
		} else {
			countSize = 200;
		}
		return countSize;
	}

}
