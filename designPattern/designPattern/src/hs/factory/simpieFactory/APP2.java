package hs.factory.simpieFactory;
/**
 *  简单工厂类实现
 * @author Administrator
 */
public class APP2 {
	public static void main(String[] args) {
		Car c1= CarFactory.createCar("奥迪");
		Car c2= CarFactory.createCar("比亚迪");
		c1.run();
		c2.run();
		Car c3= CarFactory2.createAudi();
		Car c4= CarFactory2.createByd();
		c3.run();
		c4.run();
	}
}
