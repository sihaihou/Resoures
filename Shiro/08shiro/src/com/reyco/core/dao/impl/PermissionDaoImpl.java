package com.reyco.core.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reyco.core.dao.PermissionDao;
import com.reyco.core.pojo.Permission;

@Repository("permissionDao")
public class PermissionDaoImpl extends SqlSessionDaoSupport implements PermissionDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<Permission> searchPermissionByUserId(Integer id) {
		return this.getSqlSession().selectList("com.reyco.core.mapper.permission.mapper.searchPermissionByUserId",id);
	}
}
