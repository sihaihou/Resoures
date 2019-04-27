package hs.byte02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �����ļ�
 * @author ���ĺ�
 */
public class CopyFilebyte03_test {
	/**
	 * ͨ������File���󿽱�
	 * @param src  Դ�ļ�
	 * @param dest Ŀ�ĵ�
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
	 * ͨ������·������
	 * @param srcpath   Դ�ļ�·��
	 * @param destpath	Ŀ�ĵ�·��
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
			System.out.println("�ļ������ɹ���");
		} catch (IOException e) {
			System.out.println("�ļ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
