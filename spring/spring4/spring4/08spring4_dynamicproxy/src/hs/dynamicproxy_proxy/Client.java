package hs.dynamicproxy_proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * �ͻ�
 * @author Administrator
 */
public class Client {
	public static void main(String[] args) {
		Host host = new Host();
		ProxyInovationHandler Handler = new ProxyInovationHandler(host);
		Rent proxy =(Rent) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Rent.class}, Handler);
		proxy.rent();
		System.out.println("-----------------------------");
		/**
		 * ���ʵ��
//		 */
		ProxyInovationHandler proxyHandler = new ProxyInovationHandler(new ArrayList());//	
		List proxyList=(List) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{List.class}, proxyHandler);
		proxyList.add("aa");
	}
}
