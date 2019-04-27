package hs.factory.methodFactory;
/**
 * 方法工厂模式实现类
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		//new AudiFactory().CreateCar().run();
		Car c=new AudiFactory().CreateCar();
		c.run();		
	}
}
