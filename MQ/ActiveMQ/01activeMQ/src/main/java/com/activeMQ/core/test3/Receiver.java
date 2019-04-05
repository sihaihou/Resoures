package com.activeMQ.core.test3;

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
		/**
		 * 1,建立:ConnectionFactory工厂对象,参数：用户名、密码、以及连接的地址，均使用默认即可，默认url: tcp://ip:61616
		 *   tcp://192.168.2.108:61616
		 */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.108:61616");
		/**
		 * 2,通过ConnectionFactory对象创建Connection连接,并且调用start方法开启连接，Connection默认关闭。参数：用户名、密码.
		 */
		Connection connection = connectionFactory.createConnection("reyco","123456");
		connection.start();
		/**
		 * 3,通过Connection对象创建Session会话(上下文环境对象),用于接收消息，参数1:是否开启事务，参数2:签收模式，一般我们设置自动签收
		 *        第一个参数:是否支持事务，如果为true，则会忽略第二个参数，自动被jms服务器设置为SESSION_TRANSACTED
		 */
		Session	session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
		/**
		 * 4,通过Session对象创建Destination对象，指的是一个客户端用来指定生产者信息和消费者信息来源的对象，
		 *      在PTP模式中，Destination被称作为Queue即队列，
		 *      在sub
		 */
		Destination destination = session.createQueue("first");
		/**
		 * 5,通过Session对象创建消息的发送和接收对象(生产者和消费者)MessageProducer/
		 */
		MessageConsumer consumer = session.createConsumer(destination);
		/**
		 * 6,使用JMS规范的TextMessage形式创建数据(通过Session对象)，并使用MessageProducer的send方法发送数据，同理客户端使用receive方法进行接收数据。
		 */
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
