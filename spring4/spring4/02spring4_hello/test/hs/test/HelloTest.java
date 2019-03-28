package hs.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.bean.Hello;

public class HelloTest {
	@Test
	public void testHello(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");	
		Hello h = (Hello) context.getBean("hello");		
		h.show();
	}
}
