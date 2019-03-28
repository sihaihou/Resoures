package hs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 通过反射API访问类的属性
 * @author Administrator
 */
public class TestUser3 {
	public static void main(String[] args) throws Exception {
		String path="hs.reflection.User";
		try {
			Class<User> clazz=(Class<User>) Class.forName(path);
			//通过反射API调用构造方法，构造对象
			User u=clazz.newInstance();//调用了User的无参构造方法
			Constructor<User> c=clazz.getDeclaredConstructor(String.class,int.class,int.class);
			//c.setAccessible(true);
			User u2=c.newInstance("高淇二",1505110307,18);
			System.out.println(u2.getName());
			
			//通过反射API调用普通方法
			User u3=clazz.newInstance();
			Method method=clazz.getDeclaredMethod("setName", String.class);
			method.invoke(u3, "高淇三");  //u3.setName("高淇三");
			System.out.println(u3.getName());
			
			//通过反射API操作属性，
			User u4=clazz.newInstance();
			Field field=clazz.getDeclaredField("name");
			field.setAccessible(true);//这个属性不需要安全检查了，可以直接访问
			field.set(u4, "高淇四");
			System.out.println(u4.getName());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	