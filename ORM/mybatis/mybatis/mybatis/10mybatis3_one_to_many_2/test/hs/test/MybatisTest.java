package hs.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.CountryDao;
import hs.pojo.Country;
import hs.util.MyBatisUtil;

public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession = MyBatisUtil.getSqlSession();
		try {
			CountryDao	countryDao = sqlSession.getMapper(CountryDao.class);
			Country country = countryDao.selectCountryById(2);
			System.err.println(country);				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession();
		}
	}
}
