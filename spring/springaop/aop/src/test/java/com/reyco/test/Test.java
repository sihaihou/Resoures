package com.reyco.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.reyco.config.Appconfig;
import com.reyco.dao.TestDao;

public class Test {
	
	public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        TestDao testDao = annotationConfigApplicationContext.getBean(TestDao.class);
        testDao.query();
    }
	
}
