package hs.templatemethod;

public abstract class BankTempLateMethod {
	//���巽��
	public void takeNumber(){
		System.out.println("�Ŷ�ȡ�š���������");
	}
	public abstract void transact(); //��������ҵ��     ���ӷ���
	
	public void evaluate(){
		System.out.println("�������֡���������");
	}
	public final void process(){
		takeNumber();
		transact();
		evaluate();
	}
}
