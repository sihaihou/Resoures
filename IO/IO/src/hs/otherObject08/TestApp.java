package hs.otherObject08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * 序列化与反序列化
 * 		数组
 * @author Administrator
 *
 */
public class TestApp {
		public static void write(String destpath) throws IOException{
			//对象包装进去
			Test t=new Test("housihai",12000);
			int[] arr={1,9,4,7,6,2,5,8};
			File dest=new File(destpath);
			//选择流
			ObjectOutputStream oos=new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)
							)
					);		
			//操作           写出的顺序  为读取作准备
			oos.writeObject(t);
			oos.writeObject(arr);
			oos.flush();		
			oos.close();
		}
		public static void read(String destpath) throws IOException, ClassNotFoundException{
			//创建源
			File src=new File(destpath);
			//选择流
			ObjectInputStream ois=new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(src)
							)
					);
			//操作  读取的顺序与写出顺序一致    必须存在才能读取   
			//不一致  数据存在问题
			Object obj=ois.readObject();
			if(obj instanceof Test){
				Test t=(Test)obj;
				System.out.println(t.getName());
				System.out.println(t.getSalary());
			}
			obj=ois.readObject();
			int[] arr=(int[])obj;
			System.out.println(Arrays.toString(arr));
			ois.close();
		}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String destpath="E:test/XuLieHua.txt";
		write(destpath);
//		read(destpath);
		read("E:test/XuLieHua.txt");
	}
}
