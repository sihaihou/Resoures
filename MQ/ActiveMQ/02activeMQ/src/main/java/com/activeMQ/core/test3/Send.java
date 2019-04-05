package com.activeMQ.core.test3;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 发布/订阅模式:不会存储主题消息
 *       消息立即发送，如果没有订阅者，该消息会弃用，立即删除。
 * @author reyco
 */
public class Send {
	/** 
	 *   发送消息
	 * @param message  消息内容
	 */
	public void sendText(String message,Integer size) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer producer = null;
		TextMessage msg = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory("reyco", "123456", "tcp://39.107.247.102:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("first");
			producer = session.createProducer(null);
			for(int i=0;i<size;i++) {
				msg = session.createTextMessage("消息内容:"+message+"\t\r"+i);
				/**
				 * 8,send 
				 *        第一个参数：目标地址 
				 *        第二个参数：具体的数据信息
				 *        第三个参数：持久化方式:DeliveryMode.PERSISTENT持久化就是数据保存到数据库中;DeliveryMode.NON_PERSISTENT不持久化，数据保存在内存中。
				 *        第四个参数：优先级:priority可以为 0~9 的整数数值，值越大表示权重越高，默认值为 4。 
				 *        第五个参数：消息的过期时间:消息过期后，默认会将失效消息保存到死信队列DLQ。 
				 *            死信队列DLQ:消息过期后，默认会将失效消息保存到死信队列DLQ。 不持久化的消息，在超时后直接丢弃，不会保存到死信队列中。 死信队列名称可配置，死信队列中的消息不能恢复。 
				 */
				producer.send(destination, msg,DeliveryMode.NON_PERSISTENT,i,1000*100);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		send.sendText("系统信息!",5);
	}
}
