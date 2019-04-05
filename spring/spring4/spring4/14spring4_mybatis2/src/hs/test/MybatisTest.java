package hs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.dao.UserDao;
/**
 * spring整合mybatis：
 * 			第二种方式继承SqlSessionDaoSupport类
 * @author Administrator
 *
 */
public class MybatisTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.err.println(userDao.selectUser().size());
	}
}
