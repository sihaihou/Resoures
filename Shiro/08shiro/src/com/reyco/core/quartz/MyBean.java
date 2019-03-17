package com.reyco.core.quartz;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller("mybean")
public class MyBean {
	public void myMethod() {
		Date date = new Date();
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
		System.out.println("mybean");
	}
}
