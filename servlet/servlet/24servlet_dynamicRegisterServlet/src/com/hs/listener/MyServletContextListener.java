package com.hs.listener;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		ServletContext servletContext = sc.getServletContext();
		
		/**
		 * ��̬ע��Servlet:
		 * 	servletName,servletClass���Դ������ļ��ж�ȡ
		 */
		String servletName = "SomeServlet";
		String servletClass = "com.hs.servlet.SomeServlet";
		ServletRegistration.Dynamic srd = servletContext.addServlet(servletName, servletClass);
		//ΪServlet��Ӷ�̬����
		srd.setInitParameter("username", "zhangsan");
		srd.setInitParameter("password", "123456");
		//ΪSerlvet��̬���url-pattern
		srd.addMapping("/some");
		
		/**
		 * ��̬ע��Filter:
		 * 	filterName��filterClass���Դ������ļ��ж�ȡ
		 */
		String filterName = "SomeFilter";
		String filterClass = "com.hs.filter.SomeFilter";
		FilterRegistration.Dynamic frd = servletContext.addFilter(filterName, filterClass);
		//Ϊfilter���url-pattern
		//frd.addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD), true, "/*");
		//Ϊfilter�������Servlet
		frd.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "SomeServlet");
		
		/**
		 * ��̬ע��Listener:
		 *   listenerClass���Դ������ļ��ж�ȡ
		 */
		String listenerClass = "com.hs.listener.SomeListener";
		servletContext.addListener(listenerClass);			
	}

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.err.println("MyServletContextListener������");
	}
}
