package com.reyco.annotation.entity;
/**
 *  年级表
 * @author reyco
 *
 */
public class Grade {
	/**
	 * 年级编号
	 */
	private String no;
	/**
	 * 年级名称
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
