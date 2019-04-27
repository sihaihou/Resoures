package com.activeMQ.core.test5;

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
 * 消费者  ---订阅者1
 * @author reyco
 *
 */
public class Consumer1 {
	
	private ConnectionFactory connectionFactory;

	private Connection connection;

	private Session session;

	private MessageConsumer Consumer;
	
	private Destination destination;
	
	public Consumer1() throws Exception {
		init();
	}
	private void init() throws Exception {
		this.connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://192.168.2.108:61616");
		this.connection = this.connectionFactory.createConnection("reyco", "123456");
		this.connection.start();
		this.session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		this.destination = this.session.createTopic("topic1");
		//  过滤条件
		this.Consumer = this.session.createConsumer(this.destination);
	}
	public void receiver() {
		try {
			this.Consumer.setMessageListener(new Listener());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Consumer1 c = new Consumer1();
		c.receiver();
	}
	
	class Listener implements MessageListener{
		@Override
		public void onMessage(Message message) {
			try {
				if(message instanceof TextMessage) {
					TextMessage ms =(TextMessage)message;
					System.out.println("Consumer1: TextMessage="+ ms.getText());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}