package hs.strategy;

/**
 * �����㷨 �ӿ�  
 * @author Administrator
 */
public interface  Strategy {
	public double getPrice(double standardPrice);
}

/**
 * �¿ͻ�С����
 * @author Administrator
 */
class NewCustomerFewStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("������˼�������ۣ�ԭ��");
		return standardPrice;
	}	
}
/**
 * �¿ͻ�������
 * @author Administrator
 */
class newCustomermanyStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("����");
		return standardPrice*0.9;
	}	
}
/**
 * �Ͽͻ�С����
 * @author Administrator
 */
class OldCustomerFewStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("������");
		return standardPrice*0.85;
	}	
}
/**
 * �Ͽͻ�������
 * @author Administrator
 */
class OldCustomermanyStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("����");		
		return standardPrice*0.7;	}	
}
