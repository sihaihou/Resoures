package com.exam.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.core.util.JSONResult;

@RequestMapping("/account")
@RestController
public class AccountController {
	
	@RequestMapping("/login")
	public String login() {
		return JSONResult.create("---登录成功---").toJSON();
	}
	
	@RequestMapping("/register")
	public String register() {
		return JSONResult.create("---注册成功---").toJSON();
	}
	@RequestMapping("/logout")
	public String logout() {
		return JSONResult.create("---登出---").toJSON();
	}
}
