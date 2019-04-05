package hs.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hs.student.Student;
import hs.student.User;
/**	
 * 		注入：
 * 		bean的作用域 ：
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		/*Student s = (Student) ac.getBean("student");
		s.show();*/		
		User user = (User) ac.getBean("u1");
		System.out.println(user);
	}
}
