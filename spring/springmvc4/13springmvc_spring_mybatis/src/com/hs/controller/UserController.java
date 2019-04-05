package com.hs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hs.pojo.User;
import com.hs.service.UserService;
@Controller
public class UserController  {
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/list")
	public String getAll(ModelMap model){
		model.addAttribute("list", userService.getAll());
		return "list.jsp";		
	}
	@RequestMapping("/delete")
	public String delete(ModelMap model,int id ){
		model.addAttribute("id",userService.delete(id));
		return "list.do";
	}	
}
