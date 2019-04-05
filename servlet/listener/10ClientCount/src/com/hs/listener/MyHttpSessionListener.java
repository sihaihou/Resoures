package com.hs.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    	
    	/**
    	 *  获取ServletContext，在其域中获取map；
    	 *  获取由ip所发出的所有session组成的List；
    	 *  从list中移除当前session
    	 *  把list放回map
    	 *  并把map放回ServletContext域中
    	 */
    	ServletContext sc = hse.getSession().getServletContext();
    	Map<String,List<HttpSession>> map = (Map<String, List<HttpSession>>) sc.getAttribute("map");
    	List<HttpSession> sessions = map.get(clientIp);
    	sessions.remove(session);
    	if(sessions.size()==0) {
    		map.remove(clientIp);
    	}else {
    		map.put(clientIp, sessions);
    	}
    	sc.setAttribute("map", map);
    }
	
}
