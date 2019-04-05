package com.reyco.rabbitmq.workfair;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.reyco.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * 接收者
 * 
 * @author reyco
 *
 */
public class Consumer2 {
	private final static String QUEUE = "first";

	/**
	 * 接收消息
	 */
	public static void recver() {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			final Channel channel= connection.createChannel();
			channel.queueDeclare(QUEUE, false, false, false, null);
			// 每次只发一条
			channel.basicQos(1);
			Consumer consumer = new DefaultConsumer(channel) {
				//消息到达会触发这个方法
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
						// 手动确认消息
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
