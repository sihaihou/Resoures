package com.reyco.rabbitmq.confirm2;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.reyco.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * confirm异步
 * 
 * @author reyco
 *
 */
public class Consumer1 {
	private final static String QUEUE = "test_confirmQueue2";

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
			channel.basicConsume(QUEUE, true, new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					System.out.println("接收："+new String(body));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		recver();
	}
}
