package com.hs.listener;

import com.hs.event.Event;

/**
 * �������ӿ�
 * @author Administrator
 *
 */
public interface Listener {
	/**
	 * �����¼�
	 * @param event
	 */
	void handleEvent(Event event);
}
