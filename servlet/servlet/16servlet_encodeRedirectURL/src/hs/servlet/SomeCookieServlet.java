package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/some")
public class SomeCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("username", "zhangsan");
		System.err.println("session====" + session);
		
		
		String uri = request.getContextPath() + "/some";
		
		// 解决禁用cookie后，session的跟踪问题
		uri = response.encodeRedirectURL(uri);
		response.sendRedirect(uri);
	}
}
