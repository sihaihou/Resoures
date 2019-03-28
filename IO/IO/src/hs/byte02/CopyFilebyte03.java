package hs.byte02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ļ��Ŀ���
 * 1��������ϵ   File����  Դͷ Ŀ�ĵ�
 * 2��ѡ����
 *    	�ļ�������	InputStream  FileInputStream
 *     	�ļ������    	OutputStream  FileOutputStream	
 * 3������: ����
 * 		byte[] flush=new byte[1024];
 *      int len=0;
 *      while(-1=(len=��������read(flush))){
 *      	����� write(flush,0,len)
 *      }
 *      �������flush��
 * 4���ͷ���Դ���ر�������     
 */

public class CopyFilebyte03 {
	  /**
	   * ͨ������File���󿽱�
	   * @param src   Դ�ļ�
	   * @param dest  Ŀ�ĵ��ļ�
	   * @throws Exception
	   */
	    public static void copyFile(File src,File dest) throws Exception{	    	
	    	try {	 
	    		//�����ļ�����Ϊnull
	    		if(!src.isFile()){	
	    			//System.out.println("ֻ�ܿ����ļ�");	
	    			throw new Exception("ֻ�ܿ����ļ�");																					
				}
	    		//destΪ�Ѿ����ڵ��ļ��У����ܴ������ļ���ͬ�����ļ�
	    		if(dest.isDirectory()){
	    			throw new Exception("���ܴ������ļ���ͬ�����ļ�");
	    		}
	    		//ѡ����
				InputStream is=new FileInputStream(src);
				//trueΪ׷��  falseΪ����   ��дĬ��Ϊ����
				OutputStream os=new FileOutputStream(dest,true);							
				//3.�ļ�����     ѭ��+��ȡ+д��
				byte[] car = new byte[1024];
				int len=0;
				try {
					while(-1!=(len=is.read(car))){
						os.write(car, 0, len);						
					}
					os.flush();
					is.close();
					os.close();
					System.out.println("�����ɹ���");
				} catch (IOException e) {	
					System.out.println("�����ļ�ʧ��");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("�ļ�������");
				e.printStackTrace();
			}
	    }
	    /**
	     * ͨ������·������
	     * @param srcpath   Դ�ļ�·��
	     * @param destpath  Ŀ�ĵ�·��
	     * @throws Exception
	     */
	    public static void copyFile(String srcpath,String destpath ) throws Exception{
	    	copyFile(new File(srcpath),new File(destpath));
	    }
		public static void main(String[] args) throws Exception   {
			 //ֻ�ܿ����ļ�
			 //String src="E:/test/aaa";
			 String src="E:/test/02.java";
			 String dest="E:/test/03.java";	
		     //copyFile(src, dest);
		     copyFile(new File(src),new File(dest));
		}
}
