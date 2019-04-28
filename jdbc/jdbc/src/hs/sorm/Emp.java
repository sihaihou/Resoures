package hs.sorm;

import java.sql.Date;

public class Emp {
	private Integer id;
	private String name;
	private Integer salary;
	private Date birthday;
	private Integer age;
	private Integer deptID;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(String name, Integer salary, Date birthday, Integer age, Integer deptID) {
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
		this.age = age;
		this.deptID = deptID;
	}
	public Emp(Integer id, String name, Integer salary, Date birthday, Integer age, Integer deptID) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
		this.age = age;
		this.deptID = deptID;
	}
	public Emp(String name, Integer salary, Date birthday, Integer age) {
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getSalary() {
		return salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Integer getAge() {
		return age;
	}
	public Integer getDeptID() {
		return deptID;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
}
