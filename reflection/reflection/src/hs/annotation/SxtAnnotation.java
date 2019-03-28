package hs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SxtAnnotation {
	public static void main(String[] args) {
		String path="hs.annotation.Student";
		try {
			Class<?> clazz=Class.forName(path);
			//获得类的所有有效注解
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation temp:annotations){
				System.out.println(temp);
			}
			//根据参数，获得类的指定的注解
			SxtTable st=clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			//根据参数，获得类的属性的注解		
			Field[] fs =clazz.getDeclaredFields();			
			for(Field field :fs){
					SxtField sf =field.getAnnotation(SxtField.class);
					System.out.println(sf);
			}	
			/*Field field=clazz.getDeclaredField("name");
			SxtField sf=field.getAnnotation(SxtField.class);
			System.out.println(sf);*/
			
			
			//根据获得的表名，字段的信息，拼出DDL语句，然后，使用JDBC执行这个Sql在数据库中生成相关的表。
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
