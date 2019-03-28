package hs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hs.pojo.User;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(User user,HttpSession session){
		if("hsh".equals(user.getName())&&"123456".equals(user.getPwd())){
			session.setAttribute("user",user);
			return "redirect:/index.jsp";	
		}
		return "redirect:/login.jsp";		
	}
	
	/**
	 * ≤‚ ‘ª∫¥Ê
	 * @return
	 */
	@RequestMapping("/add")
	public String add(){
		System.out.println("add");
		return "redirect:/index.jsp";
		
	}
}
