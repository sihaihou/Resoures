package com.hs.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hs.dao.UserDao;
import com.hs.pojo.User;

public class UserDaoImpl implements UserDao{
	private InputStream inputstream = null;	
	private SqlSessionFactory sqlSessionFactory = null;
	private SqlSession sqlSession = null;
	@Override
	public void insertUser(User user) {
		try {//���������ļ�
			inputstream = Resources.getResourceAsStream("mybatis.xml");
			//����SqlSessionFactory����
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
			//����SqlSession����
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert("com.hs.pojo.user.mapper.insertUser",user);
			//�ύ����
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
