package hs.memento;

import java.util.Stack;

/**
 * �����˶���
 * ���������¼����
 * @author Administrator
 *
 */
public class CareTaker {
	private EmpMemento memento;
	//private Stack<EmpMemento> list=new Stack(); //�ܶ౸��¼����

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}	
}
