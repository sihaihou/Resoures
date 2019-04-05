package com.hs.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	/**
    	 * 创建一个Map，key为ip，value为ip所有的会话。
    	 */
    	Map<String,List<HttpSession>> map = new HashMap();
    	ServletContext sc = sce.getServletContext();
    	
    	sc.setAttribute("map", map);
    }
	
}
