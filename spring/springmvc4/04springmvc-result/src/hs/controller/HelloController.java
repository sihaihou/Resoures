package hs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public void hello(HttpServletRequest req,HttpServletResponse resp  ) throws Exception{
		/*resp.getWriter().print("spring mvc use httpservlet ApI");*/
		
		/*实现重定向*/
		/*resp.sendRedirect("index.jsp");*/
		
		/*实现转发*/
		/*req.setAttribute("msg", "servlet API forward");
		req.getRequestDispatcher("index.jsp").forward(req, resp);*/
	}
	
	
	@RequestMapping("/hello1")
	public String hello1(){
		//转发 1
		/*return "index.jsp";*/
		//转发 2
	/*	return "forward:index.jsp";*/
		//重定向
		return "redirect:index.jsp";
	}
	
	//需要视图解析器
	@RequestMapping("/hello2")
	public String hello2(){
		//转发 1
		return "hello";
	}
	
}
