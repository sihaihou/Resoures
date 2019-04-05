package com.hs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/**
 * Request被创建、销毁时执行
 */
public class MyServletRequestListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Request被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("Request被创建");
	}

}
