package hs.test01;

import java.io.File;

public class File2 {
	public static void test(){
		 File file=new File("E:/test/01.txt");
		 //�����ļ�����
		 System.out.println("�����ļ�����:"+file.getName());	
		 //����Ǿ���·������������·�������򷵻����·��
		 System.out.println("����Ǿ���·������������·�������򷵻����·��:"+file.getPath());	
		 //���ؾ���·��
		 System.out.println("���ؾ���·��:"+file.getAbsolutePath());
		 //������һ��Ŀ¼
		 System.out.println("������һ��Ŀ¼:"+file.getParent());   
	}
	public static void test2(){
		String path="E:/test/01.txt";
//		path="E:/test";
		File file= new File(path);
		System.out.println("�ж��ļ��Ƿ����:"+file.exists());//�ж��ļ��Ƿ����,���ڷ��� true������false
		System.out.println("�ж��ļ��Ƿ��д:"+file.canWrite());
		System.out.println("�ж��ļ��Ƿ�ɶ�:"+file.canRead());
		//isFile  �ж����ļ������ļ���
		if(file.isFile()){
			System.out.println("�ļ�");
		}else if(file.isDirectory()){   //����ļ�����ʵ���ڣ�Ĭ��Ϊ�ļ���
			System.out.println("�ļ���");
		}else{
			System.out.println("�ļ�������");
		}
		//���ļ��ŷ����ֽ��������ܶ�ȡ�ļ��г���
		System.out.println(file.length());
	}
	
	public static void main(String[] args) {
		test();
		test2();
	}
}
