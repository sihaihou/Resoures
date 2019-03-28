package hs.buffered04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 处理流---字符缓冲流
 * 字符缓冲流+新增方法(不能发生多态)    
 * @author Administrator
 */
public class Bufferedchar {
	public static void main(String[] args){
		//创建源    仅限于字符的 纯文本
		File src=new File("E:/test/05.java");
		File dest=new File("E:/test/06.java");
		try {	
			//选择流
			BufferedReader rd =new BufferedReader(new FileReader(src));			
			BufferedWriter wt=new BufferedWriter(new FileWriter(dest,false));
			/*char[] ch=new char[1024];
			int len=0;
			while(-1!=(len=rd.read(ch))){					
				wt.write(ch,0,len);					
			}*/
			//新增方法————  一行一行的读取拷贝
			String line =null;
			while(null!=(line=rd.readLine())){
				wt.write(line);
				wt.newLine();  //换行
			}
			wt.flush();				
			wt.close();
			rd.close();
		} catch (IOException e) {
			System.out.println("目标文件不存在");
			e.printStackTrace();
		}
	}
}
