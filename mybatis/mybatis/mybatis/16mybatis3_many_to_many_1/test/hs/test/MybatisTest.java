package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.StudentDao;
import hs.pojo.Student;
import hs.util.MyBatisUtil;
/**
 * ��Զ������ѯ
 * @author Administrator
 */
public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession = MyBatisUtil.getSqlSession();
		try {
			StudentDao StudentDao = sqlSession.getMapper(StudentDao.class);
			Student student = StudentDao.selectStudentById(3);
			 System.err.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession();
		}
	}
}
