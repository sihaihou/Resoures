package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.GradeDao;
import hs.pojo.Grade;
import hs.util.MyBatisUtil;
/**
 * һ�Զࣺ
 * 		��һ��һ�˹�������
 * @author Administrator
 *
 */
public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession =null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			GradeDao gradeDao = sqlSession.getMapper(GradeDao.class);
			Grade grade = gradeDao.selectGradeById(1);
			System.err.println(grade);
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			MyBatisUtil.closeSqlSession();			
		}	
	}
}
