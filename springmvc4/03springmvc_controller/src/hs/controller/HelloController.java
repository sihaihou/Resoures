package hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sun.corba.se.pept.transport.ContactInfo;

public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","hello controller");
		mv.setViewName("hello");
		return mv;
	}

}
