package hs.factory.simpieFactory;
/**
 * û��ʹ�ù���ģʽ�����
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		Car c1= new Audi();
		Car c2= new Byd();
		c1.run();
		c2.run();
	}
}	
	