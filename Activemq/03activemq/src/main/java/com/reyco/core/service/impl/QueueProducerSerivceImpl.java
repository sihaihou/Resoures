package com.reyco.core.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.reyco.core.domain.MailContent;
import com.reyco.core.service.QueueProducerService;

@Service("queueProducerService")
public class QueueProducerSerivceImpl implements QueueProducerService {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	@Autowired 
	private TaskExecutor taskExecutor;
	@Override
	public void sendTextMessage(MailContent mailContent) {
		mailContent.setCarbonCopy("18307200213@163.com");
		//设置发送地址
		this.jmsTemplate.setDefaultDestinationName("qq-mail");
		jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(mailContent);
            }
        });
	}
	/**
	 * 发送邮件
	 * @param mailContent
	 */
	public void sendMail(MailContent mailContent) {
		System.out.println("sendMail--------mailContent-----"+mailContent);
		try {
			this.simpleMailMessage.setFrom(mailContent.getCarbonCopy());
			this.simpleMailMessage.setSubject(mailContent.getSubject());
			StringBuffer messageText=new StringBuffer(); //内容以html格式发送,防止被当成垃圾邮件
			messageText.append("Hi，你好，这是不哭死神的测试用例,").append("此测试用例的内容为:"+mailContent.getText());
			this.simpleMailMessage.setText("<h2>"+messageText.toString()+"</h2>");
			this.simpleMailMessage.setTo(mailContent.getRecipients());
			//javaMailSender.send(simpleMailMessage);
			addSendMailTask(simpleMailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * @desc 使用多线程发送邮件
     * @param message MimeMessage邮件封装类
     */
    private void addSendMailTask(final SimpleMailMessage message){
        try{
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    javaMailSender.send(message);
                    System.out.println("邮件已发送！");
                }
            });
        }catch (Exception e){
        	System.out.println("邮件发送异常,邮件详细信息为:"+e.getMessage());
        }finally {
        	
		}
    }
    
    
    
}
