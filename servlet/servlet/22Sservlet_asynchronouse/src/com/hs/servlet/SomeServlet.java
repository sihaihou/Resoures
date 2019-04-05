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

/**
 * asyncSupported=true：开启异步处理
 * @author Administrator
 */
@WebServlet(value="/someServlet",asyncSupported=true)
public class SomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("=========主线程开始========<br>");
		//获取异步上下文对象
		AsyncContext ac = request.startAsync();
		//启动一个耗时的运算过程(子线程)
		SomeThread someThread = new SomeThread(ac);
		//设置异步超时对象
		ac.setTimeout(3000);
		
		ac.start(someThread);
		//为异步对象添加监听器
		ac.addListener(new AsyncListener() {
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				System.err.println("异步操作已超时！");
			}
			
			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
				
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				
			}
			
			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
				
			}
		});
		out.println("=========主线程结束========<br>");
		out.print("请查看注册情况<a href='email.jsp'>邮箱</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
