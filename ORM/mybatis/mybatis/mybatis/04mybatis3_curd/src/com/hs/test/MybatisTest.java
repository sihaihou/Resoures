package com.hs.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.hs.dao.UserDao;
import com.hs.dao.impl.UserDaoImpl;
import com.hs.pojo.User;

public class MybatisTest {
	private UserDao mapper;
	@Before
	public void before(){
		mapper = new UserDaoImpl();
	}
	@Test
	public void testInsertUser(){
		User user = new User("程飞扬",18);
		mapper.insertUser(user);
	}
	@Test
	public void testInsertUserId(){
		User user = new User("程飞扬",18);
		System.out.println("执行前：User:"+user);
		mapper.insertUserCacheId(user);
		System.out.println("执行后：User:"+user);
	}
	@Test
	public void testDeleteUser(){
		mapper.deleteUserById(2);
	}
	@Test
	public void testUpdateUser(){
		User user = new User("飞扬",19);
		user.setId(4);
		mapper.updateUser(user);		
	}
	@Test
	public void testSelectAllUserList(){
		List<User> users = mapper.selectAllUserList();
		for(User user:users){
			System.out.println(user);
		}
	}
	@Test
	public void testSelectAllUserMap(){
		Map<String,Object> map = mapper.selectAllUserMap();
		System.out.println(map.get(1));
	}
	
	@Test
	public void testSelectUserById(){
		User user = mapper.selectUserById(1);
		System.out.println(user);
	}
	@Test
	public void testSelectUserByName(){
		List<User> users = mapper.selectUserByName("扬");
		System.out.println(users);
	}
}
