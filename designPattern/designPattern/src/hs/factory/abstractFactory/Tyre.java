package hs.factory.abstractFactory;
/**
 * ��̥�ӿ�
 * @author Administrator
 */
public interface Tyre {
	void revolve();
}

/**
 * �߶���̥
 * @author Administrator
 */
class LuxuryTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("����ĥ�𡣡�����");
	}
}
/**
 * �Ͷ���̥
 * @author Administrator
 */
class LowTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("ĥ��졣��������");
	}
}