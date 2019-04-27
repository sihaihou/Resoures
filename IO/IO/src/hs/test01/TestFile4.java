package hs.test01;

import java.io.File;
import java.io.FilenameFilter;

public class TestFile4 {
		public static void main(String[] args) {
			String path="E:/test";
			File file =new File(path);
			System.out.println("====���ļ�|Ŀ¼  ��=====");	
			//list()  ���ص���һ���ַ�������
			String[] subname=file.list();
			if(file.isDirectory()){
				for(String temp:subname){
					System.out.println(temp); 
				}
			}	
			
			System.out.println("====���ļ�|Ŀ¼ File����=====");	
			File[]	subfile=file.listFiles();
			for(File temp:subfile){
				System.out.println(temp.getAbsolutePath());
			}
			
			System.out.println("====���ļ�|Ŀ¼.java����=====");	
			subfile=file.listFiles(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					return new File(dir,name).isFile()&&name.endsWith(".java");
				}
				
			});
			for(File temp:subfile){
				System.out.println(temp.getAbsolutePath());
			}
		}
}
