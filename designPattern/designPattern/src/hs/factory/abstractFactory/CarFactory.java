package hs.factory.abstractFactory;
/**
 * ��������
 * @author Administrator
 */
public interface CarFactory {
	Engine createEngine();  //��������
	Seat createSeat();		//����
	Tyre createTyre();		//��̥
}
