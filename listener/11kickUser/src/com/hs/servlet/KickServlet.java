package com.hs.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickServlet extends HttpServlet {
	/**
	 * 剔除用户：使该用户的session失效。并把该用户从map中移除掉
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Map<String,HttpSession> map = (Map<String, HttpSession>) sc.getAttribute("map");
		String name = request.getParameter("name");
		HttpSession session = map.get(name);
		session.invalidate();
		map.remove(name);
		sc.setAttribute("map", map);
		response.sendRedirect(request.getContextPath()+"/userlist.jsp");
		
	}

}
