package com.reyco.core.springmvc.entity;

import java.io.Serializable;

/**
 * Base实体类
 * @author reyco
 *
 */
public class Base implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	public Base() {
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
