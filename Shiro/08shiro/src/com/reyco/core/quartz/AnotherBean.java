package com.reyco.core.quartz;

import org.springframework.stereotype.Controller;

@Controller("anotherBean")
public class AnotherBean {
	public void printMsg() {
		System.out.println("anotherBean");
	}
}
