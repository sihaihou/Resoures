package hs.singLeton;
/**
 * 通过静态内部类实现単例模式
 * 这种方法：线程安全，调用效率高，并且实现了延时加载
 * @author Administrator
 */
public class SingLeton03 {	
	/**
	 * 只有调用getInstance()方法时，这个类才会被加载
	 * @author Administrator
	 *
	 */
	private static class Test03SingLetonInstance{
		private static final SingLeton03 INSTANCE=new SingLeton03();
	} 	
	private SingLeton03() {
		
	}	
	/**
	 * 方法没有同步，效率高！
	 * @return
	 */
	public static SingLeton03 getInstance(){
		return Test03SingLetonInstance.INSTANCE;	
	}	
}
