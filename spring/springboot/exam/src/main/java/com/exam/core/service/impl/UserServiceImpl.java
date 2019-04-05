package com.exam.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.core.dao.UserDao;
import com.exam.core.domain.User;
import com.exam.core.service.UserService;

@Service("userService")
public class UserServiceImpl extends UserService<User>{
	
	@Autowired
	private UserDao<User> userDao;;
	
	@Override
	public List<User> searchList(User user){
		return userDao.searchList(user);
	}

	@Override
	public List<User> searchPage(User user) {
		return  userDao.searchPage(user);
	}

	@Override
	public void insert(User t) {
		
	}

	@Override
	public User searchById(Integer id) {
		return null;
	}

	@Override
	public void updateById(User t) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public void deleteByList(List<Integer> list) {
		
	}

	@Override
	public User login(String name) {
		return userDao.login(name);
	}

	
}
