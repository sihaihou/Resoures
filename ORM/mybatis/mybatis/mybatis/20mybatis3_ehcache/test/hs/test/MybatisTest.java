package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**
 * 使用第三方的ehcache二级缓存：
 * 			1，导入第三方jar包
 *          2，映射文件指明使用哪个类
 *          3，需要ehcache.xml配置文件
 * @author Administrator
 */
public class MybatisTest {
	/**
	 * 证明ehcache二级缓存存在
	 */
	@Test
	public void test01(){
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
