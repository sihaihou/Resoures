package com.reyco.core.domain;

import java.io.Serializable;

/**
  *                 账号
 * @author reyco
 *
 */
public class Account extends Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4940069127639365173L;
	/**
	 * 账号金额
	 */
	private Integer amount;

	public Account() {
	}

	public Account(Integer amount) {
		super();
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [amount=" + amount + "]";
	}
}
