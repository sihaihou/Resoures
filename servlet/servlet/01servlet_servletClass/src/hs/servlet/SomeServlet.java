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
		System.out.println("��ʼ��SomeServletʵ��������");		
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("����SomeServlet������");		
	}
	@Override
	public void destroy() {
		System.out.println("����SomeServlet������");
	}
	@Override
	public String getServletInfo() {	
		return "SomeServlet�汾��Ϣ�����ߡ�����";
	}
	

}
