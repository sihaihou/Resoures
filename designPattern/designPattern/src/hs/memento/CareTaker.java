package hs.memento;

import java.util.Stack;

/**
 * 负责人对象
 * 负责管理备忘录对象
 * @author Administrator
 *
 */
public class CareTaker {
	private EmpMemento memento;
	//private Stack<EmpMemento> list=new Stack(); //很多备忘录对象

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}	
}
