package hs.proxy.dynamicProxy;

import java.lang.reflect.Proxy;
/**
 *  动态代理实现代理模式
 * @author Administrator
 *
 */
public class App {
	public static void main(String[] args) {
		Star star=new RealStar();
		HandlerStar handler=new HandlerStar(star);
		Star proxy=(Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class} , handler);
		proxy.sing();
	}
}
