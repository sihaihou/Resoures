package hs.factory.simpieFactory;
/**
 * �򵥹�����2(Ҳ�ƾ�̬����)
 * @author Administrator
 *
 */
public class CarFactory2 {
	public static Car createAudi(){
		return new Audi();	
	}
	public static Car createByd(){
		return new Byd();	
	}
	
}
