package com.reyco.annotation.entity;
/**
 *  �꼶��
 * @author reyco
 *
 */
public class Grade {
	/**
	 * �꼶���
	 */
	private String no;
	/**
	 * �꼶����
	 */
	private String name;
	public Grade() {
	}
	public Grade(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
