package com.hs.listener;

import java.util.HashMap;
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
    	 * ����һ��Map��key��Ϊ�û���valueΪ���û���session
    	 * Ȼ�����ServletContextȫ������
    	 */
    	Map<String,HttpSession> map = new HashMap<String,HttpSession>();
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("map", map);
    }
	
}
