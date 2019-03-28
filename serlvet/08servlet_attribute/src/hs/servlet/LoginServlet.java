package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 侯四海
 *
 */
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//向请求中放入属性
		req.setAttribute("name", "hsh");
		req.setAttribute("pwd", "123456");
		
		//从请求中删除指定域属性
		req.removeAttribute("pwd");
		
		//将请求转发给 OtherServlet
		req.getRequestDispatcher("/*.other").forward(req, resp);
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
