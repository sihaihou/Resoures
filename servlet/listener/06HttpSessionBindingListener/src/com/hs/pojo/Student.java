package com.hs.pojo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * 实体类实现HttpSessionBindingListener接口
 * 该监听器是不需要注册的
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
	 *  当当前类的对象绑定到session时(放入到session域中),会触发该方法的执行
	 */
	public void valueBound(HttpSessionBindingEvent hsbe)  { 
		System.out.println("Student对象放入到session域中");
		System.out.println(hsbe.getName()+"=="+hsbe.getValue());
    }
	/**
	 *  当当前类的对象与session解绑时(从session域中删除),会触发该方法的执行
	 */
    public void valueUnbound(HttpSessionBindingEvent hsbe)  { 
    	System.out.println("Student对象session域中删除");
		System.out.println(hsbe.getName()+"=="+hsbe.getValue());
    }
	
}
