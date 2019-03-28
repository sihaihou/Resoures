package com.hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hs.pojo.User;


public class LoginServlet extends HttpServlet {
	/**
	 * �û���¼�ὫUser������session��(��User�������session����)��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println("name==="+name);
		String pwd = request.getParameter("pwd");
		User user = new User(name,pwd);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);//��
		response.sendRedirect(request.getContextPath()+"/welcome.jsp");
	}

}
