package hs.prototype;
/**
 * 测试new方式创建对象和clone方法创建对象的效率差异；
 * 如果需要短时间创建大量对象,并且new方法比较耗时，可以考试使用原型模式
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
		System.out.println("New的方式创建对象耗时"+(end-start));
	}
	public static void testclone(int size) throws CloneNotSupportedException{
		long start =System.currentTimeMillis();
		laptop t=new laptop();
		for(int i=0;i<size;i++){
			laptop temp=(laptop) t.clone();
		}
		long end =System.currentTimeMillis();
		System.out.println("clone的方式创建对象耗时"+(end-start));
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
		Object obj=super.clone();   //直接调用Object对象的clone()方法
		return obj;
	}
}