package com.hs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/**
 * Request������������ʱִ��
 */
public class MyServletRequestListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Request������");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("Request������");
	}

}
