package com.hs.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.hs.dao.UserDao;
import com.hs.pojo.User;
import com.hs.util.MyBatisUtil;

public class UserDaoImpl implements UserDao{	
	@Override
	public User selectUserById(int id) {
		User user = null;
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			user = sqlSession.selectOne("selectUserById", id);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
		return user;		
	}
}
