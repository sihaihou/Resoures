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
 * ������---�ַ�������
 * �ַ�������+��������(���ܷ�����̬)    
 * @author Administrator
 */
public class Bufferedchar {
	public static void main(String[] args){
		//����Դ    �������ַ��� ���ı�
		File src=new File("E:/test/05.java");
		File dest=new File("E:/test/06.java");
		try {	
			//ѡ����
			BufferedReader rd =new BufferedReader(new FileReader(src));			
			BufferedWriter wt=new BufferedWriter(new FileWriter(dest,false));
			/*char[] ch=new char[1024];
			int len=0;
			while(-1!=(len=rd.read(ch))){					
				wt.write(ch,0,len);					
			}*/
			//����������������  һ��һ�еĶ�ȡ����
			String line =null;
			while(null!=(line=rd.readLine())){
				wt.write(line);
				wt.newLine();  //����
			}
			wt.flush();				
			wt.close();
			rd.close();
		} catch (IOException e) {
			System.out.println("Ŀ���ļ�������");
			e.printStackTrace();
		}
	}
}
