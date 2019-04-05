package hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hs.pojo.User;

@Controller
@RequestMapping("hello2")
public class HelloController2 {
	@RequestMapping(params="method=add",method=RequestMethod.GET)
	public String add(){
		System.out.println("add");
		return "index.jsp";	
	}	
	public String delete(){
		System.out.println("delete");
		return "index.jsp";	
	}	
}
