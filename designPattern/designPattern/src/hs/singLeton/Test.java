package hs.singLeton;

import java.util.concurrent.CountDownLatch;
/**
 * ���Լ��օg�����ģʽ��Ч��
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
						Object c1=SingLeton01.getInstance();  //����ʽ
						//Object c2=SingLeton02.getInstance();	//����ʽ
						//Object c3=SingLeton03.getInstance();	//��̬�ڲ���
						//Object c4=SingLeton04.Instance;			//ö��ʽ
					}
					countDownLatch.countDown();
				}
			}).start();
		}	
		//main����������ֱ��������Ϊ0���Ż�����ִ�У�
		countDownLatch.await();
		long end = System.currentTimeMillis();
		System.out.println("�ܺ�ʱ��"+(end-start));
	}
}