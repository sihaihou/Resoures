package hs.test01;

import java.io.File;
import java.io.FilenameFilter;

public class TestFile4 {
		public static void main(String[] args) {
			String path="E:/test";
			File file =new File(path);
			System.out.println("====子文件|目录  名=====");	
			//list()  返回的是一个字符串对象
			String[] subname=file.list();
			if(file.isDirectory()){
				for(String temp:subname){
					System.out.println(temp); 
				}
			}	
			
			System.out.println("====子文件|目录 File对象=====");	
			File[]	subfile=file.listFiles();
			for(File temp:subfile){
				System.out.println(temp.getAbsolutePath());
			}
			
			System.out.println("====子文件|目录.java对象=====");	
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
