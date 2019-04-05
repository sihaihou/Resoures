package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.MinisterDao;
import hs.pojo.Country;
import hs.pojo.Minister;
import hs.util.MyBatisUtil;

public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession = MyBatisUtil.getSqlSession();
		try {
			MinisterDao	ministerDao = sqlSession.getMapper(MinisterDao.class);
			Minister minister = ministerDao.selectMinisterById(1);
			System.err.println(minister);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession();
		}
	}
}
