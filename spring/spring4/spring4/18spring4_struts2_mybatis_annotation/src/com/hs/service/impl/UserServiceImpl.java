package com.hs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.dao.UserDao;
import com.hs.pojo.User;
import com.hs.service.UserService;

@Service("userService")//�൱��spring�������bean
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
}
