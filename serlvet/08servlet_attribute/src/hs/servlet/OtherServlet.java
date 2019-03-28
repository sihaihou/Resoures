package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		//从请求中获取指定名称的域属性
		String name = (String) req.getAttribute("name");
		String pwd = (String) req.getAttribute("pwd");
		System.out.println("name="+name);
		System.out.println("pwd="+pwd);
		
		//获取请求中的所有域属性+属性值
		Enumeration<String> names = req.getAttributeNames();
		while(names.hasMoreElements()){
			String eleName = names.nextElement();
			System.out.println(eleName+"===="+req.getAttribute(eleName));
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
