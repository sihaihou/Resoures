package hs.service.impl;

import java.util.List;

import hs.dao.UserMapper;
import hs.pojo.User;
import hs.service.UserService;
/**
 * spring����mybatis��
 * 			�����ַ�ʽ��mybatisʹ��ע��
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
