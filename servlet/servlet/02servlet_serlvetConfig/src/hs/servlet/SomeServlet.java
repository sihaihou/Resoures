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
		System.err.println("初始化SomeServlet实例。。。cfg:"+cfg);	
		
		//获取servletName
		String servletName=cfg.getServletName();
		System.out.println("servletName="+servletName);
		
		//获取ServletContext
		ServletContext servletContext=cfg.getServletContext();
		System.out.println("servletContext="+servletContext);
		
		//获取所有的初始化对象
		Enumeration<String>	names = cfg.getInitParameterNames();
		//遍历枚举
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = cfg.getInitParameter(name);
			System.out.println(name+"="+value);
		}	
	}
	@Override
	public ServletConfig getServletConfig() {
		return cfg;
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.err.println("创建SomeServlet。。。");		
	}
	@Override
	public void destroy() {
		System.err.println("销毁SomeServlet。。。");
	}
	@Override
	public String getServletInfo() {	
		return "SomeServlet版本信息、作者。。。";
	}
	
}

