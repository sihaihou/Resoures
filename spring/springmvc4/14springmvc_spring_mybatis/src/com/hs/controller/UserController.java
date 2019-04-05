package com.hs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hs.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/user")
	public String list(ModelMap model){
		model.addAttribute("list",userService.getAll());
		return "list.jsp";
	}
	/*@RequestMapping("/delete")  
    public ModelAndView deleteOne(int id){      
        ModelAndView mav=new ModelAndView();  
        mav.addObject("id", userService.deleteOne(id));  
        mav.setViewName("/list.jsp");  
        return mav;  
    }  */
	@RequestMapping("/delete")
	public String deleteOne(ModelMap modle,int id){
		modle.addAttribute("id",userService.deleteOne(id));	
		return "user.do";		
	}
}
