package com.reyco.rabbitmq.simple;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.reyco.rabbitmq.util.ConnectionUtil;
/**
 * 发送者
 * @author reyco
 *
 */
public class Provider {
	
	private final static String QUEUE = "first";
	/**
	 * 发送消息
	 * @param msg
	 * @param count
	 */
	public static void send(String msg,int count) {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			Channel channel = connection.createChannel();
			//参数1: 队列名称
			//参数2：durable是否持久化,rabbitmq默认为false,rabbitmq重启后消息丢失;true:消息会保存到erlang自带的数据库中，重启后可恢复。
			//参数3: 作用1：连接关闭后，是否自动删除队列;作用2：是否私有当前队列,如果私有，其它通道不可以访问当前队列。
			//参数4：是否自动删除
			//参数5：我们的一些其它参数
			channel.queueDeclare(QUEUE, false, false, false, null);
			for(int i=0;i<count;i++) {
				// 参数1：交换器
				// 参数2: 队列名称
				// 参数4：发送内容
				channel.basicPublish("", QUEUE, null, (msg+i).getBytes());
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
			send("rabbitmq hello....",10);
	}
}
