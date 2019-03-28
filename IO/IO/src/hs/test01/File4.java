package hs.test01;

import java.io.File;
import java.io.FilenameFilter;
/**
 * mkdir()����Ŀ¼����֤��Ŀ¼���ڣ������ļ�����ʧ�ܣ�
 * mkdirs(); //����Ŀ¼�������Ŀ¼�����ڣ�Ŀ¼��һͬ������
 * list()��������Ŀ¼|�ļ�  ��
 * listFiles()��������Ŀ¼|�ļ� File���� 
 * @author Administrator
 *
 */
public class File4 {
		public static void main(String[] args) {
			String path = "E:/test/";
			File file=new File(path);
//			file.mkdir(); //����Ŀ¼����֤��Ŀ¼���ڣ����򴴽�ʧ�ܣ�
			file.mkdirs(); //����Ŀ¼�������Ŀ¼�����ڣ�Ŀ¼��һͬ������
			if(file.isDirectory()){
				System.out.println("=====��Ŀ¼|�ļ� ��=====");
				String[] subName=file.list(); //Ŀ¼��
				for(String temp:subName){
					System.out.println(temp);
				}
				System.out.println("=====��Ŀ¼|�ļ� File����=====");
				File[] subFiles=file.listFiles();
				for(File temp:subFiles){
					if(!file.isFile()){
						System.out.println(temp.getAbsolutePath());
					}					
				}
				System.out.println("=====��Ŀ¼|�ļ� .txt����=====");
				//������
			    subFiles=file.listFiles(new FilenameFilter(){
					@Override//dir����file
					public boolean accept(File dir, String name) {
						//��׺Ϊ .txt���ļ����˳���
						return new File(dir,name).isFile()&&name.endsWith(".txt");
					}			    	
			    });
				for(File temp:subFiles){
					System.out.println(temp.getAbsolutePath());
				}
			}
		}
}		
