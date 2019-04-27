package hs.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.NewsLabelDao;
import hs.pojo.NewsLabel;
import hs.util.MyBatisUtil;
/**
 * 查询指定栏目的所有子孙栏目
 * @author Administrator
 */
public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession = MyBatisUtil.getSqlSession();
		try {
			NewsLabelDao newsLabelDao = sqlSession.getMapper(NewsLabelDao.class);
		 List<NewsLabel> list =  (List<NewsLabel>) newsLabelDao.selectNewsLabelByParent(2);
		 for(NewsLabel news:list){
			 System.err.println(news);
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession();
		}
	}
}
