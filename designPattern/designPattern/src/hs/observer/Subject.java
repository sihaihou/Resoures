package hs.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	protected List<Observer> list=new ArrayList();
	public void registerObserver(Observer obs){
		list.add(obs);
	}
	public void removeObserver(Observer obs){
		list.remove(obs);
	}
	/**
	 * ֪ͨ���й۲��߸���״̬
	 */
	public void notifyAllObserver(){
		for(Observer obs:list){
			obs.update(this);
		}
	}
}
