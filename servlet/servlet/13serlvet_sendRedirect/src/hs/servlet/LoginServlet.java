package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//���������������
			req.setCharacterEncoding("UTF-8");
			
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			
			//����:�ض��������������
			name = URLEncoder.encode(name,"utf-8");
			/**
			 * �ض��򣺿��Դ�һ����Ŀ��ת����һ����Ŀ:
			 * resp.sendRedirect("/��һ����Ŀ��/��һ����Ŀ��Urlpattern(*.servlet)");
			 */
			//�ض���:���ݴ���
			resp.sendRedirect("*.some?name="+name+ "&pwd="+pwd);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
		
	}

}
