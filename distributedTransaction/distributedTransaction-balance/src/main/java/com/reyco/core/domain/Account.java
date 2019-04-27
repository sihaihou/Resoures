package com.reyco.core.domain;

import java.io.Serializable;
/**
 *  	账号
 * @author reyco
 *
 */
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4940069127639365173L;
	/**
	 * 账号id
	 */
	private Integer id;
	/**
	 * 账号名称
	 */
	private String name;
	/**
	 * 账号金额
	 */
	private Integer amount;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(Integer id, String name, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
}
