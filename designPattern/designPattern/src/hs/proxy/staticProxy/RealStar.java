package hs.proxy.staticProxy;
/**
 * 真实角色
 * @author Administrator
 */
public class RealStar implements Star {
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
		System.out.println("金南铃本人演唱《逆流成河》");
	}
	@Override
	public void collectMoney() {
		System.out.println("收钱");
	}
}
