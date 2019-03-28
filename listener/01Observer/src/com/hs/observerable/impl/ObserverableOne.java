package com.hs.observerable.impl;

import java.util.ArrayList;
import java.util.List;

import com.hs.observer.Observer;
import com.hs.observerable.Observerable;
/**
 * 被观察者对象
 * @author Administrator
 *
 */
public class ObserverableOne implements Observerable {
	private List<Observer> observers;
	
	public ObserverableOne() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver(String message) {
		for (Observer observer : observers) {
			observer.handlerNotify(message);
		}
	}

}
