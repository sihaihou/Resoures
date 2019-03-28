package hs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * ͨ������API�����������
 * @author Administrator
 */
public class TestUser3 {
	public static void main(String[] args) throws Exception {
		String path="hs.reflection.User";
		try {
			Class<User> clazz=(Class<User>) Class.forName(path);
			//ͨ������API���ù��췽�����������
			User u=clazz.newInstance();//������User���޲ι��췽��
			Constructor<User> c=clazz.getDeclaredConstructor(String.class,int.class,int.class);
			//c.setAccessible(true);
			User u2=c.newInstance("��俶�",1505110307,18);
			System.out.println(u2.getName());
			
			//ͨ������API������ͨ����
			User u3=clazz.newInstance();
			Method method=clazz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "�����");  //u3.setName("�����");
			System.out.println(u3.getName());
			
			//ͨ������API�������ԣ�
			User u4=clazz.newInstance();
			Field field=clazz.getDeclaredField("name");
			field.setAccessible(true);//������Բ���Ҫ��ȫ����ˣ�����ֱ�ӷ���
			field.set(u4, "�����");
			System.out.println(u4.getName());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	