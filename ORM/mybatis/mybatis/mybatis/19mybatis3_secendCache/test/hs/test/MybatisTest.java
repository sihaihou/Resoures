package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**	
 *	�������õĶ������棺
 *		1����ӳ���ļ������<cache/>��ǩ��
 *		2����ʵ����������л���
 * @author Administrator
 *
 */
public class MybatisTest {
	/**
	 * ֤�������������
	 */
	@Test
	public void test01(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);			
			User user1 = userDao.selectUserById2(2);
			System.out.println(user1);
			//�ر�sqlsession�����һ������
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
	 * 	1��֤����ɾ�Ļ�ͬ��Ҳ�������������
	 * 	2����Ӧ�����������գ�ʵ�����Ƕ������ҵ�key��Ӧ��value��Ϊnull�������ǽ�<key,value>�Խ���ɾ��
	 *  3����DB����select��ѯ�������ǣ�
	 *  		1)�������и����Ͳ��������key
	 * 			2)�������д��ڸ�key����Ӧ��Entry���󣬵���valueΪnull��
	 */
	@Test
	public void test02(){
		try{
			SqlSession sqlSession = MyBatisUtil.getSqlSession();
			UserDao	userDao = sqlSession.getMapper(UserDao.class);			
			User user1 = userDao.selectUserById(2);
			System.out.println(user1);
			sqlSession.close();
			
			//����һ�����ݿ��Ƿ�Զ���������Ӱ��
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
	 * ���Ծֲ��رն�������
	 * 		����ӳ���ļ���ǰ��select��ǩ�����ã�useCache="false"
	 */
	@Test
	public void test03(){
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
