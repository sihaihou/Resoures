package com.hs.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hs.dao.UserDao;
/**
 * 只做测试 ---无实际意义
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println("数据大小："+userDao.getAll().size());
	}
}
