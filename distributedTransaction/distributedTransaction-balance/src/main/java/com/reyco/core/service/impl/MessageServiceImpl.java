package com.reyco.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.MessageDao;
import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;
		
	@Override
	public Integer countMessageById(Integer id) {
		return messageDao.countMessageById(id);
	}
	
	@Override
	public void insertMessage(MessageMQ message) {
		messageDao.insertMessage(message);
	}

}
