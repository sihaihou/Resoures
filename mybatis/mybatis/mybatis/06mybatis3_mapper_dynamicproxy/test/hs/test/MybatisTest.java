package hs.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**
 * mapper��̬����
 * @author Administrator
 */
public class MybatisTest {
	@Test
	public void testInsertUser(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);
			User user = new User("�̷���",18);
			userDao.insertUser(user);
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	@Test
	public void testDeleteUser(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			userDao.deleteUserById(2);
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	@Test
	public void testUpdateUser(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			User user = new User("����",19);
			user.setId(8);
			userDao.updateUser(user);
			sqlSession.commit();
		}catch(Exception e){
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	@Test
	public void testSelectAllUserList(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);
			List<User> users = userDao.selectAllUserList();
			for(User user:users){
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
	@Test
	public void testSelectUserById(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao userDao = sqlSession.getMapper(UserDao.class);
			User user = userDao.selectUserById(4);
			System.out.println(user);
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

	@Test
	public void testSelectUserByName(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);
			List<User> users = userDao.selectUserByName("��");
			System.out.println(users);
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
}
