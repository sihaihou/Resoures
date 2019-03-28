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
		
		/*ʵ���ض���*/
		/*resp.sendRedirect("index.jsp");*/
		
		/*ʵ��ת��*/
		/*req.setAttribute("msg", "servlet API forward");
		req.getRequestDispatcher("index.jsp").forward(req, resp);*/
	}
	
	
	@RequestMapping("/hello1")
	public String hello1(){
		//ת�� 1
		/*return "index.jsp";*/
		//ת�� 2
	/*	return "forward:index.jsp";*/
		//�ض���
		return "redirect:index.jsp";
	}
	
	//��Ҫ��ͼ������
	@RequestMapping("/hello2")
	public String hello2(){
		//ת�� 1
		return "hello";
	}
	
}
