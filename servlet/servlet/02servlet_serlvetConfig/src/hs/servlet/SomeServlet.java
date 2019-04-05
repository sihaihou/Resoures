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
		System.err.println("��ʼ��SomeServletʵ��������cfg:"+cfg);	
		
		//��ȡservletName
		String servletName=cfg.getServletName();
		System.out.println("servletName="+servletName);
		
		//��ȡServletContext
		ServletContext servletContext=cfg.getServletContext();
		System.out.println("servletContext="+servletContext);
		
		//��ȡ���еĳ�ʼ������
		Enumeration<String>	names = cfg.getInitParameterNames();
		//����ö��
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
		System.err.println("����SomeServlet������");		
	}
	@Override
	public void destroy() {
		System.err.println("����SomeServlet������");
	}
	@Override
	public String getServletInfo() {	
		return "SomeServlet�汾��Ϣ�����ߡ�����";
	}
	
}

