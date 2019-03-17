package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("all")
public class Vip implements Serializable{
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 类别名称
	 */
	private String name;
	/**
	 * 
	 */
	private Integer lowVip;
	/**
	 * 
	 */
	private Integer higVip;
	/**
	 * 
	 */
	private Integer status;
	
	/**
	 * 类别备注
	 */
	private String desc;
	private Date gmtCreate;
	private Date gmtModified;
	
	public Vip() {
		// TODO Auto-generated constructor stub
	}
	public Vip(Integer id, String name, Integer lowVip, Integer higVip, String desc, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.name = name;
		this.lowVip = lowVip;
		this.higVip = higVip;
		this.desc = desc;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	public Vip(Integer id, String name, Integer lowVip, Integer higVip, Integer status, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.lowVip = lowVip;
		this.higVip = higVip;
		this.status = status;
		this.desc = desc;
	}
	public Vip(String name, Integer lowVip, Integer higVip, Integer status, String desc) {
		super();
		this.name = name;
		this.lowVip = lowVip;
		this.higVip = higVip;
		this.status = status;
		this.desc = desc;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getLowVip() {
		return lowVip;
	}
	public void setLowVip(Integer lowVip) {
		this.lowVip = lowVip;
	}
	public Integer getHigVip() {
		return higVip;
	}
	public void setHigVip(Integer higVip) {
		this.higVip = higVip;
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
	@Override
	public String toString() {
		return "Vip [id=" + id + ", name=" + name + ", lowVip=" + lowVip + ", higVip=" + higVip + ", desc=" + desc
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
}
