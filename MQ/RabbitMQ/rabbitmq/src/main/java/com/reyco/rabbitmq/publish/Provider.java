package com.reyco.rabbitmq.publish;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.reyco.rabbitmq.util.ConnectionUtil;

/**
 *  发布/订阅者模式
 * @author reyco
 *
 */
public class Provider {
	/**
	 * 交换器
	 */
	private final static String EXCHANGE_NAME = "test_fanout_exchange";
	
	public static void send(String msg,int count) {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			Channel channel = connection.createChannel();
			// 参数1: 交换器名称
			// 参数2：路由键：fanout：不处理路由键
			
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
			for(int i=0;i<count;i++) {
				// 参数1：交换器
				// 参数2: 队列名称
				// 参数4：发送内容
				channel.basicPublish(EXCHANGE_NAME, "", null, (msg+i).getBytes());
			}
			System.out.println("发送成功...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("发送失败...");
		}finally {
			if(null != connection) {
				try {
					connection.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
			send("rabbitmq hello....",20);
	}
}
