package com.hs.event;

import com.hs.listenerable.Listenerable;

/**
 * 事件接口
 * @author Administrator
 *
 */
public interface Event {
	String INSERT = "insert";
	String DELETE = "delete";
	String UPDATE = "update";
	String SELECT = "select";
	/**
	 * 获取事件源
	 * @return
	 */
	Listenerable getListenerable();
	/**
	 * 获取事件类型
	 * @return
	 */
	String getEventType();
}
