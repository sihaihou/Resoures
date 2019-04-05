package hs.test;

import hs.dao.Impl.UserMySqLDaoImpl;
import hs.dao.Impl.UserOracleDaoImpl;
import hs.service.Impl.UserServiceImpl;
/**
 * Spring ioc‘≠–Õ
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserDao(new UserOracleDaoImpl());
		userService.getUser();
		
		userService.setUserDao(new UserMySqLDaoImpl());
		userService.getUser();
	}
}
