package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			//请求转发;数据传输
			req.setAttribute("name",req.getParameter("name"));
			req.setAttribute("pwd", req.getParameter("pwd"));
			//请求转发
			req.getRequestDispatcher("*.some").forward(req, resp);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
		
	}

}
