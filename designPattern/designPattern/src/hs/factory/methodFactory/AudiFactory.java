package hs.factory.methodFactory;
/**
 * 工厂方法模式接口方法的重写
 * @author Administrator
 *
 */
public class AudiFactory implements CarFactory {
	@Override
	public Car CreateCar() {
		return new Audi();
	}

}
