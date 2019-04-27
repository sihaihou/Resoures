package hs.observer;

public class ConcreteSubject extends Subject{
	private int state;

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
		//主题(目标)对象发生变化，请通知所有观察者
		this.notifyAllObserver();
	}
}
