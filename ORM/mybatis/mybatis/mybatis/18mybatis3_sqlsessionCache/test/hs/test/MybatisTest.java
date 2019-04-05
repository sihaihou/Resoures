package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**	
 *	一级缓存Sqlsession
 * @author Administrator
 *
 */
public class MybatisTest {
	/**
	 * 证明一级缓存存在
	 */
	@Test
	public void test01(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);
			
			User user1 = userDao.selectUserById(2);
			System.out.println(user1);
			User user2 = userDao.selectUserById(2);
			System.out.println(user2);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	/**
	 * 证明从一级缓存读取数据的依据是：Sql的id(配置文件select标签的id) + SQL语句
	 * 
	 * 缓存的底层实现是一个Map，map的value是查询结果
	 * map的key即查询依据使用的ORM结果不同，查询依据是不同的
	 * 
	 * Hibernate的查询依据是：查询结果对象的id
	 */
	@Test
	public void test02(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);		
			User user1 = userDao.selectUserById(2);
			System.out.println(user1);
			
			User user2 = userDao.selectUserById2(2);
			System.out.println(user2);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	/**
	 * 证明增删改都会清空缓存
	 */
	@Test
	public void test03(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);		
			User user1 = userDao.selectUserById(2);
			System.err.println(user1);
			
			userDao.insertUser(new User("zs",18));
			
			User user2 = userDao.selectUserById(2);
			System.err.println(user2);		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
}
