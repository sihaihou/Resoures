 package hs.singLeton;

import java.io.Serializable;

/**
 * 单利设计模式     
 *	  懒汉式--->(如何防止反射和反序列化漏洞)
 * @author Administrator
 */
public class SingLeton05 implements Serializable{
	/**
	 * 类初始化时，不初始化这个对象(延时加载，真正用的时候在创建)
	 */
	private static SingLeton05 instance;	
	private SingLeton05()  {
		//防止反射漏洞：如果有对象了，再次调用，就抛出RuntimeException异常.
		if(null!=instance){
			throw new RuntimeException();
		}	
	}
	/**
	 * 方法同步，效率低
	 * @return
	 */
	public static synchronized SingLeton05 getInstance(){
		if(null==instance){
			instance =new SingLeton05();
		}
		return instance;
	}
	
	/**
	 * 防止反序列化漏洞(反序列化，如果定义了readResolve方法，则直接返回此方法指定的对象，而不需要单独创建对象)
	 * @return
	 * @throws Exception
	 */
	public Object readResolve()throws Exception{
		return instance;
	}
}
