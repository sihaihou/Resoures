package hs.test01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * 动态编程
 * 		创建文件
 * 		创建临时文件
 * @author Administrator
 *
 */
public class File3 {
		public static void test() throws IOException, InterruptedException {
			 String src=("E:/test/04.txt");
				File file = new File(src);
				//如果不存在，创建新文件
				if(!file.exists()){
					boolean a = file.createNewFile();			
					System.out.println(a?"创建成功":"创建失败");
				}
				boolean b=file.delete();
				System.out.println(b?"删除成功":"删除失败");				
				//创建临时文件
				File temp = File.createTempFile("001", ".txt", new File("E:/test"));	
				System.out.println("创建临时文件成功！");
				Thread.sleep(5000);			
				temp.deleteOnExit();
				System.out.println("创建临时已删除！");				
		}
		public static void main(String[] args) throws IOException, InterruptedException  {
			test();
		}
}
