package hs.adapter;
/**
 * ��������(�൱��ת����)
 * (����������,ʹ������ϵķ�ʽ���������������)
 * @author Administrator
 */
public class Adapter2 implements Target{
	private Adaptee apadtee;
	
	public Adapter2(Adaptee apadtee) {
		this.apadtee = apadtee;
	}
	@Override
	public void handleReq() {
		apadtee.request();
	}
	
}
