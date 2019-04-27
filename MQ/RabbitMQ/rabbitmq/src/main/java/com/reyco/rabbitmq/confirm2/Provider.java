package com.reyco.rabbitmq.confirm2;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.reyco.rabbitmq.util.ConnectionUtil;

/**
 * confirm异步
 * 
 * @author reyco
 *
 */
public class Provider {

	private final static String QUEUE = "test_confirmQueue2";

	/**
	 * 发送消息
	 * 
	 * @param msg
	 * @param count
	 */
	public static void send(String msg) {
		Connection connection = null;
		Channel channel = null;
		try {
			connection = ConnectionUtil.getConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE, false, false, false, null);
			channel.confirmSelect();
			//为确认的消息标识
			final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
			channel.addConfirmListener(new ConfirmListener() {
				/**
				 * 没有问题的
				 */
				public void handleNack(long deliveryTag, boolean multiple) throws IOException {
					if(multiple) {
						System.out.println("handleNack---multiple");
						confirmSet.headSet(deliveryTag).clear();;
					}else {
						System.out.println("handleNack---multiple---false");
						confirmSet.remove(deliveryTag);
					}
				}
				/**
				 * 有问题的
				 */
				public void handleAck(long deliveryTag, boolean multiple) throws IOException {
					if(multiple) {
						System.out.println("handleAck---multiple");
						confirmSet.headSet(deliveryTag+1).clear();
					}else {
						System.out.println("handleAck---multiple---false");
						confirmSet.remove(deliveryTag);
					}
				}
			});
			for(int i=0;i<10;i++) {
				long seqNo = channel.getNextPublishSeqNo();
				channel.basicPublish("", QUEUE, null, msg.getBytes());
				confirmSet.add(seqNo);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			System.out.println("发送失败..."+e.getMessage());
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
		send("rabbitmq hello....");
	}
}
