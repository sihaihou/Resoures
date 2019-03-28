package hs.observer;

public class ObserverA implements Observer{
	private int mystate; //需要更目标对象的state值保持一致！
	
	public int getMystate() {
		return mystate;
	}
	public void setMystate(int mystate) {
		this.mystate = mystate;
	}
	@Override
	public void update(Subject subject) {
		mystate=((ConcreteSubject)subject).getState();
	}
}
