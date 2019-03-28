package hs.byte02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * 读取文件
 * 1，建立联系  创建File对象
 * 2，选择流
 *   1）InputStream
 *   2)FileInputStream
 * 3,操作：数组大小+read
 * 4,释放资源
 * @author Administrator
 */
public class File01 {
	public static void main(String[] args) {
		//1，建立联系  创建File对象
		File file=new File("E:/test/01.java");
		//2，选择流
		InputStream is=null;  //作用域提升
		try {
			is=new FileInputStream(file);
			//3，操作不断读取，缓冲数组
			byte[] car=new byte[1024];
			int len;  //接收实际读取大小
			try {//循环读取
				while(-1!=(len=is.read(car))){
					//输出，字节数组转字符串
					String info=new String(car,0,len);
					System.out.println(info);
				}
			} catch (IOException e) {
				System.out.println("文件读取失败");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
			//4,释放资源
		}finally{
			if(null!=is){
				try {
					is.close();
				} catch (IOException e) {
					System.out.println("文件释放失败");
					e.printStackTrace();
				}
			}
		}		
	}
}
