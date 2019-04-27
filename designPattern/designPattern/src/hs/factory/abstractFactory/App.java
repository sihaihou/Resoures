package hs.factory.abstractFactory;

/**
 * ���󹤳�ģʽ������
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		CarFactory c =new LowCarFactory();		
		Engine e=c.createEngine();
		e.run();
		e.start();
		
		CarFactory c1 =new LuxuryCarFactory();
		Engine e1=c.createEngine();
		e1.run();
		e1.start();
	}
}
