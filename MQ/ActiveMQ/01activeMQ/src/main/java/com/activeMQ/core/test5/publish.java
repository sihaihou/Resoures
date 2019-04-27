package com.activeMQ.core.test5;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 发布者
 * @author reyco
 *
 */
public class publish {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public publish() throws Exception {
		init();
	}
	private void init() throws Exception {
		this.connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://192.168.2.108:61616");
		this.connection = this.connectionFactory.createConnection("reyco", "123456");
	}
	/**
	 * close Connection
	 * 
	 * @param connection
	 * @throws JMSException
	 */
	private void close(Connection connection) throws JMSException {
		if (null != connection) {
			connection.close();
		}
	}
	public void send() throws JMSException {
		Connection connection = this.connection;
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createTopic("topic1");
		TextMessage msg = session.createTextMessage("订阅消息:系统信息");
		MessageProducer producer = session.createProducer(destination);
		producer.send(destination, msg);
		close(connection);
	}
	public static void main(String[] args) throws Exception {
		publish p = new publish();
		p.send();
	}
}
