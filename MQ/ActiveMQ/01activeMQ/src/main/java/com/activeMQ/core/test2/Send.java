package com.activeMQ.core.test2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Send {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.108:61616");
		Connection connection = connectionFactory.createConnection("reyco","123456");
		connection.start();
		Session	session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("first");
		MessageProducer producer = session.createProducer(null);
		/**
		 * 6,通过MessageProducer的setDeliveryMode方法为其设置持久化特性和非持久化特性(DeliveryMode)
		 */
		//producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		for(int i=0;i<10;i++) {
			TextMessage msg = session.createTextMessage("我是消息内容："+i);
			producer.send(destination,msg);
		}
		//Session开启事务，需要手动提交事务
		session.commit();
		if(null != connection) {
			connection.close();
		}
	}
}
