package hs.test01;

import java.io.File;
import java.io.FilenameFilter;
/**
 * mkdir()创建目录，保证父目录存在，否则文件创建失败！
 * mkdirs(); //创建目录，如果父目录不存在，目录链一同创建！
 * list()。。。子目录|文件  名
 * listFiles()。。。子目录|文件 File对象 
 * @author Administrator
 *
 */
public class File4 {
		public static void main(String[] args) {
			String path = "E:/test/";
			File file=new File(path);
//			file.mkdir(); //创建目录，保证父目录存在，否则创建失败！
			file.mkdirs(); //创建目录，如果父目录不存在，目录链一同创建！
			if(file.isDirectory()){
				System.out.println("=====子目录|文件 名=====");
				String[] subName=file.list(); //目录名
				for(String temp:subName){
					System.out.println(temp);
				}
				System.out.println("=====子目录|文件 File对象=====");
				File[] subFiles=file.listFiles();
				for(File temp:subFiles){
					if(!file.isFile()){
						System.out.println(temp.getAbsolutePath());
					}					
				}
				System.out.println("=====子目录|文件 .txt对象=====");
				//过滤器
			    subFiles=file.listFiles(new FilenameFilter(){
					@Override//dir代表file
					public boolean accept(File dir, String name) {
						//后缀为 .txt的文件过滤出来
						return new File(dir,name).isFile()&&name.endsWith(".txt");
					}			    	
			    });
				for(File temp:subFiles){
					System.out.println(temp.getAbsolutePath());
				}
			}
		}
}		
