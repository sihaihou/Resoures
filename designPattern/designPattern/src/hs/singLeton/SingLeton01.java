package hs.singLeton;
/**
 * 测试単例设计模式，   ---->确保一个类只有一个对象
 *  饿汉式   --->线程安全，方法没有同步，效率高！但是，没有延时加载优势
 *  1，构造器私有化，避免外部直接创建对象
 *  2，声明一个私有的静态属性  并  创建该对象
 *  3，创建一个对外的公共的静态方法，访问该变量，
 * @author 侯四海
 *
 */
public class SingLeton01 {
	/**
	 * 2，声明一个私有的静态属性  并  创建该对象
	 * 			类初始化时，立即加载这个对象(没有延时加载优势)，加载类时，天然的是线程安全的！(所有。。)
	 */	
	private static SingLeton01 instance =new SingLeton01();
	/**
	 * 1，构造器私有化，避免外部直接创建对象
	 */
	private SingLeton01() {
		
	}
	/**3，创建一个对外的公共的静态方法，访问该变量。
	 * 			方法没有同步，效率高！
	 * @return
	 */
	public static SingLeton01 getInstance(){    //
		return instance;	
	}
}
