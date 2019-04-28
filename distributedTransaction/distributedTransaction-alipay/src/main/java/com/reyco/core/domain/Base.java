package com.reyco.core.domain;

import java.util.Date;

public class Base {
	/**
	 *    主键id
	 */
	private Integer id;
	/**
	 * name
	 */
	private String name;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	public Base(Integer id, String name, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.name = name;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	public Base() {
		// TODO Auto-generated constructor stub
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
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	@Override
	public String toString() {
		return "Base [id=" + id + ", name=" + name + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
}
