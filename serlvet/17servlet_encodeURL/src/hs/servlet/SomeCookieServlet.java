package hs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", "zhangsan");
		System.err.println("session====" + session);
		PrintWriter out = response.getWriter();
		String uri = "other";
		//解决cookie禁用后，非重定向时的Session跟踪问题
		uri = response.encodeURL(uri);
		out.println("<a href='"+uri +"'>跳转</a>到OtherServlet");
	}
}
