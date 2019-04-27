package com.reyco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.reyco.dubbo.domain.Account;
import com.reyco.service.AccountService;
import com.reyco.util.JSONResult;

@Controller("accounController")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@ResponseBody
	@RequestMapping("/test")
	public String test(String name,String password) {
			return "test...";
	}
	@ResponseBody
	@RequestMapping("/login")
	public String login(String name,String password) {
		Boolean flag = accountService.login(name, password);
		System.out.println("flag==="+flag);
		if(flag) {
			return JSONResult.create("登录成功...").toJSON();
			//return ""+flag;
		}
		//return ""+flag;
		return JSONResult.failCreate("登录失败...", "用户名或密码错误...").toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/selectList")
	public String selectList() {
		System.out.println("selectList...");
		List<Account> list = accountService.selectList();
		return JSONResult.create(list).toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/updatePath")
	public String updatePath(@RequestParam("file") CommonsMultipartFile file) {
		if(null == file) {
			return JSONResult.failCreate("上传失败...", "false").toJSON();
		}
		String id = "1";
		System.out.println("file==="+file);
		Boolean flag = accountService.updatePath(id, file);
		if(false) {
			return JSONResult.create("上传成功...").toJSON();
		}
		return JSONResult.failCreate("上传失败...", "false").toJSON();
	}
}
