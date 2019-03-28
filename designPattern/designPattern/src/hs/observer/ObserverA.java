package hs.observer;

public class ObserverA implements Observer{
	private int mystate; //��Ҫ��Ŀ������stateֵ����һ�£�
	
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
