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
		 * 动态注册Servlet:
		 * 	servletName,servletClass可以从配置文件中读取
		 */
		String servletName = "SomeServlet";
		String servletClass = "com.hs.servlet.SomeServlet";
		ServletRegistration.Dynamic srd = servletContext.addServlet(servletName, servletClass);
		//为Servlet添加动态参数
		srd.setInitParameter("username", "zhangsan");
		srd.setInitParameter("password", "123456");
		//为Serlvet动态添加url-pattern
		srd.addMapping("/some");
		
		/**
		 * 动态注册Filter:
		 * 	filterName、filterClass可以从配置文件中读取
		 */
		String filterName = "SomeFilter";
		String filterClass = "com.hs.filter.SomeFilter";
		FilterRegistration.Dynamic frd = servletContext.addFilter(filterName, filterClass);
		//为filter添加url-pattern
		//frd.addMappingForUrlPatterns(EnumSet.of(DispatcherType.FORWARD), true, "/*");
		//为filter添加拦截Servlet
		frd.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "SomeServlet");
		
		/**
		 * 动态注册Listener:
		 *   listenerClass可以从配置文件中读取
		 */
		String listenerClass = "com.hs.listener.SomeListener";
		servletContext.addListener(listenerClass);			
	}

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.err.println("MyServletContextListener被销毁");
	}
}
