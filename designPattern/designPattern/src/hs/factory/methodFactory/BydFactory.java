package hs.factory.methodFactory;
/**
 * ��������ģʽ�ӿ�ʵ����
 * @author Administrator
 *
 */
public class BydFactory implements CarFactory {
	@Override
	public Car CreateCar() {
		return new Byd();
	}

}
