package com.hs.observer.impl;

import com.hs.observer.Observer;
/**
 * �۲��߶���
 * @author Administrator
 *
 */
public class SecondObserver implements Observer {

	@Override
	public void handlerNotify(String message) {
		System.err.println("���Ź۲����յ���Ϣ��"+ message+"��,���ڴ�����Ϣ��");
	}

}
