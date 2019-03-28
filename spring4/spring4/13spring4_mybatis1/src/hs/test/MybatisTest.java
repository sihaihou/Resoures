package hs.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.dao.UserDao;
/**
 * spring����mybatis��
 * 				��һ�ַ�����ע��SqlSessionTemplate
 * 	δ������ʽ����
 * @author Administrator
 */
public class MybatisTest {	
	@Test
	public void selectTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.err.println(userDao.selectUser().size());
	}
}
