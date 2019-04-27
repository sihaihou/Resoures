package hs.factory.simpieFactory;
/**
 * 没有使用工厂模式情况下
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
	