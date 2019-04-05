package com.activeMQ.core.test2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消费者
 * 
 * @author reyco
 */
public class Receiver2 {
	/**
	 * 接收消息
	 * @return
	 * @throws JMSException
	 */
	public void reveiverMessage() throws JMSException {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageConsumer consumer = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://192.168.2.108:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			destination = session.createTopic("first");
			consumer = session.createConsumer(destination);
			consumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						message.acknowledge();
						if (message instanceof TextMessage) {
							TextMessage tmsg = (TextMessage) message;
							String msg = tmsg.getText().toString();
							System.out.println(msg);
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != consumer) {
					consumer.close();
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
		Receiver2 receiver = new Receiver2();
		receiver.reveiverMessage();
	}
}
