package com.activeMQ.core.test4;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {

	private ConnectionFactory connectionFactory;

	private Connection connection;

	public Producer() throws Exception {
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
		Destination destination = session.createQueue("first");
		MapMessage cMap1 = session.createMapMessage();
		cMap1.setString("name", "zhang1");
		cMap1.setString("sal", "3100");
		cMap1.setStringProperty("color", "blue");
		cMap1.setIntProperty("age", 21);
		
		MapMessage cMap2 = session.createMapMessage();
		cMap2.setString("name", "zhang2");
		cMap2.setString("sal", "3200");
		cMap2.setStringProperty("color", "red");
		cMap2.setIntProperty("age", 22);
		
		MapMessage cMap3= session.createMapMessage();
		cMap3.setString("name", "zhang3");
		cMap3.setString("sal", "3300");
		cMap3.setStringProperty("color", "green");
		cMap3.setIntProperty("age", 23);
		
		MapMessage cMap4= session.createMapMessage();
		cMap4.setString("name", "zhang4");
		cMap4.setString("sal", "3400");
		cMap4.setStringProperty("color", "blue");
		cMap4.setIntProperty("age", 24);
		
		MessageProducer producer = session.createProducer(destination);
		
		producer.send(destination, cMap1);
		producer.send(destination, cMap2);
		producer.send(destination, cMap3);
		producer.send(destination, cMap4);
		close(connection);
	}
	public static void main(String[] args) throws Exception {
		Producer p = new Producer();
		p.send();
	}
}
