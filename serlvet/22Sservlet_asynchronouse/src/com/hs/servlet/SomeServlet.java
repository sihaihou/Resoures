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
 * asyncSupported=true�������첽����
 * @author Administrator
 */
@WebServlet(value="/someServlet",asyncSupported=true)
public class SomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("=========���߳̿�ʼ========<br>");
		//��ȡ�첽�����Ķ���
		AsyncContext ac = request.startAsync();
		//����һ����ʱ���������(���߳�)
		SomeThread someThread = new SomeThread(ac);
		//�����첽��ʱ����
		ac.setTimeout(3000);
		
		ac.start(someThread);
		//Ϊ�첽������Ӽ�����
		ac.addListener(new AsyncListener() {
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				System.err.println("�첽�����ѳ�ʱ��");
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
		out.println("=========���߳̽���========<br>");
		out.print("��鿴ע�����<a href='email.jsp'>����</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
