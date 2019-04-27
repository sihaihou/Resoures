package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**	
 *	һ������Sqlsession
 * @author Administrator
 *
 */
public class MybatisTest {
	/**
	 * ֤��һ���������
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
	 * ֤����һ�������ȡ���ݵ������ǣ�Sql��id(�����ļ�select��ǩ��id) + SQL���
	 * 
	 * ����ĵײ�ʵ����һ��Map��map��value�ǲ�ѯ���
	 * map��key����ѯ����ʹ�õ�ORM�����ͬ����ѯ�����ǲ�ͬ��
	 * 
	 * Hibernate�Ĳ�ѯ�����ǣ���ѯ��������id
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
	 * ֤����ɾ�Ķ�����ջ���
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
