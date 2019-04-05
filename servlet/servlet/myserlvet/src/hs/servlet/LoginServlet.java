package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hs.pojo.User;
import hs.util.HttpServlet;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		String name = req.getParameter("name");	
		String pwd = req.getParameter("pwd");
		if("hsh".equals(name)&&"123456".equals(pwd)){
			User user = new User(name,pwd);
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("success.jsp").forward(req, resp);		
			return;
		}else{
			req.setAttribute("loginError", "用户名或密码错误。。。");
			req.getRequestDispatcher("failed.jsp").forward(req, resp);
			return;
		}
	}

}
