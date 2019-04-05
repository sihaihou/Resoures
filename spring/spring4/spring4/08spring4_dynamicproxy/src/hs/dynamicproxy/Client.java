package hs.dynamicproxy;

import java.util.ArrayList;
import java.util.List;

/**
 * ¿Í»§
 * @author Administrator
 */
public class Client {
	public static void main(String[] args) {
		Host host = new Host();
		ProxyInovationHandler proxyInovationHandler = new ProxyInovationHandler();
		proxyInovationHandler.setTarget(host);
		Rent proxy = (Rent) proxyInovationHandler.getProxy();
		proxy.rent();
	}
}
