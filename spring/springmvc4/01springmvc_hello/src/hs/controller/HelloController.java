package hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		ModelAndView mv = new ModelAndView();
		//Ïàµ±ÓÚ£ºreq.setAttribute("msg", "hello springmvc");
		mv.addObject("msg","hello springmvc");
		mv.setViewName("hello");		
		return mv;
	}

}
