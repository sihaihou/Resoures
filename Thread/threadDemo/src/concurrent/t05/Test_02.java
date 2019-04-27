package concurrent.t05;

/**
 * 内部类实现单例
 * 		不使用锁、也实现了懒加载(懒汉式)、
 */
public class Test_02 {

	private Test_02(){}
	
	private static class Inner{
		private static Test_02 t = new Test_02();
	}
	
	public static Test_02 getInstance(){
		return Inner.t;
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Test_02 t1 = new Test_02();
					System.out.println(Thread.currentThread().getName()+"-------"+t1.getInstance());
				}
			}).start();
		}
	}
}
