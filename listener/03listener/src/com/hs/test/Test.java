package com.hs.test;

import com.hs.listener.Listener;
import com.hs.listener.impl.ListenerImpl;
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
		ListenerableImpl listenerableImpl = new ListenerableImpl();
		/**
		 * 设置监听者
		 */
		listenerableImpl.setListener(listener);
		listenerableImpl.insertStudent();
		listenerableImpl.deleteStudent();
		listenerableImpl.updateStudent();
		listenerableImpl.selectStudent();
	}
}
