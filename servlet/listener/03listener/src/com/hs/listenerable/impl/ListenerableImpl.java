package com.hs.listenerable.impl;

import com.hs.event.Event;
import com.hs.event.impl.EventImpl;
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
	/**
	 * ��������������ҵ���߼�
	 */
	public void insertStudent() {
		System.err.println("�����ݿ��������");
		Event event = new EventImpl(this, "insertStudent");
		this.modfiyListener(event);
	}
	public void deleteStudent() {
		System.err.println("�����ݿ�ɾ������");
		Event event = new EventImpl(this, "deleteStudent");
		this.modfiyListener(event);
	}
	public void updateStudent() {
		System.err.println("�����ݿ��������");
		Event event = new EventImpl(this, "updateStudent");
		this.modfiyListener(event);
	}
	public void selectStudent() {
		System.err.println("�����ݿ��ѯ����");
		Event event = new EventImpl(this, "selectStudent");
		this.modfiyListener(event);
	}
}
