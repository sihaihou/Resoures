package com.hs.listener.impl;

import com.hs.event.Event;
import com.hs.listener.Listener;
/**
 * �����߶���
 * @author Administrator
 *
 */
public class ListenerImpl implements Listener {
	/**
	 * �����¼�
	 */
	@Override
	public void handleEvent(Event event) {
		String eventType = event.getEventType();
		if(event.INSERT.equals(eventType)) {
			System.err.println("ִ����"+eventType+"�¼���");
		}else if(event.DELETE.equals(eventType)) {
			System.err.println("ִ����"+eventType+"�¼���");
		}else if(event.UPDATE.equals(eventType)) {
			System.err.println("ִ����"+eventType+"�¼���");
		}else if(event.SELECT.equals(eventType)) {
			System.err.println("ִ����"+eventType+"�¼���");
		}else {
			System.err.println("ִ����'select'�¼���");
		}
	}
	
}
