package com.activeMQ.core.test2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 发布/订阅模式:不会存储主题消息
 *       消息立即发送，如果没有订阅者，该消息会弃用，立即删除。
 * @author reyco
 */
public class Send {
	/** 
	 *   发送消息
	 * @param message  消息内容
	 */
	public void sendText(String message,Integer size) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer producer = null;
		TextMessage msg = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://192.168.2.108:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//创建订阅者/主题目的地
			destination = session.createTopic("first");
			producer = session.createProducer(null);
			for(int i=0;i<size;i++) {
				msg = session.createTextMessage("消息内容:"+message+"\t\r"+i);
				producer.send(destination, msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != producer) {
					producer.close();
				}
				if (null != session) {
					session.close();
				}
				if (null != connection) {
					connection.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Send send = new Send();
		send.sendText("系统信息!",5);
	}
}
