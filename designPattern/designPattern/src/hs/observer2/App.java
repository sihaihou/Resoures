package hs.observer2;
/**
 * �۲���ģʽ
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		//Ŀ�����
		ConcreteSubject subject=new ConcreteSubject();
		//��������۲���
		ObserverA obs1=new ObserverA();
		ObserverA obs2=new ObserverA();
		//���۲�����ӵ�subject����Ĺ۲��߶�����
		subject.addObserver(obs1);
		subject.addObserver(obs2);
		
		//�ı�subject״̬֮ǰ
		System.out.println("�ı�subject״̬֮ǰ");
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());

		//�ı�subject״̬
		subject.setstate(500);
		//�۲���״̬�Ƿ����任
		System.out.println("�ı�subject״̬֮��");
		System.out.println(obs1.getMystate());
		System.out.println(obs2.getMystate());
	}
}
