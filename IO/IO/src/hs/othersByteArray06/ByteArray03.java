package hs.othersByteArray06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * 实现拷贝：
 * 文件     —程序—>  字节数组
 * 	  1,文件输入流
 *      字节数组输出流
 * 字节数组       —程序—>  文件    
 *    2，字节数组输入流
 *      文件输出流
 * @author 侯四海
 */
public class ByteArray03 {
	/**
	 * 文件     —程序—>  字节数组
	 * @param srcpath
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] test(String srcpath) throws IOException{
		//创建源文件
		File file =new File(srcpath);
		//创建字节数组目的地
		byte[] dest=null;
		//选择流  
		//文件输出流
		InputStream is=new BufferedInputStream(new FileInputStream(file));
		//字节数组输出流——不能使用多态
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//操作  不断读取文件  写出到字节数组流中
		byte[] src=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(src))){
			//写出到字节数组流中
			bos.write(src, 0, len);			
		}
		bos.flush();
		//获取数据
		dest=bos.toByteArray();
//		System.out.println(bos.toString());//打印			
		bos.close();
		is.close();
		return dest;
	}
	/**
	 * 字节数组       —程序—>  文件    
	 * @param src
	 * @param destpath
	 * @throws IOException
	 */
	public static void test2(byte[] src,String destpath) throws IOException{
		//目的地
		File dest =new File(destpath);
		//选择流
		//字节数组输入流
		InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os=new BufferedOutputStream(new FileOutputStream(dest));
		//操作  
		//不断读取字节数组     写入到文件中
		byte[] buffer=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(buffer))){
			// 写入到文件中
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();		
	}
	
	public static void main(String[] args) throws IOException {
		//传值三种方法
		String srcpath="E:/test/09.java";
		test(srcpath);
//		test("E:/test/test1.java");
				
		String destpath="E:/test/10.java";
		byte[] date=test(srcpath);
		
		test2(date,destpath);
	}
}
