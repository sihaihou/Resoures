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
 * 序列化与反序列化
 * java.io.NotSerializableException不是所有对象都可以序列化
 * @author Administrator
 */
public class StudentApp {
	//序列化	 ----数据输出到文件
	public static void write(File src) throws FileNotFoundException, IOException{
		Student s=new Student("姓名:housihai","学号:1505110307",94.0,82.0,56.0);		
		ObjectOutputStream oos=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(src)
						));
		oos.writeObject(s);	
		oos.flush();
		oos.close();	
	}
	//反序列化	----从文件读取数据
	public static void read(File src) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)));
		Object obj=ois.readObject();   //Object对象接收
		if(obj instanceof Student){
			Student s=(Student)obj;
			System.out.println("name:"+s.getName());
			System.out.println("Id："+s.getId());
			System.out.println("不需要序列化Match："+s.getMatch());
			System.out.println("Chinese："+s.getChinese());
			System.out.println("English："+s.getEnglish());
		}
		CloseUtil.closeall(ois);//自定义实现的 CloseUtil关闭接口
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		File src=new File("E:/test/05.txt");
		write(src);
		read(src);
	}
}
