package com.reyco.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.reyco.rabbitmq.config.RabbitMqConfigration;
/**
 * 获取连接
 * @author reyco
 *
 */
public class ConnectionUtil {
	/**
	 * 获取连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		RabbitMqConfigration rc = new RabbitMqConfigration();
		ConnectionFactory cf = new ConnectionFactory();
		cf.setHost(rc.getHost());
		cf.setPort(rc.getPort());
		cf.setUsername(rc.getUsername());
		cf.setPassword(rc.getPassword());
		cf.setVirtualHost(rc.getVirtualHost());
		return cf.newConnection();
	}
	
}
