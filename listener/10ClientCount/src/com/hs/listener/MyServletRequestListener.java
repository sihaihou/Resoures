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
    	 * ��ȡrequest����ȡ�ͻ���clientIp
    	 */
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	String clientIp = request.getRemoteAddr();
    	
    	/**
    	 * ��ȡsession���ѿͻ���clientIp����session���С�
    	 */
    	HttpSession currentSession = request.getSession();
    	currentSession.setAttribute("clientIp", clientIp);
    	
    	/**
    	 *  ��ȡServletContext���������л�ȡmap��
    	 *  ��ȡ��ip������������session��ɵ�List��
    	 *  �ѵ�ǰip���뵽list�У�
    	 *  ��list�Ż�map
    	 *  ����map�Ż�ServletContext����
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
