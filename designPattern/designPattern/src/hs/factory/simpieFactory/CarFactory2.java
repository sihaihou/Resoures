package hs.factory.simpieFactory;
/**
 * 简单工厂类2(也称静态工厂)
 * @author Administrator
 *
 */
public class CarFactory2 {
	public static Car createAudi(){
		return new Audi();	
	}
	public static Car createByd(){
		return new Byd();	
	}
	
}
