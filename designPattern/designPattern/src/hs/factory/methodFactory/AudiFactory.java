package hs.factory.methodFactory;
/**
 * ��������ģʽ�ӿڷ�������д
 * @author Administrator
 *
 */
public class AudiFactory implements CarFactory {
	@Override
	public Car CreateCar() {
		return new Audi();
	}

}
