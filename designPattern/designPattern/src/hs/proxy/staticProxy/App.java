package hs.proxy.staticProxy;
/**
 * 静态代理
 * @author 侯四海
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
