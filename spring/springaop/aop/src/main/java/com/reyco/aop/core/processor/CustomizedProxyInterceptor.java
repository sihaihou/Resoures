package com.reyco.aop.core.processor;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.reyco.aop.core.handler.ProxyBeanHandler;
import com.reyco.aop.core.utils.ConfigurationUtil;

/**
 * 代理对象
 * @author reyco
 *
 */
public class CustomizedProxyInterceptor implements MethodInterceptor  {

	private List<ProxyBeanHandler> proxyBeanHandlerList;

	public CustomizedProxyInterceptor(List<ProxyBeanHandler> proxyBeanHandlerList) {
		this.proxyBeanHandlerList = proxyBeanHandlerList;
	}
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //处理前置及环绕前置通知
        for (ProxyBeanHandler proxyBeanHolder: proxyBeanHandlerList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            if (annotationName.equals(ConfigurationUtil.BEFORE)||annotationName.equals(ConfigurationUtil.AROUND))
                this.doProxy(proxyBeanHolder);
        }
        Object result = null;
        try{
            result = methodProxy.invokeSuper(o, objects);
        }catch (Exception e){
            System.out.println("get ex:"+e.getMessage());
            throw e;
        }
        //处理前置及环绕前置通知
        for (ProxyBeanHandler proxyBeanHolder: proxyBeanHandlerList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            if (annotationName.equals(ConfigurationUtil.AFTER)||annotationName.equals(ConfigurationUtil.AROUND))
                this.doProxy(proxyBeanHolder);
        }
        return result;
	}
	 /**
     * 处理代理操作
     * @param proxyBeanHolder
     */
    private void doProxy(ProxyBeanHandler proxyBeanHolder){
        String className = proxyBeanHolder.getClassName();
        String methodName = proxyBeanHolder.getMethodName();
        Object classzz = null;
        try {
            classzz = Class.forName(className);
            Method[] methods = ((Class) classzz).getMethods();
            for (Method poxyMethod:methods)
                if (poxyMethod.getName().equals(methodName))
                    poxyMethod.invoke(((Class) classzz).newInstance(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
