package com.reyco.core.reyco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.reyco.core.ReycoApplication;
import com.reyco.core.domain.Student;
import com.reyco.core.exception.BusinessException;
import com.reyco.core.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ReycoApplication.class)
public class ReycoApplicationTests {
	
	@Autowired
	private StudentService<Student> studentService;
	@Test
	public void contextLoads() {
		Student student = studentService.login("1800101010101");
		System.out.println(student);
		throw new BusinessException();
	}

}
