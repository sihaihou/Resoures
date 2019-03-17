package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("all")
public class Nav implements Serializable{
	private Integer id;
	/**
	 * 导航栏名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String desc;
	/**
	 * 状态
	 */
	private Integer status;
	private Date gmtCreate;
	private Date gmtModified;
	public Nav() {
	}
	public Nav(Integer id, String name, String desc, Integer status, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.status = status;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		return "Nav [id=" + id + ", name=" + name + ", desc=" + desc + ", status=" + status + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
}
