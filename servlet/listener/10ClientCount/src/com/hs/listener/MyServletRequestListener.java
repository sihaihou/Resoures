package com.hs.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyServletRequestListener implements ServletRequestListener {
   
    public void requestInitialized(ServletRequestEvent sre)  { 
    	/**
    	 * 获取request来获取客户端clientIp
    	 */
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	String clientIp = request.getRemoteAddr();
    	
    	/**
    	 * 获取session来把客户端clientIp放入session域中。
    	 */
    	HttpSession currentSession = request.getSession();
    	currentSession.setAttribute("clientIp", clientIp);
    	
    	/**
    	 *  获取ServletContext，在其域中获取map；
    	 *  获取由ip所发出的所有session组成的List；
    	 *  把当前ip放入到list中；
    	 *  把list放回map
    	 *  并把map放回ServletContext域中
    	 */
    	ServletContext sc = sre.getServletContext();
    	Map<String,List<HttpSession>> map = (Map<String, List<HttpSession>>) sc.getAttribute("map");
    	List<HttpSession> sessions = map.get(clientIp);
    	if(sessions == null) {
    		sessions = new ArrayList<HttpSession>();
    	}
    	for (HttpSession session : sessions) {
			if(session == currentSession) {
				return;
			}
		}
    	sessions.add(currentSession);
    	map.put(clientIp, sessions);
    	sc.setAttribute("map", map);
    }
    
    
    public void requestDestroyed(ServletRequestEvent sre)  { 
    }
}
