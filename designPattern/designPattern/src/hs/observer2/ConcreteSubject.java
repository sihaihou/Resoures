package hs.observer2;

import java.util.Observable;
/**
 * 目标对象
 * @author Administrator
 *
 */
public class ConcreteSubject extends Observable{
	private int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setstate(int s){
		state=s;  // 目标状态发生了改变
		setChanged(); //表示目标对象已经做了改变
		notifyObservers(state);	//通知观察者
	}
}
