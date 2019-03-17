package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("all")
public class Video implements Serializable{
	/**
	 * 主键 id
	 */
	private Integer id;
	/**
	 * 视频类型
	 */
	private Integer categoryId;
	/**
	 * 视频类型名称
	 */
	private String categoryName;
	/**
	 * 视频权限
	 */
	private Integer vipId;
	/**
	 * 视频权限名称
	 */
	private String vipName;
	/**
	 * 视频上传的用户Id
	 */
	private Integer accountId;
	/**
	 * 视频上传人
	 */
	private String accountName;
	/**
	 * 视频名称
	 */
	private String name;
	/**
	 * 视频地址
	 */
	private String recordPath;
	/**
	 * 视频点击量
	 */
	private Integer hitQuantity;
	/**
	 * 视频状态
	 */
	private Integer status;
	/**
	 * 状态显示
	 */
	private String status_info;
	
	/**
	 * 视频创建时间
	 */
	private Date gmtCreate;
	/**
	 * 视频修改时间
	 */
	private Date gmtModified;
	/**
	 * 备注
	 */
	private String desc;
	public Video() {
		// TODO Auto-generated constructor stub
	}
	public Video(Integer id, Integer categoryId, String categoryName, Integer vipId, String vipName, Integer accountId,
			String accountName, String name, String recordPath, Integer hitQuantity, Integer status, String status_info,
			Date gmtCreate, Date gmtModified, String desc) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.vipId = vipId;
		this.vipName = vipName;
		this.accountId = accountId;
		this.accountName = accountName;
		this.name = name;
		this.recordPath = recordPath;
		this.hitQuantity = hitQuantity;
		this.status = status;
		this.status_info = status_info;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.desc = desc;
	}
	public Video(Integer categoryId, Integer vipId, Integer accountId, String name, String recordPath,
			Integer hitQuantity, Integer status, String desc) {
		super();
		this.categoryId = categoryId;
		this.vipId = vipId;
		this.accountId = accountId;
		this.name = name;
		this.recordPath = recordPath;
		this.hitQuantity = hitQuantity;
		this.status = status;
		this.desc = desc;
	}
	public Video(Integer id, Integer categoryId, String name, Integer hitQuantity, Integer status, String desc) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.hitQuantity = hitQuantity;
		this.status = status;
		this.desc = desc;
	}
	public Video(Integer categoryId, Integer accountId, String name, Integer status) {
		super();
		this.categoryId = categoryId;
		this.accountId = accountId;
		this.name = name;
		this.status = status;
	}
	public Video(Integer categoryId, Integer accountId, Integer status) {
		super();
		this.categoryId = categoryId;
		this.accountId = accountId;
		this.status = status;
	}
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getStatus_info() {
		return status_info;
	}
	public void setStatus_info(String status_info) {
		this.status_info = status_info;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	public String getRecordPath() {
		return recordPath;
	}
	public void setRecordPath(String recordPath) {
		this.recordPath = recordPath;
	}
	public Integer getHitQuantity() {
		return hitQuantity;
	}
	public void setHitQuantity(Integer hitQuantity) {
		this.hitQuantity = hitQuantity;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", vipId=" + vipId
				+ ", vipName=" + vipName + ", accountId=" + accountId + ", accountName=" + accountName + ", name="
				+ name + ", recordPath=" + recordPath + ", hitQuantity=" + hitQuantity + ", status=" + status
				+ ", status_info=" + status_info + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ ", desc=" + desc + "]";
	}
}
