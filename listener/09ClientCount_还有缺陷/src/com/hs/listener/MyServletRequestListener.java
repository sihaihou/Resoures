package com.hs.listener;

import java.util.List;

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
    	System.err.println("clientIp===="+clientIp);
    	
    	/**
    	 * 获取session来把客户端clientIp放入session域中。
    	 */
    	HttpSession session = request.getSession();
    	session.setAttribute("clientIp", clientIp);
    	
    	/**
    	 *  获取ServletContext，在其域中获取ips，把客户端clientIp添加到ips中，
    	 *  并把ips放回ServletContext域中
    	 */
    	ServletContext sc = sre.getServletContext();
    	List<String> ips = (List<String>) sc.getAttribute("ips");
    	for(String ip :ips) {
    		if(clientIp.equals(ip)) {
    			return;
    		}
    	}
    	ips.add(clientIp);
    	sc.setAttribute("ips", ips);
    }
    
    
    public void requestDestroyed(ServletRequestEvent sre)  { 
    }
}
