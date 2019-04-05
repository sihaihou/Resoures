package com.hs.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.thread.SomeThread;

@WebServlet(value = "/some", asyncSupported = true)
public class SomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AsyncContext ac = request.startAsync();
		SomeThread someThread = new SomeThread(ac);
		ac.setTimeout(3000);
		ac.start(someThread);

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("请查看注册情况<a href='email.jsp'>邮箱</a>");
	}
}
