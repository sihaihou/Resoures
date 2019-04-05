package hs.log;

/**
 * spring实现aop：
 * 			第二种方式：自定义类实现aop 
 * @author Administrator
 *
 */
public class Log {
	public void before(){
		System.out.println("------方法执行前------ ");
	}
	public void after(){
		System.out.println("------方法执行后------ ");
	}
}
