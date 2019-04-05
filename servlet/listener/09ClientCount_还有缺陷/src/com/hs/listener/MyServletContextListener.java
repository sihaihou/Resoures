package com.hs.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	List<String> ips = new ArrayList<String>();
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("ips", ips);
    }
	
}
