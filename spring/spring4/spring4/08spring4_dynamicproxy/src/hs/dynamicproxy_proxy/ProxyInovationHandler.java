package hs.dynamicproxy_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import hs.service.UserService;

public class ProxyInovationHandler implements InvocationHandler{
	private Object target;  //������ʵ�������Ķ��� Rent
	
	public ProxyInovationHandler(Object target) {
		super();
		this.target = target;
	}
	/**
	 * proxy�Ǵ�����
	 * method ������ĵ��ô������ķ�������
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
	 * ������ĸ���(����)����,���鹫�����������������Ϊһ���ࡣ
	 */
	private void before(){
		System.out.println("ִ�в���ǰ...");
	}
	private void after(){
		System.out.println("ִ�в�����...");
	}
}
