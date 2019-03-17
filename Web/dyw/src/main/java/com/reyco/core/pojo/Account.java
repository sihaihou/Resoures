package com.reyco.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 账号实体类
 * @author reyco
 *
 */
@SuppressWarnings("all")
public class Account implements Serializable {
	/**
	 * 主键
	 */
	private Integer id ;
	/**
	 * 会员积分
	 */
	private Integer integral;
	/**
	 * 账号类型
	 */
	private Integer vipId;
	/**
	 * 
	 */
	private String vipName;
	/**
	 * 登录账号
	 */
	private String phone;
	/**
	 * 账号密码
	 */
	private String password;
	/**
	 * 账号呢称
	 */
	private String name;
	/**
	 * 账号状态
	 */
	private Integer status;
	/**
	 * 状态名称
	 */
	private String status_info;
	/**
	 * 性别:1男 0女
	 */
	private Integer gender;
	/**
	 * 出生年月日
	 */
	private Date birthday;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 账号备注
	 */
	private String desc;
	/**
	 * 服务开通时间
	 */
	private Date gmtOrder;
	/**
	 * 服务到期时间
	 */
	private Date gmtExpire;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public Account(Integer id, Integer integral, Integer vipId, String vipName, String phone, String password,
			String name, Integer status, String status_info, Integer gender, Date birthday, String email, String desc,
			Date gmtOrder, Date gmtExpire, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.integral = integral;
		this.vipId = vipId;
		this.vipName = vipName;
		this.phone = phone;
		this.password = password;
		this.name = name;
		this.status = status;
		this.status_info = status_info;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.desc = desc;
		this.gmtOrder = gmtOrder;
		this.gmtExpire = gmtExpire;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	public Account(Integer id, Integer integral, String phone, String password, String name, Integer status,
			Integer gender, Date birthday, String email, String desc) {
		super();
		this.id = id;
		this.integral = integral;
		this.phone = phone;
		this.password = password;
		this.name = name;
		this.status = status;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.desc = desc;
	}
	public Account(String phone, String password, String name, Integer status, Integer gender, Date birthday,
			String email, String desc) {
		super();
		this.phone = phone;
		this.password = password;
		this.name = name;
		this.status = status;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.desc = desc;
	}
	public Account(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getGmtOrder() {
		return gmtOrder;
	}
	public void setGmtOrder(Date gmtOrder) {
		this.gmtOrder = gmtOrder;
	}
	public Date getGmtExpire() {
		return gmtExpire;
	}
	public void setGmtExpire(Date gmtExpire) {
		this.gmtExpire = gmtExpire;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getStatus_info() {
		return status_info;
	}
	public void setStatus_info(String status_info) {
		this.status_info = status_info;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "Account [id=" + id + ", integral=" + integral + ", vipId=" + vipId + ", vipName=" + vipName + ", phone="
				+ phone + ", password=" + password + ", name=" + name + ", status=" + status + ", status_info="
				+ status_info + ", gender=" + gender + ", birthday=" + birthday + ", email=" + email + ", desc=" + desc
				+ ", gmtOrder=" + gmtOrder + ", gmtExpire=" + gmtExpire + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + "]";
	}
}
