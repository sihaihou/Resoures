package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.GradeDao;
import hs.pojo.Grade;
import hs.util.MyBatisUtil;
/**
 * 一对多：
 * 		由一的一端管理数据
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
