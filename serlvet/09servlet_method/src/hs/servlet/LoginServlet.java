package hs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rep) 
			throws ServletException, IOException {
		//获取请求的URL
		StringBuffer reqURL = req.getRequestURL();
		System.out.println("reqURL="+reqURL);
	
		//获取请求的URI：URL去掉请求协议和主机后的剩余部分
		String reqURI = req.getRequestURI();
		System.out.println("reqURI="+reqURI);
		
		//获取当前web运用的根路径
		String contextpath = req.getContextPath();
		System.out.println("contextpath="+contextpath);
		
		//获取客户端的IP
		String clientIP = req.getRemoteAddr();
		System.out.println("clientIP="+clientIP);
		

		/**
		 * 请求：http://localhost:8080/method/aaa/bbb/a.login
		 */
		//获取urlpattern的精确路径：/aaa/bbb
		String servletpath = req.getServletPath();
		System.out.println("servletpath="+servletpath);
		//获取 * 所匹配的内容：/a.login
		String pathInfo = req.getPathInfo();
		System.out.println("pathInfo="+pathInfo);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	

}
