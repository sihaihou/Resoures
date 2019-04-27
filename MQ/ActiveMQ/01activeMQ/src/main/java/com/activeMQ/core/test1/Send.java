package com.activeMQ.core.test1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Send {
	/** 
	 *   发送消息
	 * @param message  消息内容
	 */
	public void sendText(String message) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer producer = null;
		TextMessage msg = null;
		try {
			/**
			 * 1,建立:ConnectionFactory工厂对象 ---- url: tcp://ip:61616 没有参数:默认localhost
			 * 一个参数:连接的地址 url 三个参数：用户名、密码、以及连接的地址url
			 */
			connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://192.168.2.108:61616");
			/**
			 * 2,通过ConnectionFactory对象创建Connection连接,并且调用start方法开启连接,Connection默认关闭。
			 * producer在发送信息的时候会检查是否启动了连接，如未启动，自动启动.建议启动
			 */
			connection = connectionFactory.createConnection();
			connection.start();
			/**
			 * 3,通过Connection对象创建Session会话(上下文环境对象),用于接收消息，参数1:是否开启事务，参数2:签收模式，一般我们设置自动签收
			 * 第一个参数:是否支持事务，如果为true，则会忽略第二个参数，自动被jms服务器设置为SESSION_TRANSACTED 参数2：
			 * AUTO_ACKNOWLEDGE:自动签收,消费者消费后自动确认; CLIENT_ACKNOWLEDGE：客户端手动确认，消费者消费后必须手动确认。
			 * DUPS_OK_ACKNOWLEDGE：有副本的客户端手动确认。
			 */
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			/**
			 * 4,通过Session对象创建Destination对象，指的是一个客户端用来指定生产者信息和消费者信息来源的对象，
			 * 在PTP模式中，Destination被称作为Queue即队列， 在sub模式中，Destination被称作为主题。
			 */
			destination = session.createQueue("first");
			/**
			 * 5,通过Session对象创建消息的发送和接收对象(生产者和消费者)MessageProducer
			 */
			producer = session.createProducer(null);
			/**
			 * 6,通过MessageProducer的setDeliveryMode方法为其设置持久化特性和非持久化特性(DeliveryMode)
			 */
			// producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			/**
			 * 7,使用JMS规范的TextMessage形式创建数据(通过Session对象)，并使用MessageProducer的send方法发送数据，同理客户端使用receive方法进行接收数据。
			 */
			msg = session.createTextMessage("消息内容:"+message);

			/**
			 * 8,send 第一个参数：目标地址 第二个参数：具体的数据信息 第三个参数：传输数据的模式 第四个参数：优先级 第五个参数：消息的过期时间
			 */
			producer.send(destination, msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/**
			 * 9,关闭资源:producer,session,connection
			 */
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
		send.sendText("系统信息!");
	}
}
