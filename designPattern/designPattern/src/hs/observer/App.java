package hs.observer;

import javax.security.auth.Subject;
/**
 * 观察者模式
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject=new ConcreteSubject();
		//创建多个观察者
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		//将观察者添加到subject对象的观察者队伍中
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
		
		//改变subject状态之前
		System.out.println("改变subject状态之前");
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());

		//改变subject状态
		subject.setState(300);
		//观察者状态是否发生变换
		System.out.println("改变subject状态之后");
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());
	}
}	
