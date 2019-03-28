package com.hs.event.impl;

import com.hs.event.Event;
import com.hs.listenerable.Listenerable;

/**
 * 事件对象
 * @author Administrator
 *
 */
public class EventImpl implements Event{
	private Listenerable listenerable;
	private String methodName;
	public EventImpl(Listenerable listenerable,String methodName) {
		super();
		this.listenerable = listenerable;
		this.methodName = methodName;
	}

	@Override
	public Listenerable getListenerable() {
		return listenerable;
	}

	@Override
	public String getEventType() {
		String eventType = null;
		if(methodName.startsWith("insert")) {
			eventType = INSERT;
		}else if(methodName.startsWith("delete")) {
			eventType = DELETE;
		}else if(methodName.startsWith("update")) {
			eventType = UPDATE;
		}else if(methodName.startsWith("select")) {
			eventType = SELECT;
		}else {
			eventType ="hava not is event";
		}
		return eventType;
	}
	
}
