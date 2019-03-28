package hs.javassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;
/**
 * ����ʹ��javassist����һ���µ���
 * @author Administrator
 */
public class Javassist {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("hs.javassist.Emp");
		//��������
		CtField f = CtField.make("private String name;", cc);
		CtField f1 = CtField.make("private int age;", cc);
		cc.addField(f);
		cc.addField(f1);
		//����������
		CtConstructor c = new CtConstructor(null, cc);
		CtConstructor c1 = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
		c1.setBody("{this.name=name;this.age=age;}");
		cc.addConstructor(c);
		cc.addConstructor(c1);
		//������ͨ����
		CtMethod m1 = CtMethod.make("public void setName(String name){this.name=name;}", cc);
		CtMethod m2 = CtMethod.make("public String getName(String name){return name;}", cc);
		CtMethod m3 = CtMethod.make("public void setAge(int age){this.age=age;}", cc);
		CtMethod m4 = CtMethod.make("public int getAge(int age){return age;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		cc.addMethod(m3);
		cc.addMethod(m4);
		//���������д������Ŀ¼��
		cc.writeFile("E:/test/02");
	}
}
