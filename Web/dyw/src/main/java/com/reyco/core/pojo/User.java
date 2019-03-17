package com.reyco.core.pojo;

public class User {
	/**
	 * 用户登录ip
	 */
	private String ip;
	/**
	 * 用户ip所在城市
	 */
	private String city;
	/**
	 * 用户账号
	 */
	private String name;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String ip, String name) {
		super();
		this.ip = ip;
		this.name = name;
	}
	public User(String ip, String city, String name) {
		super();
		this.ip = ip;
		this.city = city;
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [ip=" + ip + ", city=" + city + ", name=" + name + "]";
	}
}
