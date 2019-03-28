package hs.otherObject08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import hs.close.CloseUtil;
/**
 * ���л��뷴���л�
 * java.io.NotSerializableException�������ж��󶼿������л�
 * @author Administrator
 */
public class StudentApp {
	//���л�	 ----����������ļ�
	public static void write(File src) throws FileNotFoundException, IOException{
		Student s=new Student("����:housihai","ѧ��:1505110307",94.0,82.0,56.0);		
		ObjectOutputStream oos=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(src)
						));
		oos.writeObject(s);	
		oos.flush();
		oos.close();	
	}
	//�����л�	----���ļ���ȡ����
	public static void read(File src) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		Object obj=ois.readObject();   //Object�������
		if(obj instanceof Student){
			Student s=(Student)obj;
			System.out.println("name:"+s.getName());
			System.out.println("Id��"+s.getId());
			System.out.println("����Ҫ���л�Match��"+s.getMatch());
			System.out.println("Chinese��"+s.getChinese());
			System.out.println("English��"+s.getEnglish());
		}
		CloseUtil.closeall(ois);//�Զ���ʵ�ֵ� CloseUtil�رսӿ�
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File src=new File("E:/test/05.txt");
		write(src);
		read(src);
	}
}
