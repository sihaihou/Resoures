package hs.proxy.staticProxy;
/**
 * ��̬����
 * @author ���ĺ�
 */
public class App {
	public static void main(String[] args) {
		RealStar realstar=new RealStar();
		ProxyStar proxystar=new ProxyStar(realstar);
		
		proxystar.confer();
		proxystar.singContract();
		proxystar.bookTicket();
		proxystar.sing();
		proxystar.collectMoney();
	}
}
