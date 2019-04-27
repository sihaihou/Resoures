package hs.singLeton;
/**
 * 单利设计模式       确保一个类只有一个对象
 *	  懒汉式--->线程安全,调用效率不高！但是，可以延时加载
 *	  1，构造器私有化，避免外部直接创建对象
 *	  2，声明一个私有的静态属性
 *    3，创建一个对外的公共的静态方法，访问该变量，如果变量没有对象，创建该对象， 
 * @author 侯四海
 */
public class SingLeton02 {
	/**
	 * 类初始化时，不初始化这个对象(延时加载，真正用的时候在创建)
	 */
	private static SingLeton02 instance;
	/**
	 * 私有构造器只供自己使用
	 */
	private SingLeton02() {
		
	}
	/**
	 * 方法同步，效率低
	 * @return
	 */
	public static synchronized SingLeton02 getInstance(){
		if(null==instance){
			instance =new SingLeton02();
		}
		return instance;
	}
}
