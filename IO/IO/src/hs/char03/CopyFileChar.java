package hs.char03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 字符流 --纯文本拷贝
 * @author 侯四海
 */
public class CopyFileChar {
	public static void main(String[] args){
		//创建源    仅限于字符的 纯文本
		File src=new File("E:/test/05.java");
		File dest=new File("E:/test/06.java");
		try {	//选择流
			Reader rd =new FileReader(src);			
			Writer wt=new FileWriter(dest,false);
			char[] ch=new char[1024];
			int len=0;
			while(-1!=(len=rd.read(ch))){					
				wt.write(ch,0,len);					
			}
			wt.flush();				
			wt.close();
			rd.close();
			System.out.println("内容写出成功！");
		} catch (IOException e) {
			System.out.println("目标文件不存在");
			e.printStackTrace();
		}	
	}
}
