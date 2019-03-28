package hs.mediator;
/**
 * ������   �ӿ�
 * @author Administrator
 */
public interface Department {
	/**
	 * ���Լ�����
	 */
	void selfAction();
	/**
	 * ���ܾ���������
	 */
	void outAction();	
}



/**
 * ���岿��---�з���
 * @author Administrator
 */
class Development implements Department{
	/**
	 * �����н��ߵ�����
	 */
	private Mediator m;  
	public Development(Mediator m) {
		this.m = m;
		m.register("Development",this);

	}
	@Override
	public void selfAction() {
		System.out.println("�о���������������");
	}
	@Override
	public void outAction() {
		System.out.println("��Ҫ�ʽ�֧�֡���������");	
		//���������
		m.command("Finacial");
	}
}
/**
 * ���岿��---����
 * @author Administrator
 */
class Finacial implements Department{
	 /**
	  * �����н��ߵ�����
	  */
	private Mediator m; 
	public Finacial(Mediator m) {
		this.m = m;
		m.register("Finacial",this);
	}
	@Override
	public void selfAction() {
		System.out.println("��Ǯ����������");
	}
	@Override
	public void outAction() {
		System.out.println("Ǯ̫���ˣ���ô�죿����������");
		m.command("Development");
		m.command("Market");
	}
}
/**
 * ���岿��---�г���
 * @author Administrator
 */
class Market implements Department{
	/**
	 * �����н��ߵ�����
	 */
	private Mediator m;  
	public Market(Mediator m) {
		this.m = m;
		m.register("Market",this);
	}
	@Override
	public void selfAction() {
		System.out.println("����Ŀ����������");
	}
	@Override
	public void outAction() {
		System.out.println("�㱨��������Ҫ�ʽ�֧�֡���������");
		m.command("Finacial");
	}
}