package hs.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 *  动态代理实现代理模式
 *		 动态代理类   
 * @author Administrator
 */
public class HandlerStar implements InvocationHandler{
	private Star star;
	public HandlerStar(Star star) {
		this.star = star;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] o) throws Throwable {
		Object obj=null;
		//System.out.println("定义真实角色唱歌前操作：面试、签合同、订机票");
		if(method.getName().equals("sing")){		
			obj=method.invoke(star, o);
		}
		//System.out.println("定义真实角色唱歌后操作:收钱");
		return obj;
	}
}
