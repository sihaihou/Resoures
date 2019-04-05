package hs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.bean.Hello;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//���������id��name�� ��ô���Ը���applicationContext.getBean(Class)��ȡ����
		//Hello hello = context.getBean(Hello.class);
		Hello hello = (Hello) context.getBean("h1");		
		hello.show();
	}
}
