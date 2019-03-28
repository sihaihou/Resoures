package hs.test01;

import java.io.File;

public class File2 {
	public static void test(){
		 File file=new File("E:/test/01.txt");
		 //返回文件名称
		 System.out.println("返回文件名称:"+file.getName());	
		 //如果是绝对路径，返回完整路径，否则返回相对路径
		 System.out.println("如果是绝对路径，返回完整路径，否则返回相对路径:"+file.getPath());	
		 //返回绝对路径
		 System.out.println("返回绝对路径:"+file.getAbsolutePath());
		 //返回上一级目录
		 System.out.println("返回上一级目录:"+file.getParent());   
	}
	public static void test2(){
		String path="E:/test/01.txt";
//		path="E:/test";
		File file= new File(path);
		System.out.println("判断文件是否存在:"+file.exists());//判断文件是否存在,存在返回 true；否则false
		System.out.println("判断文件是否可写:"+file.canWrite());
		System.out.println("判断文件是否可读:"+file.canRead());
		//isFile  判断是文件还是文件夹
		if(file.isFile()){
			System.out.println("文件");
		}else if(file.isDirectory()){   //如果文件不真实存在，默认为文件夹
			System.out.println("文件夹");
		}else{
			System.out.println("文件不存在");
		}
		//是文件才返回字节数，不能读取文件夹长度
		System.out.println(file.length());
	}
	
	public static void main(String[] args) {
		test();
		test2();
	}
}
