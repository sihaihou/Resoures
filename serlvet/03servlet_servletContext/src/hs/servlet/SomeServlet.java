package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeServlet implements Servlet{
	private ServletConfig cfg;
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		this.cfg=cfg;		
		//��ȡServletContext
		ServletContext servletContext=cfg.getServletContext();
		
		//��ȡ���еĳ�ʼ������
		Enumeration<String>	names = servletContext.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println(name+"="+value);
		}	
		
		//����������
		servletContext.setAttribute("name", "����");
		servletContext.setAttribute("pwd", "123456");	
		
		//������
		String ContextPath = servletContext.getContextPath();
		System.out.println("ContextPath="+ContextPath);
		//
		String realpath = servletContext.getRealPath("/imgs");
		System.out.println("realpath="+realpath);
	}
	@Override
	public ServletConfig getServletConfig() {
		return cfg;
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	public void destroy() {
		
	}
	@Override
	public String getServletInfo() {	
		return null;
	}
	
}

