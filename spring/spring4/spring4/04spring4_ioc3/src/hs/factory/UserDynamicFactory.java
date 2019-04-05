package hs.factory;

import hs.user.User;

public class UserDynamicFactory {
	public  User newInstance(String name){
		System.out.println("3_1.ioc:通过动态工厂方法来创建对象");
		return new User(name);
	}
}
