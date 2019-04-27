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
 * ʵ�ֿ�����
 * �ļ�     ������>  �ֽ�����
 * 	  1,�ļ�������
 *      �ֽ����������
 * �ֽ�����       ������>  �ļ�    
 *    2���ֽ�����������
 *      �ļ������
 * @author ���ĺ�
 */
public class ByteArray03 {
	/**
	 * �ļ�     ������>  �ֽ�����
	 * @param srcpath
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] test(String srcpath) throws IOException{
		//����Դ�ļ�
		File file =new File(srcpath);
		//�����ֽ�����Ŀ�ĵ�
		byte[] dest=null;
		//ѡ����  
		//�ļ������
		InputStream is=new BufferedInputStream(new FileInputStream(file));
		//�ֽ������������������ʹ�ö�̬
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//����  ���϶�ȡ�ļ�  д�����ֽ���������
		byte[] src=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(src))){
			//д�����ֽ���������
			bos.write(src, 0, len);			
		}
		bos.flush();
		//��ȡ����
		dest=bos.toByteArray();
//		System.out.println(bos.toString());//��ӡ			
		bos.close();
		is.close();
		return dest;
	}
	/**
	 * �ֽ�����       ������>  �ļ�    
	 * @param src
	 * @param destpath
	 * @throws IOException
	 */
	public static void test2(byte[] src,String destpath) throws IOException{
		//Ŀ�ĵ�
		File dest =new File(destpath);
		//ѡ����
		//�ֽ�����������
		InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os=new BufferedOutputStream(new FileOutputStream(dest));
		//����  
		//���϶�ȡ�ֽ�����     д�뵽�ļ���
		byte[] buffer=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(buffer))){
			// д�뵽�ļ���
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();		
	}
	
	public static void main(String[] args) throws IOException {
		//��ֵ���ַ���
		String srcpath="E:/test/09.java";
		test(srcpath);
//		test("E:/test/test1.java");
				
		String destpath="E:/test/10.java";
		byte[] date=test(srcpath);
		
		test2(date,destpath);
	}
}
