package hs.staticproxy;
/**
 * �����ɫ
 * @author Administrator
 *
 */
public class Proxy implements Rent{
	private Host host;	
	
	public Proxy(Host host) {
		super();
		this.host = host;
	}
	//�ⷿ
	@Override
	public void rent() {
		seeHouse();
		host.rent();
		fare();
	}
	//����
	private void seeHouse(){
		System.out.println("�����Ϳ���");
	}
	//�շ�
	private void fare(){
		System.out.println("��ȡ�н��");
	}
}
