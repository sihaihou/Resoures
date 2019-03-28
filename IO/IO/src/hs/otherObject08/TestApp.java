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
 * ���л��뷴���л�
 * 		����
 * @author Administrator
 *
 */
public class TestApp {
		public static void write(String destpath) throws IOException{
			//�����װ��ȥ
			Test t=new Test("housihai",12000);
			int[] arr={1,9,4,7,6,2,5,8};
			File dest=new File(destpath);
			//ѡ����
			ObjectOutputStream oos=new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)
							)
					);		
			//����           д����˳��  Ϊ��ȡ��׼��
			oos.writeObject(t);
			oos.writeObject(arr);
			oos.flush();		
			oos.close();
		}
		public static void read(String destpath) throws IOException, ClassNotFoundException{
			//����Դ
			File src=new File(destpath);
			//ѡ����
			ObjectInputStream ois=new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(src)
							)
					);
			//����  ��ȡ��˳����д��˳��һ��    ������ڲ��ܶ�ȡ   
			//��һ��  ���ݴ�������
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
