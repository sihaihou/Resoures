package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hs.po.User;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name").trim();
		String pwd=request.getParameter("pwd").trim();
		if((name).trim().equals("hsh")&&(pwd.trim()).equals("123456")){
			//��¼�ɹ�
			User user = new User(name,pwd); 
			request.getSession().setAttribute("user", user);			
			//ת���� �ض���
			request.getRequestDispatcher("success.jsp").forward(request, response);
			return;
		}else {
			//��¼ʧ��
			request.setAttribute("loginError", "�û���������������������룡");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
	}
}
