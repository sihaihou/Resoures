package com.hs.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hs.dao.UserDao;
/**
 * ֻ������ ---��ʵ������
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println("���ݴ�С��"+userDao.getAll().size());
	}
}
