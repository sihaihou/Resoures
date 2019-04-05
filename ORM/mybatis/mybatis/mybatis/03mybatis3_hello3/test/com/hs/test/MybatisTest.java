package com.hs.test;

import org.junit.Before;
import org.junit.Test;

import com.hs.dao.UserDao;
import com.hs.dao.impl.UserDaoImpl;
import com.hs.pojo.User;

public class MybatisTest {
	private UserDao userDao;
	@Before
	public void before(){
		userDao = new UserDaoImpl();
	}
	@Test
	public void testInsert(){
		User user = new User("³Ì·ÉÑï",18);
		userDao.insertUser(user);
	}
}
