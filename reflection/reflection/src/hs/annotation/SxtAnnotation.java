package hs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SxtAnnotation {
	public static void main(String[] args) {
		String path="hs.annotation.Student";
		try {
			Class<?> clazz=Class.forName(path);
			//������������Чע��
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation temp:annotations){
				System.out.println(temp);
			}
			//���ݲ�����������ָ����ע��
			SxtTable st=clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			//���ݲ��������������Ե�ע��		
			Field[] fs =clazz.getDeclaredFields();			
			for(Field field :fs){
					SxtField sf =field.getAnnotation(SxtField.class);
					System.out.println(sf);
			}	
			/*Field field=clazz.getDeclaredField("name");
			SxtField sf=field.getAnnotation(SxtField.class);
			System.out.println(sf);*/
			
			
			//���ݻ�õı������ֶε���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����Sql�����ݿ���������صı�
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
