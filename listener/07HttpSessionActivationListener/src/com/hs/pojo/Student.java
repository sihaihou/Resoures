package com.hs.pojo;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * ʵ����ʵ��HttpSessionBindingListener�ӿ�,ͬʱ����ʵ��Serializable�ӿ�
 * �ü������ǲ���Ҫע���
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
	 * ����ǰ��Ķ��󱻻(Ӳ���ϵ����ݻָ����ڴ�),�ᴥ���÷�����ִ�С�
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("Student�Ѿ����");
	}
	/**
	 *  ����ǰ��Ķ��󱻶ۻ�(�ڴ��е�����д�뵽Ӳ��),�ᴥ���÷�����ִ�С�
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("Student��Ҫ���ۻ�");
	}
	
}
