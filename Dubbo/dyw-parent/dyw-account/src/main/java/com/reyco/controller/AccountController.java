package com.reyco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.service.AccountService;
import com.reyco.util.JSONResult;

@Controller("accounController")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(String name,String password) {
		Boolean flag = accountService.login(name, password);
		System.out.println("flag==="+flag);
		if(flag) {
			return JSONResult.create("登录成功...").toJSON();
		}
		return JSONResult.failCreate("登录失败...", "用户名或密码错误...").toJSON();
	}
}
