package hs.byte02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 拷贝文件
 * @author 侯四海
 */
public class CopyFilebyte03_test {
	/**
	 * 通过传递File对象拷贝
	 * @param src  源文件
	 * @param dest 目的地
	 * @throws IOException
	 */
	public static void copyFile(File src,File dest) throws IOException{
		 InputStream is=new FileInputStream(src);
		 OutputStream os=new FileOutputStream(dest,true);
		 byte[] buffer=new byte[1024];
		 int len=0;
		 while(-1!=(len=is.read(buffer))){	
			 os.write(buffer, 0, len);
		 }		
		 os.flush();					 
		 os.close();
		 is.close();
	}	
	/**
	 * 通过传递路径拷贝
	 * @param srcpath   源文件路径
	 * @param destpath	目的地路径
	 * @throws IOException
	 */
	public static void copyFile(String srcpath,String destpath) throws IOException{
		copyFile(new File(srcpath),new File(destpath));
	}
	
	public static void main(String[] args)  {
		 String srcpath="E:/test/02.java";
		 String destpath="E:/test/03.java";
//		 File src=new File("E:/test/02.java");
//		 File dest=new File("E:/test/03.java");
		 try {
			copyFile(srcpath,destpath);
			System.out.println("文件拷贝成功！");
		} catch (IOException e) {
			System.out.println("文件拷贝失败！");
			e.printStackTrace();
		}
	}
}
