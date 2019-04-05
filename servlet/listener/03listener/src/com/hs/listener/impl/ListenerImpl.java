package com.hs.listener.impl;

import com.hs.event.Event;
import com.hs.listener.Listener;
/**
 * 监听者对象
 * @author Administrator
 *
 */
public class ListenerImpl implements Listener {
	/**
	 * 处理事件
	 */
	@Override
	public void handleEvent(Event event) {
		String eventType = event.getEventType();
		if(event.INSERT.equals(eventType)) {
			System.err.println("执行了"+eventType+"事件！");
		}else if(event.DELETE.equals(eventType)) {
			System.err.println("执行了"+eventType+"事件！");
		}else if(event.UPDATE.equals(eventType)) {
			System.err.println("执行了"+eventType+"事件！");
		}else if(event.SELECT.equals(eventType)) {
			System.err.println("执行了"+eventType+"事件！");
		}else {
			System.err.println("执行了'select'事件！");
		}
	}
	
}
