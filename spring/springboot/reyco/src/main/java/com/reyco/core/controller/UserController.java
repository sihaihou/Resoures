package com.reyco.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reyco.core.domain.User;
import com.reyco.core.service.UserService;
import com.reyco.core.util.JSONResult;

@RequestMapping("/user")
@EnableAutoConfiguration
@RestController
public class UserController {
	
	@Autowired
	private UserService<User> userService;
	
	@RequestMapping("/searchList")
	public String searchList(User user) {
		List<User> users = userService.searchList(user);
		return JSONResult.create(users).toJSON();
	}
	@RequestMapping("/login")
	public String login(String name,String password) {
		if(null == name) {
			return JSONResult.failCreate("登录失败,用户名不能为空", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == password) {
			return JSONResult.failCreate("登录失败,密码不能为空", JSONResult.ERROR_PARAMS).toJSON();
		}
		User user = userService.login(name);
		if(!password.equals(user.getPassword())) {
			return JSONResult.failCreate("登录失败", "").toJSON();
		}
		return JSONResult.create(user).toJSON();
	}
}
