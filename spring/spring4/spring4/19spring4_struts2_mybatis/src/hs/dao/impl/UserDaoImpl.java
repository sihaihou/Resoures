package hs.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import hs.dao.UserDao;
import hs.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public List<User> getAll() {
		return this.getSqlSession().selectList("hs.pojo.user.mapper.getAll");
	}
	
}
