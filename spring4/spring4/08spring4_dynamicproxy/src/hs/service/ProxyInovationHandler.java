package hs.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import hs.service.UserService;

public class ProxyInovationHandler implements InvocationHandler{
	private Object target;  //代理处理实例方法的对象 Rent
	public void setTarget(Object target) {
		this.target = target;
	}
	
	/**
	 * 生成代理类
	 * @return
	 */
	public Object getProxy(){
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);		
	}
	/**
	 * proxy是代理类
	 * method 代理类的调用处理程序的方法对象。
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		log(method.getName());
		Object reslut = method.invoke(target, args);
		return reslut;
	}
	
	
	
	/**
	 * 代理类的附属(公共)方法,建议公共方法抽出来单独作为一个类。
	 */
	public void log(String methodName){
		System.out.println("执行"+methodName+"方法");
	}
}
