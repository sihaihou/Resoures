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
		 * ����������
		 */
		Listener listener = new ListenerImpl();
		/**
		 * ������������
		 */
		Listenerable listenerable = new ListenerableImpl();
		/**
		 * �����¼�
		 */
		Event event = new EventImpl(listenerable,"update������  ");
		/**
		 * ���ü�����
		 */
		listenerable.setListener(listener);
		/**
		 * �����¼�
		 */
		listenerable.modfiyListener(event);
	}
}
