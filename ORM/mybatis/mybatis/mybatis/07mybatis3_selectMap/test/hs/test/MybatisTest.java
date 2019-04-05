package hs.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;

public class MybatisTest {
	/**
	 * ��ѯ���ִ�'��'�֣��������18����ˡ�
	 */
	@Test
	public void testSelectUserByMap(){
		UserDao mapper;
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			mapper = sqlSession.getMapper(UserDao.class);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username","��" );
			map.put("userage", 18);			
			List<User> list = mapper.selectUserByMap(map);
			for(User user:list){
				System.out.println(user);
			}
			//sqlSession.commit();��ѯ�����ύ
		}catch(Exception e){
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	/**
	 * ��ѯ���ִ�'��'�֣��������18�꣬����id����user�����id���ˡ�
	 */
	@Test
	public void testSelectUserByMap1(){
		UserDao mapper;
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			mapper = sqlSession.getMapper(UserDao.class);
			User user = new User(4,"����",20);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username","��" );
			map.put("userage", 18);
			map.put("user", user);
			
			List<User> list = mapper.selectUserByMap1(map);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	/**
	 * ���������ѯ
	 */
	@Test
	public void testSelectUserByContext(){
		UserDao mapper;
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			mapper = sqlSession.getMapper(UserDao.class);
			List<User> list = mapper.selectUserByContext("�̷���", 18);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
}
