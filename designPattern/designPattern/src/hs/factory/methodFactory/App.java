package hs.factory.methodFactory;
/**
 * ��������ģʽʵ����
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		//new AudiFactory().CreateCar().run();
		Car c=new AudiFactory().CreateCar();
		c.run();		
	}
}
