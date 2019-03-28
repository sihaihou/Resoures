package hs.observer2;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{
	protected int mystate;	
	
	public int getMystate() {
		return mystate;
	}

	public void setMystate(int mystate) {
		this.mystate = mystate;
	}

	@Override
	public void update(Observable o, Object arg) {
		mystate=((ConcreteSubject)o).getState();
	}
	
}
