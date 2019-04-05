package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//���������ģʽ
public abstract  class GenericServlet implements Servlet,ServletConfig{
	private ServletConfig cfg;
	
	/**
	 * ʵ��Servlet�ӿڵķ���
	 */
	//ģ�巽�����ģʽ
	@Override
	public void init(ServletConfig cfg) throws ServletException {
			this.cfg=cfg;	
			this.init();			
	}
	public void init()  {
		//��������д�÷���������������չ��
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return cfg;
	}
	//������ʵ��
	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException;
	
	@Override
	public void destroy() {
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	
	
	
	/**
	 * ʵ��ServletConfig�ӿڵķ���
	 */
	@Override
	public String getInitParameter(String name) {
		return cfg.getInitParameter(name);
	}
	@Override
	public Enumeration<String> getInitParameterNames() {
		return cfg.getInitParameterNames();
	}
	@Override
	public ServletContext getServletContext() {
		return cfg.getServletContext();
	}
	@Override
	public String getServletName() {
		return cfg.getServletName();
	}
	
	
}
