package hs.factory.methodFactory;
/**
 * 工厂方法模式接口实现类
 * @author Administrator
 *
 */
public class BydFactory implements CarFactory {
	@Override
	public Car CreateCar() {
		return new Byd();
	}

}
