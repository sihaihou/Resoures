package com.reyco.rabbitmq.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
/**
 * rabbitmq配置
 * @author reyco
 *
 */
public class RabbitMqConfigration implements Serializable{
	private String host;
	private int port;
	private String username;
	private String password;
	private String virtualHost;
	static Properties pros=null;
	/**
	 * 只会在加载JDBCUtil类的时候调用一次
	 */
	static {    
		pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("rabbitmq.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public RabbitMqConfigration() {
		super();
		this.host = pros.getProperty("rabbitmq.host");
		this.port = Integer.valueOf(pros.getProperty("rabbtmq.port"));
		this.username = pros.getProperty("rabbitmq.username");
		this.password = pros.getProperty("rabbitmq.password");
		this.virtualHost = pros.getProperty("rabbitmq.virtualHost");
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVirtualHost() {
		return virtualHost;
	}
	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}
	@Override
	public String toString() {
		return "RabbitMqConfigration [host=" + host + ", port=" + port + ", username=" + username + ", password="
				+ password + ", virtualHost=" + virtualHost + "]";
	}
}
