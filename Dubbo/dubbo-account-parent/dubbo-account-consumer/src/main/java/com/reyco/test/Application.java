package com.reyco.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reyco.dubbo.service.AccountDubboService;
public class Application {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext-dubbo.xml");
		context.start();
		System.out.println("consumer start...");
		AccountDubboService accountService = (AccountDubboService)context.getBean("accountDubboService");
		System.out.println(accountService);
		Boolean flag = accountService.login("Reyco", "123456");
		System.out.println("flag==="+flag);
	}
}
