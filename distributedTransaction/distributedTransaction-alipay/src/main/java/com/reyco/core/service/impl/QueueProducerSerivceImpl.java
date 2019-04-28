package com.reyco.core.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.QueueProducerService;

@Service("queueProducerService")
public class QueueProducerSerivceImpl implements QueueProducerService {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	@Override
	public void sendObjectMessage(MessageMQ message) {
		//设置发送地址
		this.jmsTemplate.setDefaultDestinationName("distributedTransaction-message");
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(message);
			}
		});
	}
	@Override
	public void sendTextMessage(String message) {
		//设置发送地址
		this.jmsTemplate.setDefaultDestinationName("text-message");
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
