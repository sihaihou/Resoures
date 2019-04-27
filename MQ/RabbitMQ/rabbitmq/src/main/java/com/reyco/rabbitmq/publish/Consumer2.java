package com.reyco.rabbitmq.publish;

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
 * 发布/订阅者模式
 * 
 * @author reyco
 *
 */
public class Consumer2 {
	/**
	 * 队列
	 */
	private final static String QUEUE = "test_fanout_exchange_queue2";
	/**
	 * 交换器
	 */
	private final static String EXCHANGE_NAME = "test_fanout_exchange";
	/**
	 * 接收消息
	 */
	public static void recver() {
		try {
			Connection connection = ConnectionUtil.getConnection();
			final Channel channel= connection.createChannel();
			channel.queueDeclare(QUEUE, false, false, false, null);
			channel.queueBind(QUEUE, EXCHANGE_NAME, "");
			// 每次只发一条prefetch
			channel.basicQos(1);;
			DefaultConsumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String msg = new String(body);
					System.out.println("【2】接收："+msg);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						// 手动回执
						channel.basicAck(envelope.getDeliveryTag(), true);
					}
				}
			};
			boolean autoAck= false;
			// 监听队列:
			// 参数1:队列名称
			// 参数2：
			//			true:自动确认模式：消息发送给消费者，消息就会消失，正在执行的消费者就会丢失正在处理的消息;
			// 			false:手动确认模式：消费者挂掉，消息会交给其它消费者处理。
			// 参数3:消费者
			channel.basicConsume(QUEUE, autoAck,consumer);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		recver();
	}
}
