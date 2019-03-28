package hs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * ���÷����API�� ��ȡ�����Ϣ(���ԣ���������������)
 * @author Administrator
 *
 */
public class TestUser2 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path="hs.reflection.User";
		try {
			Class clazz=Class.forName(path);
			//��ȡ����
//			Field[] fields=clazz.getFields();//ֻ�ܻ�ȡpublic���ε�����
			Field[] fields=clazz.getDeclaredFields();//��ȡ���е�field
			Field f=clazz.getDeclaredField("name"); //ָ���������ƻ�ȡ������
			System.out.println(f);
			for(Field temp:fields){
				System.out.println("��������"+temp);
			}
			System.out.println("----------------------");
			//��ȡ����
//			Method[] methods=clazz.getMethods();//ֻ�ܻ�ȡpublic���εķ���
			Method[] methods=clazz.getDeclaredMethods();//��ȡ���е�Method
			//��������в�,����봫�ݲ������Ͷ�Ӧ��Class����
			Method method=clazz.getDeclaredMethod("setName", String.class);
			for(Method temp:methods){
				System.out.println("���з���"+temp);
			}
			System.out.println("----------------------");
			//��ȡ������
//			Constructor[] constuctors=clazz.getConstructors();//ֻ�ܻ�ȡpublic���εĹ�����
			Constructor[] constuctors=clazz.getDeclaredConstructors();//��ȡ���е�constuctor
			//����������в�,����봫�ݲ������Ͷ�Ӧ��Class����
			Constructor constuctor=clazz.getDeclaredConstructor(String.class,int.class,int.class);
			for(Constructor temp:constuctors){
				System.out.println("���й�����"+temp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
