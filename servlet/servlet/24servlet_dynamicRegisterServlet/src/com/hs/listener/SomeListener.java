package com.hs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class SomeListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.err.println("listenerÒÑ±»×¢²á");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {

	}
}
