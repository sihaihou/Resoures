package hs.javassist1;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
/**
 * 测试javassist的API
 * @author Administrator
 */
public class Javassist {
	/**
	 * 处理类的基本用法
	 * @throws CannotCompileException 
	 * @throws IOException 
	 */
	public static void Clazz() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println("类名："+cc.getName()+"\n简要类名："+cc.getSimpleName()+
				"\n父类："+cc.getSuperclass()+"\n接口："+cc.getInterfaces());		
	}
	/**
	 *  处理方法的基本用法
	 *	 $ 占位符 相当于this
	 * @throws Exception
	 */
	public static void method() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		//创建方法
		//CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
		CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.print(\"和是：\");return $1+$2;}");
		cc.addMethod(m);
		
		//通过反射调用新生成的方法
		Class clazz = cc.toClass();
		//调用无参构造器
		Object obj = clazz.newInstance();
		Method method =  clazz.getDeclaredMethod("add", int.class,int.class);
		Object result =method.invoke(obj, 15,21);
		System.out.println(result);
	}
	/**
	 * 修改方法的信息，修改方法体的内容
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
	public static void updateMethod() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		CtMethod m = cc.getDeclaredMethod("say",new CtClass[]{CtClass.intType});
		//添加在say前
		m.insertBefore("System.out.println($1);System.out.println(\"start...\");");
		//添加在say后
		m.insertAfter("System.out.println(\"end...\");");
		//加在第几行前
		m.insertAt(13, "int b=4;System.out.println(\"b=\"+b);");
		//通过反射调用新生成的方法
		Class clazz = cc.toClass();
		//调用无参构造器
		Object obj = clazz.newInstance();
		Method method =  clazz.getDeclaredMethod("say", int.class);
		Object result =method.invoke(obj, 15);
		System.out.println(result);
	}
	/**
	 * 属性的基本用法
	 */
	public static void field() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		//创建属性
		//CtField f = CtField.make("private int age;", cc);
		CtField f =  new CtField(CtClass.intType,"salary", cc);
		f.setModifiers(Modifier.PRIVATE);
		cc.addField(f);
		//获取指定的属性
		//cc.getDeclaredField("age");
		//增加相应的set、get方法
		cc.addMethod(CtNewMethod.getter("getSalary", f));
		cc.addMethod(CtNewMethod.getter("setSalary", f));
	}
	/**
	 * 构造器的基本用法
	 * @throws Exception
	 */
	public static void constructor() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		CtConstructor[] constructors = cc.getConstructors();
		for(CtConstructor constructor:constructors){
			System.out.println(constructor.getLongName());
		}
	}
	/**
	 * 注解的获取
	 * @throws Exception
	 */
	public static void annotation() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		Object[] all = cc.getAnnotations();
		Author  author= (Author)all[0];
		String name =author.name();
		int year = author.year();
		System.out.println("name:"+name+"\nyear:"+year);
	}
	
	
	public static void main(String[] args) throws Exception {
		//Clazz();
		//method();
		//updateMethod();
		//field();
		//constructor();
		annotation();
	}
}
