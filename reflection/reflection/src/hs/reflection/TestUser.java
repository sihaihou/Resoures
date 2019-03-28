package hs.reflection;
/**
 * ���Ը�������(Class interface enum type void ....)java.lang.class�����ȡ��ʽ
 * @author Administrator
 */
public class TestUser {
	public static void main(String[] args) {
		String path="hs.reflection.User";
		try {
			//�����ʾ���װһЩ���ݣ�һ���౻���غ�JVM�ᴴ��һ����Ӧ���Class������������ṹ��Ϣ��ŵ���Ӧ��Class������
			//���Class�������һ�澵��һ����ͨ�����澵�ӣ����ǿ��Կ�����Ӧ���ȫ����Ϣ��
			Class clazz=Class.forName(path);//�Ծ�
			System.out.println(clazz);
			System.out.println(clazz.hashCode());
			
			//һ����ֻ��Ӧһ��Class����
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
