package hs.factory;

import hs.user.User;

public class UserDynamicFactory {
	public  User newInstance(String name){
		System.out.println("3_1.ioc:ͨ����̬������������������");
		return new User(name);
	}
}
