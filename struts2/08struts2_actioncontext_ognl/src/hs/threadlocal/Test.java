package hs.threadlocal;

public class Test {
	public static void main(String[] args) {
		//ThreadLocal ����ֲ߳̾�������������
		//����� ThreadLocal�еľֲ��������̰߳�ȫ�ġ�
		final ThreadLocal threadlocal = new ThreadLocal();
		threadlocal.set("����");
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Thread��"+threadlocal.get());				
			}			
		}).start();;
		System.out.println(threadlocal.get());
	}
}
