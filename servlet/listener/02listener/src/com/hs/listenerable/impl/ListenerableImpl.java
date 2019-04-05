package com.hs.listenerable.impl;

import com.hs.event.Event;
import com.hs.listener.Listener;
import com.hs.listenerable.Listenerable;
/**
 * ��������
 * @author Administrator
 *
 */
public class ListenerableImpl implements Listenerable {
	private Listener listener;
	
	/**
	 * ���ü�����
	 */
	@Override
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	/**
	 * �����¼�
	 */
	@Override
	public void modfiyListener(Event event) {
		listener.handleEvent(event);
	}
}
