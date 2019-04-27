package com.reyco.rabbitmq.confirm;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.reyco.rabbitmq.util.ConnectionUtil;

/**
 * confirm同步
 * 
 * @author reyco
 *
 */
public class Provider {

	private final static String QUEUE = "test_confirmQueue";

	/**
	 * 发送消息
	 * 
	 * @param msg
	 * @param count
	 */
	public static void send(String msg,int count) {
		Connection connection = null;
		Channel channel = null;
		try {
			connection = ConnectionUtil.getConnection();
			channel = connection.createChannel();
			channel.queueDeclare(QUEUE, false, false, false, null);
			channel.confirmSelect();
			for(int i=0;i<count;i++) {
				channel.basicPublish("", QUEUE, null, msg.getBytes());
			}
			if(!channel.waitForConfirms()) {
				System.out.println("发送失败...");
			}else {
				System.out.println("发送成功...");
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
		send("rabbitmq hello....",10);
	}
}
