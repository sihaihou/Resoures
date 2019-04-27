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
	 * 查询名字带'扬'字，年龄大于18岁的人。
	 */
	@Test
	public void testSelectUserByMap(){
		UserDao mapper;
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			mapper = sqlSession.getMapper(UserDao.class);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username","扬" );
			map.put("userage", 18);			
			List<User> list = mapper.selectUserByMap(map);
			for(User user:list){
				System.out.println(user);
			}
			//sqlSession.commit();查询不用提交
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
	 * 查询名字带'扬'字，年龄大于18岁，并且id大于user对象的id的人。
	 */
	@Test
	public void testSelectUserByMap1(){
		UserDao mapper;
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			mapper = sqlSession.getMapper(UserDao.class);
			User user = new User(4,"飞扬",20);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("username","扬" );
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
	 * 多个参数查询
	 */
	@Test
	public void testSelectUserByContext(){
		UserDao mapper;
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			mapper = sqlSession.getMapper(UserDao.class);
			List<User> list = mapper.selectUserByContext("程飞扬", 18);
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
