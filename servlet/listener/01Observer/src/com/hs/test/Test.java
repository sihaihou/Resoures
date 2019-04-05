package com.hs.test;

import com.hs.observer.Observer;
import com.hs.observer.impl.FirstObserver;
import com.hs.observer.impl.SecondObserver;
import com.hs.observerable.Observerable;
import com.hs.observerable.impl.ObserverableOne;

public class Test {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Observer first = new FirstObserver();
		Observer second = new SecondObserver();
		Observerable observerableOne = new ObserverableOne();
		observerableOne.addObserver(first);
		observerableOne.addObserver(second);
		observerableOne.notifyObserver("全体出发。。。");
		long end =System.currentTimeMillis();
		System.err.println(end-start);
	}
}
