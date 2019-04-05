package hs.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeServlet implements Servlet{
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化SomeServlet实例。。。");		
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("创建SomeServlet。。。");		
	}
	@Override
	public void destroy() {
		System.out.println("销毁SomeServlet。。。");
	}
	@Override
	public String getServletInfo() {	
		return "SomeServlet版本信息、作者。。。";
	}
	

}
