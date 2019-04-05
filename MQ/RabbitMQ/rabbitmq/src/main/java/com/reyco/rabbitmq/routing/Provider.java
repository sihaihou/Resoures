package com.reyco.rabbitmq.routing;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.reyco.rabbitmq.util.ConnectionUtil;

/**
 *  路由键
 * @author reyco
 *
 */
public class Provider {
	/**
	 * 交换器
	 */
	private final static String EXCHANGE_NAME = "test_direct_exchange";
	/**
	 * 路由键
	 */
	private final static String ROUTINGKEY="info";
	
	public static void send(String msg,int count) {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			Channel channel = connection.createChannel();
			// 参数1: 交换器名称
			// 参数2：路由键：fanout：不处理路由键
			
			channel.exchangeDeclare(EXCHANGE_NAME, "direct");
			for(int i=0;i<count;i++) {
				channel.basicPublish(EXCHANGE_NAME, ROUTINGKEY, null, (msg+i).getBytes());
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
			send("rabbitmq hello....",2);
	}
}
