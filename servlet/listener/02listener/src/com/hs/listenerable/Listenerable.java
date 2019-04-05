package com.hs.listenerable;

import com.hs.event.Event;
import com.hs.listener.Listener;

/**
 * 被监听者接口
 * @author Administrator
 *
 */
public interface Listenerable {
	/**
	 * 
	 * 设置监听者
	 * @param listener
	 */
	void setListener(Listener listener);	
	/**
	 * 触发事件
	 */
	void modfiyListener(Event event);
}
