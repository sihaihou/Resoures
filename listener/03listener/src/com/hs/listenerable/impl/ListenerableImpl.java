package com.hs.listenerable.impl;

import com.hs.event.Event;
import com.hs.event.impl.EventImpl;
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
	/**
	 * 被监听者真正的业务逻辑
	 */
	public void insertStudent() {
		System.err.println("向数据库插入数据");
		Event event = new EventImpl(this, "insertStudent");
		this.modfiyListener(event);
	}
	public void deleteStudent() {
		System.err.println("向数据库删除数据");
		Event event = new EventImpl(this, "deleteStudent");
		this.modfiyListener(event);
	}
	public void updateStudent() {
		System.err.println("向数据库更新数据");
		Event event = new EventImpl(this, "updateStudent");
		this.modfiyListener(event);
	}
	public void selectStudent() {
		System.err.println("向数据库查询数据");
		Event event = new EventImpl(this, "selectStudent");
		this.modfiyListener(event);
	}
}
