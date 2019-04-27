package hs.proxy.staticProxy;
/**
 * �����ɫ
 * @author Administrator
 */
public class ProxyStar implements Star{
	private RealStar realstar;
	public ProxyStar(RealStar realstar) {
		this.realstar=realstar;
	}
	@Override
	public void confer() {
		System.out.println("����");
	}
	@Override
	public void singContract() {
		System.out.println("ǩ��ͬ");
	}
	@Override
	public void bookTicket() {
		System.out.println("��Ʊ");
	}
	@Override
	public void sing() {
		realstar.sing();
	}
	@Override
	public void collectMoney() {
		System.out.println("��Ǯ");
	}
}
