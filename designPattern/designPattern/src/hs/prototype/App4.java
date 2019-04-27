package hs.prototype;
/**
 * ����new��ʽ���������clone�������������Ч�ʲ��죻
 * �����Ҫ��ʱ�䴴����������,����new�����ȽϺ�ʱ�����Կ���ʹ��ԭ��ģʽ
 * @author Administrator
 *
 */
public class App4 {
	public static void testNew(int size){
		long start =System.currentTimeMillis();
		for(int i=0;i<size;i++){
			laptop t=new laptop();
		}
		long end =System.currentTimeMillis();
		System.out.println("New�ķ�ʽ���������ʱ"+(end-start));
	}
	public static void testclone(int size) throws CloneNotSupportedException{
		long start =System.currentTimeMillis();
		laptop t=new laptop();
		for(int i=0;i<size;i++){
			laptop temp=(laptop) t.clone();
		}
		long end =System.currentTimeMillis();
		System.out.println("clone�ķ�ʽ���������ʱ"+(end-start));
	}
	
	public static void main(String[] args) throws Exception {	
		testNew(1000);
		testclone(1000);
	}
}



class laptop implements Cloneable{
	public laptop()  {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();   //ֱ�ӵ���Object�����clone()����
		return obj;
	}
}