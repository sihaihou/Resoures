package com.reyco.core.domain;

import java.io.Serializable;

public class Student implements Serializable{
	private Integer id;
	private String no;
	private String name;
	private String password;
	private Integer schoolId;
	private String schoolName;
	private Integer status;
	
	public Student() {
	}
	public Student(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public Student(Integer id, String no, String name, String password, Integer schoolId,String schoolName,Integer status) {
		super();
		this.id = id;
		this.no = no;
		this.name = name;
		this.password = password;
		this.schoolId = schoolId;
		this.schoolName=schoolName;
		this.status=status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", password=" + password + ", schoolId="
				+ schoolId + ", schoolName=" + schoolName + ", status=" + status + "]";
	}
}
