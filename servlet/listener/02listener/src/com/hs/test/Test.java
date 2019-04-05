package com.hs.test;

import com.hs.event.Event;
import com.hs.event.impl.EventImpl;
import com.hs.listener.Listener;
import com.hs.listener.impl.ListenerImpl;
import com.hs.listenerable.Listenerable;
import com.hs.listenerable.impl.ListenerableImpl;

public class Test {
	public static void main(String[] args) {
		
		/**
		 * 创建监听者
		 */
		Listener listener = new ListenerImpl();
		/**
		 * 创建被监听者
		 */
		Listenerable listenerable = new ListenerableImpl();
		/**
		 * 创建事件
		 */
		Event event = new EventImpl(listenerable,"update啊大厦  ");
		/**
		 * 设置监听者
		 */
		listenerable.setListener(listener);
		/**
		 * 触发事件
		 */
		listenerable.modfiyListener(event);
	}
}
