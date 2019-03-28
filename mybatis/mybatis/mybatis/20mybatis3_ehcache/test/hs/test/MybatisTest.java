package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**
 * ʹ�õ�������ehcache�������棺
 * 			1�����������jar��
 *          2��ӳ���ļ�ָ��ʹ���ĸ���
 *          3����Ҫehcache.xml�����ļ�
 * @author Administrator
 */
public class MybatisTest {
	/**
	 * ֤��ehcache�����������
	 */
	@Test
	public void test01(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);			
			User user1 = userDao.selectUserById(2);
			System.out.println(user1);
			//�ر�sqlsession�����һ������
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
