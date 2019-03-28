package hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hs.pojo.User;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(String name,ModelMap model){
		model.addAttribute("name",name);
		System.out.println(name);
		return "index.jsp";	
	}	
	
	//http://localhost:8080/restful/123/pwd/add.do
	@RequestMapping("/{id}/{name}/add")
	public String hello1(@PathVariable int id, @PathVariable String name){
		System.out.println("id:"+id+"\t name:"+name);
		return "/index.jsp";	
	}	
}
