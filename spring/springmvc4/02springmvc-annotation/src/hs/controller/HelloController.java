package hs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello(HttpServletRequest req,HttpServletResponse resp  ){
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","hello Annotation");
		mv.setViewName("hello");
		return mv;
	}
}
