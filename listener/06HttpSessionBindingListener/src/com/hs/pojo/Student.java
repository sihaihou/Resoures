package com.hs.pojo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * ʵ����ʵ��HttpSessionBindingListener�ӿ�
 * �ü������ǲ���Ҫע���
 * @author Administrator
 *
 */
public class Student implements HttpSessionBindingListener {
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
	 *  ����ǰ��Ķ���󶨵�sessionʱ(���뵽session����),�ᴥ���÷�����ִ��
	 */
	public void valueBound(HttpSessionBindingEvent hsbe)  { 
		System.out.println("Student������뵽session����");
		System.out.println(hsbe.getName()+"=="+hsbe.getValue());
    }
	/**
	 *  ����ǰ��Ķ�����session���ʱ(��session����ɾ��),�ᴥ���÷�����ִ��
	 */
    public void valueUnbound(HttpSessionBindingEvent hsbe)  { 
    	System.out.println("Student����session����ɾ��");
		System.out.println(hsbe.getName()+"=="+hsbe.getValue());
    }
	
}
