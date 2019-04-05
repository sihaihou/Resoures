package hs.service.Impl;


import hs.dao.UserDao;
import hs.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao= null;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void getUser() {
		userDao.getUser();
	}

}
