package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OtherServlet implements Servlet{
	private ServletConfig cfg;
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		this.cfg=cfg;		
		//获取ServletContext
		ServletContext servletContext=cfg.getServletContext();
		
		//操作someServlet设置的域属性
		String name = (String) servletContext.getAttribute("name");
		System.out.println("name："+name);
		//重置域属性
		servletContext.setAttribute("name", "李四");
		servletContext.removeAttribute("pwd");
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

