package hs.threadlocal;

public class Test {
	public static void main(String[] args) {
		//ThreadLocal 存放线程局部变量的容器。
		//存放在 ThreadLocal中的局部变量是线程安全的。
		final ThreadLocal threadlocal = new ThreadLocal();
		threadlocal.set("张三");
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Thread："+threadlocal.get());				
			}			
		}).start();;
		System.out.println(threadlocal.get());
	}
}
