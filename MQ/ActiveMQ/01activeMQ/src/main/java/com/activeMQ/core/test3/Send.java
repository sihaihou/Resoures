package com.activeMQ.core.test3;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Send {
	public static void main(String[] args) throws Exception {
		/**
		 * 1,建立:ConnectionFactory工厂对象,参数：用户名、密码、以及连接的地址，均使用默认即可，默认url: tcp://ip:61616
		 */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.2.108:61616");
		/**
		 * 2,通过ConnectionFactory对象创建Connection连接,并且调用start方法开启连接，Connection默认关闭。参数：用户名、密码
		 */
		Connection connection = connectionFactory.createConnection("reyco","123456");
		connection.start();
		/**
		 * 3,通过Connection对象创建Session会话(上下文环境对象),用于接收消息，参数1:是否开启事务，参数2:签收模式，一般我们设置自动签收
		 *   一个参数:是否支持事务，如果为true，则会忽略第二个参数，自动被jms服务器设置为SESSION_TRANSACTED
		 */
		Session	session = connection.createSession(Boolean.TRUE, Session.CLIENT_ACKNOWLEDGE);
		/**
		 * 4,通过Session对象创建Destination对象，指的是一个客户端用来指定生产者信息和消费者信息来源的对象，
		 *      在PTP模式中，Destination被称作为Queue即队列，
		 *      在sub
		 */
		Destination destination = session.createQueue("first");
		/**
		 * 5,通过Session对象创建消息的发送和接收对象(生产者和消费者)MessageProducer/
		 */
		MessageProducer producer = session.createProducer(null);
		/**
		 * 6,通过MessageProducer的setDeliveryMode方法为其设置持久化特性和非持久化特性(DeliveryMode)
		 */
		//producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		/**
		 * 7,使用JMS规范的TextMessage形式创建数据(通过Session对象)，并使用MessageProducer的send方法发送数据，同理客户端使用receive方法进行接收数据。
		 */
		for(int i=0;i<10;i++) {
			TextMessage msg = session.createTextMessage("我是消息内容："+i);
			/**
			 * 第一个参数：目标地址
			 * 第二个参数：具体的数据信息
			 * 第三个参数：传输数据的模式
			 * 第四个参数：优先级
			 * 第五个参数：消息的过期时间
			 */
			producer.send(destination,msg);
		}
		//Session开启事务，需要手动提交事务
		session.commit();
		/**
		 * 8,关闭连接
		 */
		if(null != connection) {
			connection.close();
		}
	}
}
