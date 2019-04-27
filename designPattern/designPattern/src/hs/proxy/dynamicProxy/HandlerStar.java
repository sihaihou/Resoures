package hs.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 *  ��̬����ʵ�ִ���ģʽ
 *		 ��̬������   
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
		//System.out.println("������ʵ��ɫ����ǰ���������ԡ�ǩ��ͬ������Ʊ");
		if(method.getName().equals("sing")){		
			obj=method.invoke(star, o);
		}
		//System.out.println("������ʵ��ɫ��������:��Ǯ");
		return obj;
	}
}
