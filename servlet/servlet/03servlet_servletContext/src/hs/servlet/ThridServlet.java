package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ThridServlet implements Servlet{
	private ServletConfig cfg;
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		this.cfg=cfg;		
		//��ȡServletContext
		ServletContext servletContext=cfg.getServletContext();
		
		//��ȡOtherServlet�޸ĵ�����
		String name = (String) servletContext.getAttribute("name");
		String pwd = (String)servletContext.getAttribute("pwd");
		System.out.println("name="+name);
		System.out.println("pwd="+pwd);
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

