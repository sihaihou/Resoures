package hs.factory.simpieFactory;
/**
 * 简单工厂类(也称静态工厂)
 * @author Administrator
 *
 */
public class CarFactory {
	public static Car createCar(String type){
		if("奥迪".equals(type)){
			return new Audi();
		}else if("比亚迪".equals(type)){
			return new Byd();
		}else{
			return null;
		}
	}
}
