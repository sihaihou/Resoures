package com.hs.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hs.dao.UserDao;
import com.hs.pojo.User;

import com.hs.util.MyBatisUtil;

public class UserDaoImpl implements UserDao{
	@Override
	public void insertUser(User user) {
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			sqlSession.insert("insertUser", user);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}

	@Override
	public void insertUserCacheId(User user) {
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			sqlSession.insert("insertUserCacheId", user);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}

	@Override
	public void deleteUserById(int id) {
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			sqlSession.delete("deleteUserById", id);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}

	@Override
	public void updateUser(User user) {
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			sqlSession.update("updateUser", user);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}		
	}

	@Override
	public List<User> selectAllUserList(){
		List<User> users = null;
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			users = sqlSession.selectList("selectAllUserList");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}		
		return users;
	}
	
	/**
	 * selectMap()第二个参数必须是查询对象的属性
	 */
	@Override
	public Map<String, Object> selectAllUserMap() {
		Map<String, Object> map = null;
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			map = sqlSession.selectMap("selectAddUserMap","id");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}		
		return map;
	}

	@Override
	public User selectUserById(int id) {
		User user = null;
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			user = sqlSession.selectOne("selectUserById", id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
		return user;		
	}

	@Override
	public List<User> selectUserByName(String name) {
		List<User> users = null;
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			users = sqlSession.selectList("selectUserByName", name);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}		
		return users;
	}
}
