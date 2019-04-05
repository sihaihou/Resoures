package hs.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * springʵ��aop��
 * 		��һ�ַ�ʽ��ͨ��springAPI��ʵ�֣�ʵ��֪ͨ�ӿڣ�AfterReturningAdvice��MethodBeforeAdvice�ȣ�
 * 
 *		 ǰ��֪ͨ
 * @author Administrator
 */
public class BeforeLog implements MethodBeforeAdvice{
	/**
	 * @param method �����õķ���
	 * @param args �����÷����Ĳ���
	 * @param target �����÷�����Ŀ�����
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(target.getClass().getName()+"��"+method.getName()+"������ִ����");
	}
}
