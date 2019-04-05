package com.hs.observerable;

import com.hs.observer.Observer;
/**
 * 被观察者接口
 * @author Administrator
 *
 */
public interface Observerable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver(String message);
}
