package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.NewsLabelDao;
import hs.pojo.NewsLabel;
import hs.util.MyBatisUtil;
/**
 * ��ѯָ����Ŀ��������������Ŀ
 * @author Administrator
 */
public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession = MyBatisUtil.getSqlSession();
		try {
			NewsLabelDao newsLabelDao = sqlSession.getMapper(NewsLabelDao.class);
			NewsLabel newsLabel = newsLabelDao.selectNewsLabelById(1);
			
			 System.err.println(newsLabel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession();
		}
	}
}
