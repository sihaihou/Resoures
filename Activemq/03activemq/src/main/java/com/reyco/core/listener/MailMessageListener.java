package com.reyco.core.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reyco.core.domain.MailContent;
import com.reyco.core.service.QueueProducerService;

@Component("mailListener")
public class MailMessageListener implements MessageListener {
	
	@Autowired
	private QueueProducerService queueProducerService;
	
	@Override
	public void onMessage(Message message) {
		try {
			if(message instanceof ObjectMessage) {
				ObjectMessage om = (ObjectMessage)message;
				Object data = om.getObject();
				if(data instanceof MailContent) {
					MailContent mc= (MailContent)data;
					queueProducerService.sendMail(mc);
				}
			}else {
				System.out.println( message );
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
