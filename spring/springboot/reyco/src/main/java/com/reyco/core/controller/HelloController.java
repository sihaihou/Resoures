package com.reyco.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController("helloController")
public class HelloController {
	@Value("${com.reyco.core.domain.name}")
	private String name;
	@Value("${com.reyco.core.domain.password}")
	private String password;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world!\r\tname="+name+",password="+password;
		
	}
	@RequestMapping("/properties")
	public String properties() {
		return "properties";
	}
	
}
