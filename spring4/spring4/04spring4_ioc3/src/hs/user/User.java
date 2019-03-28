package hs.user;

import java.util.Set;

/**
 *  ioc创建对象的方式：
 *		 1,使用无参构造方法创建;
 *		 2,通过有参构造方法创建对象!
 *			2_1:构造方法参数下标创建对象；
 *			2_2:参数名创建对象;
 *			2_3:通过参数类型来创建对象。
 * @author Administrator
 */
public class User {
	private String name;
	public User() {
		System.out.println("IOC：通过无参构造方法创建对象!");
	}	
	public User(String name) {
		super();
		System.out.println("IOC：通过有参构造方法创建对象!");
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void show(){
		System.out.println("name:"+name);
	}
}
