package concurrent.t01;
/**
 * synchronized关键字
 * 常量问题
 * 在定义同步代码块时，不要使用常量对象作为锁对象。
 */
public class Test_14 {
	String s1 = "hello";
	String s2 = new String("hello"); // new关键字，一定是在堆中创建一个新的对象。
	Integer i1 = 1;
	Integer i2 = 1;
	void m1(){
		synchronized (i1) {
			System.out.println("m1()");
			while(true){
				
			}
		}
	}
	
	void m2(){
		synchronized (i2) {
			System.out.println("m2()");
			while(true){
				
			}
		}
	}
	
	public static void main(String[] args) {
		final Test_14 t = new Test_14();
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				t.m2();
			}
		}).start();
	}
	
}
