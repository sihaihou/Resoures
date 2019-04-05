package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.StudentDao;
import hs.pojo.Student;
import hs.util.MyBatisUtil;
/**
 * һ�Զࣺ
 * 		�ɶ��һ�˹�������
 * @author Administrator
 *
 */
public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession =null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			StudentDao StudentDao = sqlSession.getMapper(StudentDao.class);
			Student student = StudentDao.selectStudentById(1);
			System.err.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			MyBatisUtil.closeSqlSession();			
		}	
	}
}
