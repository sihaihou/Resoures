package hs.test;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.CountryDao;
import hs.pojo.Country;
import hs.pojo.Minister;
import hs.util.MyBatisUtil;
/**
 * ≤‚ ‘—”≥Ÿº”‘ÿ
 * @author Administrator
 *
 */
public class MybatisTest {
	@Test
	public void test01(){
		SqlSession	sqlSession = MyBatisUtil.getSqlSession();
		try {
			CountryDao	countryDao = sqlSession.getMapper(CountryDao.class);
			Country country = countryDao.selectCountryById(2);
			System.err.println(country.getCname());
			Set<Minister> minister = country.getMinisters();
			System.out.println(minister.size());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession();
		}
	}
}
