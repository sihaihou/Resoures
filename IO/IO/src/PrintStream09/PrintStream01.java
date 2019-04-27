package PrintStream09;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * PrintStream 打印流 。。。>处理流
 * 快速输出到文件
 * @author Administrator
 *
 */
public class PrintStream01 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("打印到控制台：so easy!");
		PrintStream ps=System.out;
		ps.println("打印到控制台：io is so easy!");
		
		File file=new File("E:/test/02.txt");
		ps =new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
		ps.println("Io is so easy!");
		ps.flush();
		ps.close();
		System.out.println("打印到文件成功！");
	}
}
