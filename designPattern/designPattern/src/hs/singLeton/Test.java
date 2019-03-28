package hs.singLeton;

import java.util.concurrent.CountDownLatch;
/**
 * 测试几种単例设计模式的效率
 * @author Administrator
 */
public class Test {
	public static void main(String[] args)throws Exception {
		long start = System.currentTimeMillis();
		int num=10;
		final CountDownLatch countDownLatch=new CountDownLatch(num);		
		for(int i=0;i<num;i++){
			new Thread(new Runnable(){
				@Override
				public void run(){
					for(int i=0;i<1000000;i++){
						Object c1=SingLeton01.getInstance();  //饿汉式
						//Object c2=SingLeton02.getInstance();	//懒汉式
						//Object c3=SingLeton03.getInstance();	//静态内部类
						//Object c4=SingLeton04.Instance;			//枚举式
					}
					countDownLatch.countDown();
				}
			}).start();
		}	
		//main方法阻塞，直到计数器为0，才会向下执行！
		countDownLatch.await();
		long end = System.currentTimeMillis();
		System.out.println("总耗时："+(end-start));
	}
}