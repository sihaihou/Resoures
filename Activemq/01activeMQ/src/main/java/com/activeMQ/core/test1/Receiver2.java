package com.activeMQ.core.test1;

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
	 * 
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
			/**
			 * 消费者必须启动连接，否则无法处理消息
			 */
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("first");
			/**
			 * 通过Session对象创建消息的发送和接收对象(生产者和消费者)MessageConsumer
			 */
			consumer = session.createConsumer(destination);
			/**
			 * 注册监听器，注册后，列队的消息变化会自动触发监听器，接收消息并处理
			 */
			consumer.setMessageListener(new MessageListener() {
				/**
				 * 监听器一旦注册，永久有效-------consumer不关闭 处理消息方式：只要有消息未处理，自动调用onMessage方法
				 * 监听器可以注册若干:多个监听器，相当于集群 ActiveMQ自动的调用多个监听器，处理列队的消息，实现并行处理
				 */
				@Override
				public void onMessage(Message message) {
					try {
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
			// 阻塞当前代码，保证MessageListener不结束，如果结束，监听器自动关闭
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
