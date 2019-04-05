package hs.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.err.println("执行SomeServlet的service()方法");
		String param = this.getInitParameter("name");
		String servletName = this.getServletName();
		System.out.println("param="+param+"    servletName="+servletName);
	}
	
	@Override
	public void init() {
		System.out.println("==============");
	}

}
