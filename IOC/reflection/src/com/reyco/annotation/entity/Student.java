package com.reyco.annotation.entity;

/**
 * 学生表
 * @author reyco
 *
 */
public class Student {
	/**
	 *  学生id
	 */
	private int id;
	/**
	 * 学生名称
	 */
	private String name;	
	/**
	 * 学生年龄
	 */
	private int age;
	/**
	 * 
	 */
	private Grade grade;
	
	public Student() {
	}
	public Student(int id, String name, int age, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
