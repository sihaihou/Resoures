package hs.factory;

import hs.user.User;
/**
 * ioc��������
 * 		3_1.ioc:ͨ����̬������������������
 * @author Administrator
 *
 */
public class UserFactory {
	public static User newInstance(String name){
		System.out.println("3_1.ioc:ͨ����̬������������������");
		return new User(name);
	}
}
