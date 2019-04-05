package com.activeMQ.core.test2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消费者  
 * @author reyco
 *
 */
public class Receiver {
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.108:61616");
		Connection connection = connectionFactory.createConnection("reyco","123456");
		connection.start();
		Session	session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("first");
		MessageConsumer consumer = session.createConsumer(destination);
		while(true) {
			TextMessage msg = (TextMessage) consumer.receive();
			//消费者session开启了事务,消费者必须提交事务
			//session.commit();
			//手动签收:接收端没有开启事务,签收模式为CLIENT_ACKNOWLEDGE时，需要收到签收msg的acknowledge方法收到签收
			msg.acknowledge();
			System.out.println("消费数据："+msg.getText());
		}
	}
}
