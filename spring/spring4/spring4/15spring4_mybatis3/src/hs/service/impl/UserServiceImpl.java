package hs.service.impl;

import java.util.List;

import hs.dao.UserMapper;
import hs.pojo.User;
import hs.service.UserService;
/**
 * spring整合mybatis：
 * 			第三种方式：mybatis使用注解
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	private UserMapper userMapper = null;
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public List<User> selectUser() {
		return userMapper.selectUser();
	}
}
