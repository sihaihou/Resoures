package hs.singLeton;
/**
 * ͨ����̬�ڲ���ʵ�օg��ģʽ
 * ���ַ������̰߳�ȫ������Ч�ʸߣ�����ʵ������ʱ����
 * @author Administrator
 */
public class SingLeton03 {	
	/**
	 * ֻ�е���getInstance()����ʱ�������Żᱻ����
	 * @author Administrator
	 *
	 */
	private static class Test03SingLetonInstance{
		private static final SingLeton03 INSTANCE=new SingLeton03();
	} 	
	private SingLeton03() {
		
	}	
	/**
	 * ����û��ͬ����Ч�ʸߣ�
	 * @return
	 */
	public static SingLeton03 getInstance(){
		return Test03SingLetonInstance.INSTANCE;	
	}	
}
