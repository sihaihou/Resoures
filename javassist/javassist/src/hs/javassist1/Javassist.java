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
 * ����javassist��API
 * @author Administrator
 */
public class Javassist {
	/**
	 * ������Ļ����÷�
	 * @throws CannotCompileException 
	 * @throws IOException 
	 */
	public static void Clazz() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println("������"+cc.getName()+"\n��Ҫ������"+cc.getSimpleName()+
				"\n���ࣺ"+cc.getSuperclass()+"\n�ӿڣ�"+cc.getInterfaces());		
	}
	/**
	 *  �������Ļ����÷�
	 *	 $ ռλ�� �൱��this
	 * @throws Exception
	 */
	public static void method() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		//��������
		//CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);
		CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.print(\"���ǣ�\");return $1+$2;}");
		cc.addMethod(m);
		
		//ͨ��������������ɵķ���
		Class clazz = cc.toClass();
		//�����޲ι�����
		Object obj = clazz.newInstance();
		Method method =  clazz.getDeclaredMethod("add", int.class,int.class);
		Object result =method.invoke(obj, 15,21);
		System.out.println(result);
	}
	/**
	 * �޸ķ�������Ϣ���޸ķ����������
	 * @param args
	 * @throws Exception 
	 * @throws Exception
	 */
	public static void updateMethod() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		CtMethod m = cc.getDeclaredMethod("say",new CtClass[]{CtClass.intType});
		//�����sayǰ
		m.insertBefore("System.out.println($1);System.out.println(\"start...\");");
		//�����say��
		m.insertAfter("System.out.println(\"end...\");");
		//���ڵڼ���ǰ
		m.insertAt(13, "int b=4;System.out.println(\"b=\"+b);");
		//ͨ��������������ɵķ���
		Class clazz = cc.toClass();
		//�����޲ι�����
		Object obj = clazz.newInstance();
		Method method =  clazz.getDeclaredMethod("say", int.class);
		Object result =method.invoke(obj, 15);
		System.out.println(result);
	}
	/**
	 * ���ԵĻ����÷�
	 */
	public static void field() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("hs.javassist1.Emp");
		//��������
		//CtField f = CtField.make("private int age;", cc);
		CtField f =  new CtField(CtClass.intType,"salary", cc);
		f.setModifiers(Modifier.PRIVATE);
		cc.addField(f);
		//��ȡָ��������
		//cc.getDeclaredField("age");
		//������Ӧ��set��get����
		cc.addMethod(CtNewMethod.getter("getSalary", f));
		cc.addMethod(CtNewMethod.getter("setSalary", f));
	}
	/**
	 * �������Ļ����÷�
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
	 * ע��Ļ�ȡ
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
