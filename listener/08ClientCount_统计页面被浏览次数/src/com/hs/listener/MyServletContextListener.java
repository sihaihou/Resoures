package com.hs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	Integer count = 0;
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("count", count);
    }
	
}
