package com.hs.listenerable;

import com.hs.event.Event;
import com.hs.listener.Listener;

/**
 * �������߽ӿ�
 * @author Administrator
 *
 */
public interface Listenerable {
	/**
	 * 
	 * ���ü�����
	 * @param listener
	 */
	void setListener(Listener listener);	
	/**
	 * �����¼�
	 */
	void modfiyListener(Event event);
}
