package hs.test01;

import java.io.File;
/**
 * ����������
 *   ·���ָ�����    ;
 *   ���Ʒָ�����   Win /   ��Win  \
 * @author hsh 
 */
public class File1 {	
		/**
		 * ����·��������ʽ
		 * @param args
		 */
		public static void main(String[] args) {
			//��һ��
			String path ="E:\\test\\01.txt";
			//�ڶ���
			path="E:"+java.io.File.separator+"test"+java.io.File.separator+"01.txt";
			//�����֣��Ƽ���ʽ
			path="E:/test/01.txt";
			System.out.println("++++++++++++++++++");	
			String parentpath="E:/test";
			String name="01.txt";
			//���·��
			File file=new File(parentpath);
			file= new File(new File(parentpath),name);
			System.out.println(file.getName());	
			System.out.println(file.getPath());	
			//����·��
			file=new File("E:/test/01.txt");
			System.out.println(file.getName());	
			System.out.println(file.getPath());	
			System.out.println("===================");
			//û���̷�       ��user.dir����(��ǰ��Ŀ)
		    file=new File("01.txt");
		    System.out.println(file.getName());	
			System.out.println(file.getPath());	
			System.out.println(file.getAbsolutePath());
		}
}
