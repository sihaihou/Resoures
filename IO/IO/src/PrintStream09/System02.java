package PrintStream09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * 三个常量：
 *	System.in  输入流  键盘输入
 *  System.out 输出流  控制台输出
 *  System.err
 * 重定向：
 *	 setIn()
 *	 setOut()
 *	 setErr()
 *	 FileDescriptor.in   输入
 *	 FileDescriptor.out  输出
 * System.in 文件内容输入到控制台   —— 打印入
 * setOut 控制台内容输出到文件  ——打印出
 * @author 侯四海
 */
public class System02 {
	public static void main(String[] args) throws FileNotFoundException {
		String srcpath="E:/test/02.txt";	
		//test(srcpath);	
		String str="输入内容 :控制台————>文件-----文件————>控制台";
		test2(str);
	}
	/**
	 * 读取文件输入到控制台   —— 打印入
	 * @param srcpath
	 * @throws FileNotFoundException
	 */
	public static void test(String srcpath) throws FileNotFoundException{
		InputStream is=System.in;
	    is=new BufferedInputStream(new FileInputStream(srcpath));
	    //Scanner scanner=new Scanner(System.in);
		Scanner scanner=new Scanner(is);
		//文件————控制台
		System.out.println(scanner.nextLine());
	}
	/**
	 * 控制台内容输出到文件 <——>打印出
	 * @param str
	 * @throws FileNotFoundException
	 */
	public static void test2(String str) throws FileNotFoundException{
		//重定向
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("E:/test/03.txt")),true));
		//控制台————>文件
		System.out.println(str);	
		
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream( FileDescriptor.out)),true));
		//文件————控制台
		System.out.println(str);    	
	}	
}
