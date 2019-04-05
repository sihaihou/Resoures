package hs.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.bean.Hello;

public class HelloTest {
	@Test
	public void testHello(){
		//解析beans.xml文件，生产管理相应的bean对象
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");	
		Hello hello = (Hello) context.getBean("hello");		
		hello.show();
	}
}
