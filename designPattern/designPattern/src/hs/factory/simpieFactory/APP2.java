package hs.factory.simpieFactory;
/**
 *  �򵥹�����ʵ��
 * @author Administrator
 */
public class APP2 {
	public static void main(String[] args) {
		Car c1= CarFactory.createCar("�µ�");
		Car c2= CarFactory.createCar("���ǵ�");
		c1.run();
		c2.run();
		Car c3= CarFactory2.createAudi();
		Car c4= CarFactory2.createByd();
		c3.run();
		c4.run();
	}
}
