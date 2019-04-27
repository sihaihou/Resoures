package hs.proxy.staticProxy;
/**
 * 代理角色
 * @author Administrator
 */
public class ProxyStar implements Star{
	private RealStar realstar;
	public ProxyStar(RealStar realstar) {
		this.realstar=realstar;
	}
	@Override
	public void confer() {
		System.out.println("面试");
	}
	@Override
	public void singContract() {
		System.out.println("签合同");
	}
	@Override
	public void bookTicket() {
		System.out.println("订票");
	}
	@Override
	public void sing() {
		realstar.sing();
	}
	@Override
	public void collectMoney() {
		System.out.println("收钱");
	}
}
