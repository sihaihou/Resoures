package hs.user;

import java.util.Set;

/**
 *  ioc��������ķ�ʽ��
 *		 1,ʹ���޲ι��췽������;
 *		 2,ͨ���вι��췽����������!
 *			2_1:���췽�������±괴������
 *			2_2:��������������;
 *			2_3:ͨ��������������������
 * @author Administrator
 */
public class User {
	private String name;
	public User() {
		System.out.println("IOC��ͨ���޲ι��췽����������!");
	}	
	public User(String name) {
		super();
		System.out.println("IOC��ͨ���вι��췽����������!");
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void show(){
		System.out.println("name:"+name);
	}
}
