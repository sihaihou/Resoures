package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 类别
 * @author reyco
 *
 */
public class SystemInfo implements Serializable{
	private Integer id;
	private String infoKey;
	private String infoValue;
	private Integer status;
	private String desc;
	private Date  gmtCreate;
	private Date gmtModified;
	public SystemInfo() {
		// TODO Auto-generated constructor stub
	}
	public SystemInfo(Integer id, String infoKey, String infoValue, Integer status, String desc, Date gmtCreate,
			Date gmtModified) {
		super();
		this.id = id;
		this.infoKey = infoKey;
		this.infoValue = infoValue;
		this.status = status;
		this.desc = desc;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfoKey() {
		return infoKey;
	}
	public void setInfoKey(String infoKey) {
		this.infoKey = infoKey;
	}
	public String getInfoValue() {
		return infoValue;
	}
	public void setInfoValue(String infoValue) {
		this.infoValue = infoValue;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
		return "SystemInfo [id=" + id + ", infoKey=" + infoKey + ", infoValue=" + infoValue + ", status=" + status
				+ ", desc=" + desc + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
}
