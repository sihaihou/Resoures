package com.hs.listener;

import com.hs.event.Event;

/**
 * 监听器接口
 * @author Administrator
 *
 */
public interface Listener {
	/**
	 * 处理事件
	 * @param event
	 */
	void handleEvent(Event event);
}
