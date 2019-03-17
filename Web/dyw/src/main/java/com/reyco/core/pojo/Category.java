package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 类别列表
 * @author reyco
 *
 */
@SuppressWarnings("all")
public class Category implements Serializable{
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 类别名称
	 */
	private String name;
	/**
	 * 该类别有多少正常文件
	 */
	private Integer activeQuantity;
	/**
	 * 该类别有多少文件
	 */
	private Integer quantity;
	/**
	 * 类别备注
	 */
	private String desc;
	/**
	 * 类别状态
	 */
	private Integer status;
	/**
	 * 状态页面显示
	 */
	private String status_desc;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	public Category() {
	}
	public Category(Integer id, String name, Integer activeQuantity, Integer quantity, String desc, Integer status,
			String status_desc, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.name = name;
		this.activeQuantity = activeQuantity;
		this.quantity = quantity;
		this.desc = desc;
		this.status = status;
		this.status_desc = status_desc;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	public Category(String name, Integer status, Date gmtCreate) {
		super();
		this.name = name;
		this.status = status;
		this.gmtCreate = gmtCreate;
	}
	public Integer getActiveQuantity() {
		return activeQuantity;
	}
	public void setActiveQuantity(Integer activeQuantity) {
		this.activeQuantity = activeQuantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus_desc() {
		return status_desc;
	}
	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
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
		return "Category [id=" + id + ", name=" + name + ", activeQuantity=" + activeQuantity + ", quantity=" + quantity
				+ ", desc=" + desc + ", status=" + status + ", status_desc=" + status_desc + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
}
