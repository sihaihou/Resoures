package com.hs.pojo;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * 实体类实现HttpSessionBindingListener接口,同时还有实现Serializable接口
 * 该监听器是不需要注册的
 * @author Administrator
 *
 */
public class Student implements HttpSessionActivationListener,Serializable {
	private String name;
	private Integer age;
	public Student() {
		// TODO Auto-generated constructor stub
	}
    public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	/**
	 * 当当前类的对象被活化(硬盘上的数据恢复到内存),会触发该方法的执行。
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("Student已经被活化");
	}
	/**
	 *  当当前类的对象被钝化(内存中的数据写入到硬盘),会触发该方法的执行。
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("Student将要被钝化");
	}
	
}
