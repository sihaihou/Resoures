package com.hs.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.thread.SomeThread;

/**
 * 
 * asyncSupported=true�������첽����
 * @author Administrator
 *
 */
@WebServlet(value="/someServlet",asyncSupported=true)
public class SomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("=========���߳̿�ʼ========<br>");
		//��ȡ
		AsyncContext ac = request.startAsync();
		SomeThread someThread = new SomeThread(ac);
		//ac.setTimeout(3000);
		ac.start(someThread);
		
		out.println("=========���߳̽���========<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
