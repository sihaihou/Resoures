package hs.char03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 字符流读取文件
 * 		只能读取存文本类型文件
 * @author 侯四海
 */
public class FileChar {
	public static void main(String[] args) {
		File src=new File("E:/test/04.java");
		Reader rd = null;
		try {
			 rd=new FileReader(src);
			 char[] buffer=new char[1024];
			 int len=0;
			 try {
				while(-1!=(len=rd.read(buffer))){
					 String str=new String(buffer,0,len);
					 System.out.println(str);					
				 }
			} catch (IOException e) {
				System.out.println("文件读取失败");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("源文件不存在");
			e.printStackTrace();
		}finally{
			if(null!=rd){
				try {
					rd.close();
				} catch (IOException e) {
					System.out.println("文件读取失败");
					e.printStackTrace();
				}
			}
		}
	}
}
