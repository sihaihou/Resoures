package com.hs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.dao.UserDao;
import com.hs.pojo.User;

@Repository("userDao")//�൱��spring�������һ��bean
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	@Autowired//�Զ�ע������
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<User> getAll() {
		return this.getSqlSession().selectList("com.hs.pojo.user.mapper.getAll");
	}

}
