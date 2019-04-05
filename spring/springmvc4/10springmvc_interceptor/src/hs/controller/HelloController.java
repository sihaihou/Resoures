package hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/interceptor")
	public String hello(){		
		System.out.println("Interceptor Controller ");
		return "index.jsp";	
	}	
}
