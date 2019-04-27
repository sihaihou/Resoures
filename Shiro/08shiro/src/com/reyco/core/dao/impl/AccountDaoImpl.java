package com.reyco.core.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reyco.core.dao.AccountDao;
import com.reyco.core.pojo.Account;

@Repository("accountDao")
public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Account searchUserByUserName(String username) {
		return this.getSqlSession().selectOne("com.reyco.core.mapper.account.mapper.searchUserByUserName",username);
	}
	
}
