package com.reyco.rabbitmq.tx;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.reyco.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * 事务
 * 
 * @author reyco
 *
 */
public class Consumer1 {
	private final static String QUEUE = "test_txQueue";

	/**
	 * 接收消息
	 */
	public static void recver() {
		Connection connection = null;
		Channel channel = null;
		try {
			connection = ConnectionUtil.getConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE, false, false, false, null);
			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(QUEUE, true, consumer);
			while (true) {
				Delivery delivery = consumer.nextDelivery();
				String msg = new String(delivery.getBody());
				System.out.println("接收：" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != channel) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				try {
					connection.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		recver();
	}
}
