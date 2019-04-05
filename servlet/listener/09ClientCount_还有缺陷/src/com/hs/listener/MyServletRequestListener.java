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
    	 * ��ȡrequest����ȡ�ͻ���clientIp
    	 */
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	String clientIp = request.getRemoteAddr();
    	System.err.println("clientIp===="+clientIp);
    	
    	/**
    	 * ��ȡsession���ѿͻ���clientIp����session���С�
    	 */
    	HttpSession session = request.getSession();
    	session.setAttribute("clientIp", clientIp);
    	
    	/**
    	 *  ��ȡServletContext���������л�ȡips���ѿͻ���clientIp��ӵ�ips�У�
    	 *  ����ips�Ż�ServletContext����
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
