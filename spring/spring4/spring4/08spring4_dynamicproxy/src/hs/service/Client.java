package hs.service;

import java.util.ArrayList;
import java.util.List;

import hs.service.ProxyInovationHandler;

public class Client {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		ProxyInovationHandler proxyInovationHandler = new ProxyInovationHandler();
		proxyInovationHandler.setTarget(userService);
		UserService proxy = (UserService) proxyInovationHandler.getProxy();
		proxy.delete();		
		System.out.println("--------------------------------");
		
		
		
		
		/**
		 * ¡ÈªÓ µœ÷
//		 */
		ProxyInovationHandler proxyHandler = new ProxyInovationHandler();//		
		proxyInovationHandler.setTarget(new ArrayList());
		List proxyList = (List) proxyInovationHandler.getProxy();
		proxyList.clear();;
	}
}
