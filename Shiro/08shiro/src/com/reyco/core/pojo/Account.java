package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("all")
public class Account implements Serializable {
	/**
	 * 用户id
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 盐值
	 */
	private String salt;
	/**
	 * 角色id
	 */
	private Integer rid;
	public Account() {
	}
	public Account(Integer id, String username, String password, String salt, Integer rid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.rid = rid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", rid="
				+ rid + "]";
	}
}
