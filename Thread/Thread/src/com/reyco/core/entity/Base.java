package com.reyco.core.entity;

public class Base {

	private String name;
	private String password;

	public Base() {
		// TODO Auto-generated constructor stub
	}

	public Base(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Base [name=" + name + ", password=" + password + "]";
	}
}
