package hs.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import hs.reflection.User;
/**
 * ��ȡָ����������������Ϣ
 * ��ȡָ����������ֵ������Ϣ
 * @author ���ĺ�
 */
public class Demo {
	public void test01(Map<String,User> map,List<User>list){
		System.out.println("Demo.test01()");
	}
	public Map<Integer,User> test02(){
		System.out.println("Demo.test02()");
		return null;
	}
	public static void main(String[] args) {
		try {
			//��ȡָ����������������Ϣ
			Method m=Demo.class.getMethod("test01", Map.class,List.class);
			Type[] t=m.getGenericParameterTypes();
			for(Type paramType:t){
				System.out.println("========="+paramType);
				if(paramType instanceof ParameterizedType){
					Type[] genericTypes=((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType :genericTypes){
						System.out.println("��������"+genericType);
					}
				}
			}
			System.out.println("------------------------------------");
			//��ȡָ����������ֵ������Ϣ
			Method m2=Demo.class.getMethod("test02", null);
			Type returnType=m2.getGenericReturnType();
			if(returnType instanceof ParameterizedType){
				Type[] genericTypes=((ParameterizedType) returnType).getActualTypeArguments();
				for(Type genericType :genericTypes){
					System.out.println("����ֵ����������"+genericType);
				}
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
