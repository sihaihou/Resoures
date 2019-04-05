package com.hs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other")
public class OtherCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求中的cookie
		Cookie[] cookies = request.getCookies();
		//遍历cookie
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("username") && cookie.getValue().equals("zhangsan")) {
				System.err.println("cookie.getName()=="+cookie.getName());
			}else {
				System.err.println("输入错误");
			}
		}
	}

}
