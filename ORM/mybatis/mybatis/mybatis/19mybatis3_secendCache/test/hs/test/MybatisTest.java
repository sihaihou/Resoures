package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**	
 *	开启内置的二级缓存：
 *		1，在映射文件中添加<cache/>标签，
 *		2，对实体类进行序列化。
 * @author Administrator
 *
 */
public class MybatisTest {
	/**
	 * 证明二级缓存存在
	 */
	@Test
	public void test01(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);			
			User user1 = userDao.selectUserById2(2);
			System.out.println(user1);
			//关闭sqlsession，清楚一级缓存
			sqlSession.close();
			
			sqlSession = MyBatisUtil.getSqlSession();
			userDao = sqlSession.getMapper(UserDao.class);
			User user2 = userDao.selectUserById2(2);
			System.out.println(user2);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	/**
	 * 	1，证明增删改会同样也会清楚二级缓存
	 * 	2，对应二级缓存的清空，实质上是对所查找的key对应的value置为null，而并非将<key,value>对进行删除
	 *  3，从DB进行select查询的条件是：
	 *  		1)，缓存中根本就不存在这个key
	 * 			2)，缓存中存在该key所对应的Entry对象，但其value为null。
	 */
	@Test
	public void test02(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);			
			User user1 = userDao.selectUserById(2);
			System.out.println(user1);
			sqlSession.close();
			
			//插入一条数据看是否对二级缓存有影响
			sqlSession = MyBatisUtil.getSqlSession();
			userDao = sqlSession.getMapper(UserDao.class);
			userDao.insertUser(new User("zs",18));
			
			User user2= userDao.selectUserById(2);
			System.out.println(user2);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	/**
	 * 测试局部关闭二级缓存
	 * 		需在映射文件当前的select标签中配置：useCache="false"
	 */
	@Test
	public void test03(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);			
			User user1 = userDao.selectUserById(2);
			System.out.println(user1);
			//关闭sqlsession，清楚一级缓存
			sqlSession.close();
			
			sqlSession = MyBatisUtil.getSqlSession();
			userDao = sqlSession.getMapper(UserDao.class);
			User user2 = userDao.selectUserById(2);
			System.out.println(user2);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
}
