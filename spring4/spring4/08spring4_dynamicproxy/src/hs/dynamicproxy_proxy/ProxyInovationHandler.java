package hs.dynamicproxy_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import hs.service.UserService;

public class ProxyInovationHandler implements InvocationHandler{
	private Object target;  //代理处理实例方法的对象 Rent
	
	public ProxyInovationHandler(Object target) {
		super();
		this.target = target;
	}
	/**
	 * proxy是代理类
	 * method 代理类的调用处理程序的方法对象。
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object reslut = method.invoke(target, args);
		after();
		return reslut;
	}
	
	
	/**
	 * 代理类的附属(公共)方法,建议公共方法抽出来单独作为一个类。
	 */
	private void before(){
		System.out.println("执行操作前...");
	}
	private void after(){
		System.out.println("执行操作后...");
	}
}
