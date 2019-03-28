package com.hs.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent hse)  { 
    	ServletContext sc = hse.getSession().getServletContext();
    	Integer count = (Integer)sc.getAttribute("count");
    	count++;
    	sc.setAttribute("count", count);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
