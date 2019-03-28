package hs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 运用反射的API， 获取类的信息(属性，方法，构造器等)
 * @author Administrator
 *
 */
public class TestUser2 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path="hs.reflection.User";
		try {
			Class clazz=Class.forName(path);
			//获取属性
//			Field[] fields=clazz.getFields();//只能获取public修饰的属性
			Field[] fields=clazz.getDeclaredFields();//获取所有的field
			Field f=clazz.getDeclaredField("name"); //指定属性名称获取该属性
			System.out.println(f);
			for(Field temp:fields){
				System.out.println("所有属性"+temp);
			}
			System.out.println("----------------------");
			//获取方法
//			Method[] methods=clazz.getMethods();//只能获取public修饰的方法
			Method[] methods=clazz.getDeclaredMethods();//获取所有的Method
			//如果方法有参,则必须传递参数类型对应的Class对象
			Method method=clazz.getDeclaredMethod("setName", String.class);
			for(Method temp:methods){
				System.out.println("所有方法"+temp);
			}
			System.out.println("----------------------");
			//获取构造器
//			Constructor[] constuctors=clazz.getConstructors();//只能获取public修饰的构造器
			Constructor[] constuctors=clazz.getDeclaredConstructors();//获取所有的constuctor
			//如果构造器有参,则必须传递参数类型对应的Class对象
			Constructor constuctor=clazz.getDeclaredConstructor(String.class,int.class,int.class);
			for(Constructor temp:constuctors){
				System.out.println("所有构造器"+temp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
