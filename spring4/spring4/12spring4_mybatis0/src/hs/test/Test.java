package hs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.dao.UserDao;
/**
 * spring����mybatis��
 * 				��һ�ַ���
 * 	δ������ʽ����
 * @author Administrator
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao.getAll().size());
	}
}
