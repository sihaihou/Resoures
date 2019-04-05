package com.hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = this.getInitParameter("username");
		String password = this.getInitParameter("password");
		System.err.println(username);
		System.err.println(password);
		//out.println("servlet已被注册！");
		System.err.println("servlet已被注册");
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

}
