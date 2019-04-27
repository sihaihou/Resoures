package com.reyco.dubbo.domain;

import java.io.Serializable;

/**
 * 用户实体类
 * @author reyco
 */
public class Account implements Serializable{
	private Integer id;
	private String name;
	private String password;
	private String path;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(Integer id, String name, String password, String path) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "Account [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
