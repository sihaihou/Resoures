package hs.factory.abstractFactory;
/**
 * ����ӿ�
 * @author Administrator
 */
public interface Engine {
	void run();
	void start();
}

/**
 * �߶�����
 * @author Administrator
 */
class LuxuryEngine implements Engine{
	@Override
	public void run() {
		System.out.println("�ٶȿ졣����������");
	}
	@Override
	public void start() {
		System.out.println("�����죬������������");
	}
}

/**
 * �Ͷ�����
 * @author Administrator
 */
class LowyEngine implements Engine{
	@Override
	public void run() {
		System.out.println("�ٶ���������������");
	}
	@Override
	public void start() {
		System.out.println("��������������������");
	}
}