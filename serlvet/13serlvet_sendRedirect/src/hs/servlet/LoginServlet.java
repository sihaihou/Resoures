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
			//解决请求中文乱码
			req.setCharacterEncoding("UTF-8");
			
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			
			//编码:重定向的中文乱码解决
			name = URLEncoder.encode(name,"utf-8");
			/**
			 * 重定向：可以从一个项目跳转到另一个项目:
			 * resp.sendRedirect("/另一个项目名/另一个项目的Urlpattern(*.servlet)");
			 */
			//重定向:数据传输
			resp.sendRedirect("*.some?name="+name+ "&pwd="+pwd);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
		
	}

}
