package com.activeMQ.core.test4;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 消费者  
 * @author reyco
 *
 */
public class Consumer {
	private final String SELECT_1 = "age>21";
	
	private final String SELECT_2 = "color = 'blue'";
	
	private final String SELECT_3 = "age>21 AND color = 'blue'";
	
	private ConnectionFactory connectionFactory;

	private Connection connection;

	private Session session;

	private MessageConsumer Consumer;
	
	private Destination destination;
	
	public Consumer() throws Exception {
		init();
	}
	private void init() throws Exception {
		this.connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://192.168.2.108:61616");
		this.connection = this.connectionFactory.createConnection("reyco", "123456");
		this.connection.start();
		this.session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		this.destination = this.session.createQueue("first");
		//  过滤条件
		this.Consumer = this.session.createConsumer(this.destination,SELECT_3);
	}
	public void receiver() {
		try {
			this.Consumer.setMessageListener(new Listener());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Consumer c = new Consumer();
		c.receiver();
	}
	
	class Listener implements MessageListener{

		@Override
		public void onMessage(Message message) {
			try {
				if(message instanceof TextMessage) {
					System.out.println("message="+message.toString());
				}
				if(message instanceof MapMessage) {
					Message ms =(Message)message;
					System.out.println("ms="+ms.toString());
					System.out.println("age="+ms.getIntProperty("age"));
					System.out.println("color="+ms.getStringProperty("color"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
