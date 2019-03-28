package hs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.bean.Hello;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//如果不配置id和name， 那么可以根据applicationContext.getBean(Class)获取对象
		//Hello hello = context.getBean(Hello.class);
		Hello hello = (Hello) context.getBean("h1");		
		hello.show();
	}
}
