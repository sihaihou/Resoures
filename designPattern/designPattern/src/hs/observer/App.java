package hs.observer;

import javax.security.auth.Subject;
/**
 * �۲���ģʽ
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		//Ŀ�����
		ConcreteSubject subject=new ConcreteSubject();
		//��������۲���
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		//���۲�����ӵ�subject����Ĺ۲��߶�����
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
		
		//�ı�subject״̬֮ǰ
		System.out.println("�ı�subject״̬֮ǰ");
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());

		//�ı�subject״̬
		subject.setState(300);
		//�۲���״̬�Ƿ����任
		System.out.println("�ı�subject״̬֮��");
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());
	}
}	
