package com.reyco.aop.core.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import com.reyco.aop.core.utils.ConfigurationUtil;

/**
 * 
 * @author reyco
 *
 */
@Component
public class RealizedAopBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		String targetClass = bean.getClass().getName();
		Object object = bean;
		// 判断
		if (ConfigurationUtil.classzzProxyBeanHandler.containsKey(targetClass)) {
			// 包含，替换成代理类
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(object.getClass());
			enhancer.setCallback(new CustomizedProxyInterceptor(ConfigurationUtil.classzzProxyBeanHandler.get(targetClass)));
			object = enhancer.create();
		}
		return object;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
