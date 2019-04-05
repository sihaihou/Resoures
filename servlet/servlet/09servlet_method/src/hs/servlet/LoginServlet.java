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
		//��ȡ�����URL
		StringBuffer reqURL = req.getRequestURL();
		System.out.println("reqURL="+reqURL);
	
		//��ȡ�����URI��URLȥ������Э����������ʣ�ಿ��
		String reqURI = req.getRequestURI();
		System.out.println("reqURI="+reqURI);
		
		//��ȡ��ǰweb���õĸ�·��
		String contextpath = req.getContextPath();
		System.out.println("contextpath="+contextpath);
		
		//��ȡ�ͻ��˵�IP
		String clientIP = req.getRemoteAddr();
		System.out.println("clientIP="+clientIP);
		

		/**
		 * ����http://localhost:8080/method/aaa/bbb/a.login
		 */
		//��ȡurlpattern�ľ�ȷ·����/aaa/bbb
		String servletpath = req.getServletPath();
		System.out.println("servletpath="+servletpath);
		//��ȡ * ��ƥ������ݣ�/a.login
		String pathInfo = req.getPathInfo();
		System.out.println("pathInfo="+pathInfo);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	

}
