package com.reyco.rabbitmq.topic;

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
 * topic模式
 * 
 * @author reyco
 *
 */
public class Consumer1 {
	/**
	 * 队列
	 */
	private final static String QUEUE = "test_topic_exchange_queue1";
	/**
	 * 交换器
	 */
	private final static String EXCHANGE_NAME = "test_topic_exchange";
	/**
	 * 路由键
	 */
	private final static String ROUTINGKEY="goods.info";
	/**
	 * 接收消息
	 */
	public static void recver() {
		try {
			Connection connection = ConnectionUtil.getConnection();
			final Channel channel= connection.createChannel();
			channel.queueDeclare(QUEUE, false, false, false, null);
			//
			channel.queueBind(QUEUE, EXCHANGE_NAME, ROUTINGKEY);
			channel.basicQos(1);;
			DefaultConsumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String msg = new String(body);
					System.out.println("【1】接收："+msg);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						channel.basicAck(envelope.getDeliveryTag(), true);
					}
				}
			};
			boolean autoAck= false;
			channel.basicConsume(QUEUE, autoAck,consumer);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		recver();
	}
}
