package hs.reflection;
/**
 * 测试各种类型(Class interface enum type void ....)java.lang.class对象获取方式
 * @author Administrator
 */
public class TestUser {
	public static void main(String[] args) {
		String path="hs.reflection.User";
		try {
			//对象表示或封装一些数据，一个类被加载后，JVM会创建一个对应类的Class对象，类的整个结构信息会放到对应的Class对象中
			//这个Class对象就像一面镜子一样，通过这面镜子，我们可以看到对应类的全部信息！
			Class clazz=Class.forName(path);//对就
			System.out.println(clazz);
			System.out.println(clazz.hashCode());
			
			//一个类只对应一个Class对象
			Class strclazz=String.class;
			Class pathclazz=path.getClass();
			System.out.println(strclazz);
			System.out.println(pathclazz);
			System.out.println(clazz==strclazz);
			System.out.println(pathclazz==strclazz);
			System.out.println("---------------------------");
			int[] arr1=new int[10];
			int[] arr2=new int[20];
			int[][] arr3=new int[20][10];
			System.out.println(arr1.getClass().hashCode());
			System.out.println(arr2.getClass().hashCode());
			System.out.println(arr3.getClass().hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
