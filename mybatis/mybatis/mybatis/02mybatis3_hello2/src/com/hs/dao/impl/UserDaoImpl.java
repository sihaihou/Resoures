package com.hs.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.hs.dao.UserDao;
import com.hs.pojo.User;
import com.hs.util.MyBatisUtil;

public class UserDaoImpl implements UserDao{
	@Override
	public void insertUser(User user) {
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			sqlSession.insert("com.hs.pojo.user.mapper.insertUser", user);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();;
		}
	}
}
