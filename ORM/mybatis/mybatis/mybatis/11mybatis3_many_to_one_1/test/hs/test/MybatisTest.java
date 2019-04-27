package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.StudentDao;
import hs.pojo.Student;
import hs.util.MyBatisUtil;
/**
 * 一对多：
 * 		由多的一端管理数据
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
