package com.reyco.core.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.reyco.core.springmvc.annotation.Autowired;
import com.reyco.core.springmvc.annotation.Controller;
import com.reyco.core.springmvc.annotation.RequestMapping;
import com.reyco.core.springmvc.annotation.RequestParam;
import com.reyco.core.springmvc.entity.Base;
import com.reyco.core.springmvc.service.BaseService;

@RequestMapping("/base")
@Controller("baseController")
public class BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@RequestMapping("/base")
	public void getBase(@RequestParam("name")String name,@RequestParam("password")String password,HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Base base = baseService.getBase(name,password);
		out.println(base);
	}
}
