package com.activeMQ.core.test1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消费者
 * 
 * @author reyco
 */
public class Receiver {
	/**
	 * 接收消息
	 * @return
	 * @throws JMSException
	 */
	public String reveiverMessage() throws JMSException {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageConsumer consumer = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory(
					"reyco", "123456", "tcp://39.107.247.102:61616");
			connection = connectionFactory.createConnection();
			//消费者必须启动连接，否则无法处理消息
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("first");
			/**
			 * 通过Session对象创建消息的发送和接收对象(生产者和消费者)MessageConsumer
			 */
			 consumer = session.createConsumer(destination);
			 /**
			 * 使用JMS规范的TextMessage形式创建数据(通过Session对象)，并使用MessageProducer的send方法发送数据，同理客户端使用receive方法进行接收数据。
			 */
			TextMessage msg = (TextMessage) consumer.receive();
			return msg.getText().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
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
		Receiver receiver = new Receiver();
		String reveiverMessage = receiver.reveiverMessage();
		System.out.println(reveiverMessage);
	}
}
