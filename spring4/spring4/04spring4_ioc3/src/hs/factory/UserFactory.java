package hs.factory;

import hs.user.User;
/**
 * ioc创建对象：
 * 		3_1.ioc:通过静态工厂方法来创建对象
 * @author Administrator
 *
 */
public class UserFactory {
	public static User newInstance(String name){
		System.out.println("3_1.ioc:通过静态工厂方法来创建对象");
		return new User(name);
	}
}
