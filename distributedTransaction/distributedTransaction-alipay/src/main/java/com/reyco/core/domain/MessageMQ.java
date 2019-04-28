package com.reyco.core.domain;

import java.io.Serializable;
/**
 * message
 * @author reyco
 *
 */
public class MessageMQ implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6446938774063584876L;
	/**
	 * message的id
	 */
	private Integer id;
	/**
	 *  转账id
	 */
	private Integer accountId;
	/**
	 * 转账金额
	 */
	private Integer price;
	/**
	 *   状态码: 1:unconfirm  0:confirm
	 */
	private Integer status;
	
	public MessageMQ() {
	}
	public MessageMQ(Integer accountId, Integer price, Integer status) {
		this.accountId = accountId;
		this.price = price;
		this.status = status;
	}
	public MessageMQ(Integer id, Integer accountId, Integer price, Integer status) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.price = price;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", accountId=" + accountId + ", price=" + price + ", status=" + status + "]";
	}
}
