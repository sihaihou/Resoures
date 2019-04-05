package hs.service.impl;

import java.util.List;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
}
