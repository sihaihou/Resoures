package com.hs.observer.impl;

import com.hs.observer.Observer;
/**
 * �۲��߶���
 * @author Administrator
 *
 */
public class FirstObserver implements Observer {

	@Override
	public void handlerNotify(String message) {
		System.err.println("һ�Ź۲����յ���Ϣ��"+ message+"��,���ڴ�����Ϣ��");
	}

}
