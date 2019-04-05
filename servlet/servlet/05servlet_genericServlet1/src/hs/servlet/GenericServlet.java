package hs.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//适配器设计模式
public abstract  class GenericServlet implements Servlet,ServletConfig{
	private ServletConfig cfg;
	
	/**
	 * 实现Servlet接口的方法
	 */
	//模板方法设计模式
	@Override
	public void init(ServletConfig cfg) throws ServletException {
			this.cfg=cfg;	
			this.init();			
	}
	public void init()  {
		//让子类重写该方法，让子类有扩展性
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return cfg;
	}
	//让子类实现
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
	 * 实现ServletConfig接口的方法
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
