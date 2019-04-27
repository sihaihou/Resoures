package hs.test01;

import java.io.File;
/**
 * 两个常量：
 *   路基分隔符：    ;
 *   名称分隔符：   Win /   非Win  \
 * @author hsh 
 */
public class File1 {	
		/**
		 * 三种路径变形形式
		 * @param args
		 */
		public static void main(String[] args) {
			//第一种
			String path ="E:\\test\\01.txt";
			//第二种
			path="E:"+java.io.File.separator+"test"+java.io.File.separator+"01.txt";
			//第三种：推荐形式
			path="E:/test/01.txt";
			System.out.println("++++++++++++++++++");	
			String parentpath="E:/test";
			String name="01.txt";
			//相对路径
			File file=new File(parentpath);
			file= new File(new File(parentpath),name);
			System.out.println(file.getName());	
			System.out.println(file.getPath());	
			//绝对路径
			file=new File("E:/test/01.txt");
			System.out.println(file.getName());	
			System.out.println(file.getPath());	
			System.out.println("===================");
			//没有盘符       以user.dir构建(当前项目)
		    file=new File("01.txt");
		    System.out.println(file.getName());	
			System.out.println(file.getPath());	
			System.out.println(file.getAbsolutePath());
		}
}
