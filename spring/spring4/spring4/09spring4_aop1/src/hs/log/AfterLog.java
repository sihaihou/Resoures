package hs.log;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * springʵ��aop��
 * 		��һ�ַ�ʽ��ͨ��springAPI��ʵ�֣�ʵ��֪ͨ�ӿڣ�AfterReturningAdvice��MethodBeforeAdvice�ȣ�
 * 
 *		 ����֪ͨ
 * @author Administrator
 */
public class AfterLog implements AfterReturningAdvice{
	/**
	 * retureValue ����ֵ
	 * method �����õķ���
	 * args �����÷����Ĳ���
	 * target �����÷��������Ŀ�����
	 */
	@Override
	public void afterReturning(Object retureValue, Method method, Object[] args, Object target) 
			throws Throwable {
		System.out.println(target.getClass().getName()+"��"+method.getName()+"��ִ���ˣ�����ֵΪ:"+retureValue);
	}
}
