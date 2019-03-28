package com.hs.test;

import com.hs.listener.Listener;
import com.hs.listener.impl.ListenerImpl;
import com.hs.listenerable.impl.ListenerableImpl;

public class Test {
	public static void main(String[] args) {
		
		/**
		 * ����������
		 */
		Listener listener = new ListenerImpl();
		/**
		 * ������������
		 */
		ListenerableImpl listenerableImpl = new ListenerableImpl();
		/**
		 * ���ü�����
		 */
		listenerableImpl.setListener(listener);
		listenerableImpl.insertStudent();
		listenerableImpl.deleteStudent();
		listenerableImpl.updateStudent();
		listenerableImpl.selectStudent();
	}
}
