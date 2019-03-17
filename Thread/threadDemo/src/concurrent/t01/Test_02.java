package concurrent.t01;

import java.util.concurrent.TimeUnit;
/**
 * synchronized关键字
 * 同步方法 - static
 * 静态同步方法，锁的是当前类型的类对象。在本代码中就是Test_02.class
 */
public class Test_02 {
	private static int staticCount = 0;
	
	public static synchronized void testSync4(){
		System.out.println(Thread.currentThread().getName() 
				+ " staticCount = " + staticCount++);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testSync5(){
		synchronized(Test_02.class){
			System.out.println(Thread.currentThread().getName() 
					+ " staticCount = " + staticCount++);
		}
	}
	
}
