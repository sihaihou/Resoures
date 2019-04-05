package com.exam.core.domain;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String no;
	private String name;
	private String password;
	private Integer gender;
	private Integer age;
	private String address;
	private Integer status;
	private Integer gradeId;
	private String gradeName;
	private Integer professionalId;
	private String professionalName;
	private Integer facultyId;
	private String facultyName;
	private Integer schoolId;
	private String schoolName;
	private Date gmtCreate;
	private Date gmtModified;
	private Date gmtExpire;
	
	public Student() {
	}
	public Student(Integer id, String no, String name, String password, Integer gender, Integer age, String address,
			Integer status, Integer gradeId, String gradeName, Integer professionalId, String professionalName,
			Integer facultyId, String facultyName, Integer schoolId, String schoolName, Date gmtCreate,
			Date gmtModified, Date gmtExpire) {
		super();
		this.id = id;
		this.no = no;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.status = status;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.professionalId = professionalId;
		this.professionalName = professionalName;
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.gmtExpire = gmtExpire;
	}
	public Integer getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(Integer professionalId) {
		this.professionalId = professionalId;
	}
	public String getProfessionalName() {
		return professionalName;
	}
	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
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
	public Date getGmtExpire() {
		return gmtExpire;
	}
	public void setGmtExpire(Date gmtExpire) {
		this.gmtExpire = gmtExpire;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", age=" + age + ", address=" + address + ", status=" + status + ", gradeId=" + gradeId
				+ ", gradeName=" + gradeName + ", professionalId=" + professionalId + ", professionalName="
				+ professionalName + ", facultyId=" + facultyId + ", facultyName=" + facultyName + ", schoolId="
				+ schoolId + ", schoolName=" + schoolName + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ ", gmtExpire=" + gmtExpire + "]";
	}
}
