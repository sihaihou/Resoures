package com.hs.pojo;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
	private String name;
	private String pwd;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + "]";
	}
	/**
	 * ��(��User�������session����)�û������÷���ִ��
	 * @param event
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		/**
		 * ��ȡServletContext��ServletContext���е�map
		 */
		ServletContext sc = session.getServletContext();
		HashMap<String,HttpSession> map = (HashMap<String, HttpSession>) sc.getAttribute("map");
		/**
		 * �ѵ�ǰ�û���Session����map
		 * �ٰ�map�Ż�ServletContextȫ������
		 */
		map.put(name, session);
		sc.setAttribute("map", map);
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {

	}

}
