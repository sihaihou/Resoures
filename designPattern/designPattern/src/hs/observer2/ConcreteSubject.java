package hs.observer2;

import java.util.Observable;
/**
 * Ŀ�����
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
		state=s;  // Ŀ��״̬�����˸ı�
		setChanged(); //��ʾĿ������Ѿ����˸ı�
		notifyObservers(state);	//֪ͨ�۲���
	}
}
