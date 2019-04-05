package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		//解决响应乱码
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("name");
		
		//解码：重定向专门解决中文乱码
		URLDecoder.decode(name, "UTF-8");
		name = new String (name.getBytes("utf-8"),"utf-8");
				
		String pwd = req.getParameter("pwd");
		System.out.println("name---"+name);
		System.out.println("pwd----"+pwd);	
		PrintWriter out = resp.getWriter();
		out.print("this is my someServlet。。");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {		
		doPost(req,resp);
	}

}
