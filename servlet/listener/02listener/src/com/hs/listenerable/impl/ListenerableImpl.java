package com.hs.listenerable.impl;

import com.hs.event.Event;
import com.hs.listener.Listener;
import com.hs.listenerable.Listenerable;
/**
 * 被监听者
 * @author Administrator
 *
 */
public class ListenerableImpl implements Listenerable {
	private Listener listener;
	
	/**
	 * 设置监听者
	 */
	@Override
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	/**
	 * 触发事件
	 */
	@Override
	public void modfiyListener(Event event) {
		listener.handleEvent(event);
	}
}
