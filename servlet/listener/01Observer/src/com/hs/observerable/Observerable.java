package com.hs.observerable;

import com.hs.observer.Observer;
/**
 * ���۲��߽ӿ�
 * @author Administrator
 *
 */
public interface Observerable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver(String message);
}
