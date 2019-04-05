package hs.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import hs.service.UserService;

public class ProxyInovationHandler implements InvocationHandler{
	private Object target;  //������ʵ�������Ķ��� Rent

	public void setTarget(Object target) {
		this.target = target;
	}
	/**
	 * ���ɴ�����
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);		
	}
	/**
	 * proxy�Ǵ�����
	 * method ������ĵ��ô������ķ�������
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		seeHouse();
		Object reslut = method.invoke(target, args);
		fare();
		return reslut;
	}	
	
	
	/**
	 * ������ĸ���(����)����,���鹫�����������������Ϊһ���ࡣ
	 */
	private void seeHouse(){
		System.out.println("�����Ϳ���");
	}
	private void fare(){
		System.out.println("��ȡ�н��");
	}
}
