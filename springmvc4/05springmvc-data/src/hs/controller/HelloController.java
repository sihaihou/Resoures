package hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hs.pojo.User;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	/**
	 * @param @RequestParam("uname"):���ύ���������
	 * @return
	 */
	public String hello(@RequestParam("uname")String name,ModelMap model){
		/*�൱�ڣ�req.setAttribute("name",name);*/		
		model.addAttribute("name",name);
		System.out.println(name);
		return "index.jsp";	
	}	
	@RequestMapping("/user")
	public String user(User user){
		System.out.println(user);
		return "index.jsp";	
	}
}
