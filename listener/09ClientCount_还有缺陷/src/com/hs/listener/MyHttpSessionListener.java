package com.hs.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent hse)  { 
    	
    }

    public void sessionDestroyed(HttpSessionEvent hse)  { 
    	HttpSession session = hse.getSession();
    	String clientIp = (String) session.getAttribute("clientIp");
    	
    	ServletContext sc = hse.getSession().getServletContext();
    	List<String> ips = (List<String>) sc.getAttribute("ips");
    	
    	ips.remove(clientIp);
    	sc.setAttribute("ips",ips);
    }
	
}
