package hs.factory.abstractFactory;
/**
 * ���νӿ�
 * @author Administrator
 */
public interface Seat {
	void massage();
}

/**
 * �߶�����
 * @author Administrator
 */
class LuxurySeat implements Seat{
	@Override
	public void massage() {
		System.out.println("�߶����ο��԰�Ħ����������");
	}
}

/**
 * �Ͷ�����
 * @author Administrator
 */
class LowySeat implements Seat{
	@Override
	public void massage() {
		System.out.println("�Ͷ����β��ܰ�Ħ����������");
	}
}