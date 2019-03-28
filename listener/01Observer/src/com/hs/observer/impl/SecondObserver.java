package com.hs.observer.impl;

import com.hs.observer.Observer;
/**
 * 观察者对象
 * @author Administrator
 *
 */
public class SecondObserver implements Observer {

	@Override
	public void handlerNotify(String message) {
		System.err.println("二号观察者收到信息【"+ message+"】,正在处理信息！");
	}

}
