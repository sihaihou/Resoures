package hs.char03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * �ַ��� --���ı�����
 * @author ���ĺ�
 */
public class CopyFileChar {
	public static void main(String[] args){
		//����Դ    �������ַ��� ���ı�
		File src=new File("E:/test/05.java");
		File dest=new File("E:/test/06.java");
		try {	//ѡ����
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
			System.out.println("����д���ɹ���");
		} catch (IOException e) {
			System.out.println("Ŀ���ļ�������");
			e.printStackTrace();
		}	
	}
}
