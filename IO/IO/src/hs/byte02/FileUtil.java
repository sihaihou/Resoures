package hs.byte02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ļ��Ŀ���
 * �ļ��еĿ���
 * @author ���ĺ�
 */
public class FileUtil {
	 /**
	  *  �ļ��Ŀ���	   	 	 	
	  * @param src  Դ�ļ�
	  * @param dest  Ŀ�ĵ��ļ�
	  * @throws Exception
	  */
	 public static void copyFile(File src,File dest )throws Exception {
		//�����ļ�����Ϊnull	 
		 if(!src.isFile()){
			 System.out.println("ֻ�ܿ����ļ�");
			throw new Exception("ֻ�ܿ����ļ�");			
		 }
		//destΪ�Ѿ����ڵ��ļ��У����ܴ������ļ���ͬ�����ļ�
 		 if(dest.isDirectory()){
 		    	throw new Exception("���ܴ������ļ���ͬ�����ļ�");
 		 }
		 //ѡ����
		 InputStream is;		
		 is = new BufferedInputStream(new FileInputStream(src));
		 OutputStream os;
		//trueΪ׷��  falseΪ����   ��дĬ��Ϊ����
		 os=new BufferedOutputStream(new FileOutputStream(dest,false));
		 //3.�ļ�����     ѭ��+��ȡ+д��
		 byte[] car = new byte[1024];
		 int len=0;
		 //��ȡ
		 while(-1!=(len=is.read(car))){	
			 //д��
				os.write(car, 0, len);						
		 }
		//ǿ��ˢ�³�ȥ
		os.flush();
		//�ر���
		is.close();
		os.close();
	}	 
    /**
	 * �ļ��Ŀ���
	 *     
	 *     
	 * @param srcpath   Դ·��
	 * @param destpath  Ŀ�ĵ�·��
	 * @throws Exception
	 */
	 public static void copyFile(String srcpath,String destpath ) throws Exception{
	    	copyFile(new File(srcpath),new File(destpath));
	 }
	
 	/**
 	 * �����ļ���
	 * src  ԴFile����
	 * dest Ŀ��File����
 	 * @param src
 	 * @param dest
 	 */
    public static void copydir(File src,File dest){
    	if(src.isDirectory()){   //�ļ���    	
			 dest= new File(dest,src.getName());
			//�����ļ���BUG�޸�
			 if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				 System.out.println("��Ŀ¼���ܿ�������Ŀ¼");
				 return;
			 }
    	}   
    	copydirDetail(src,dest);
    }
    public static void copydir(String srcpath,String destpath){
    	File src=new File(srcpath);
		File dest=new File(destpath);
		copydir(src,dest);
    }   
    //�����ļ���ϸ��	    
	public static void  copydirDetail(File src,File dest){
		//������ļ�        ���� ֱ��copy
		if(src.isFile()){ //�ļ� 
			try {
				FileUtil.copyFile(src, dest);//copy
			} catch (Exception e) {
				e.printStackTrace();
			}
		//������ļ���  ����ȷ��Ŀ¼���� ����������ȡ��һ���ļ���|�ļ�
		//�ļ��� 
		}else if(src.isDirectory()){  
			//ȷ��Ŀ¼���� 
			dest.mkdirs();	
			//��������ȡ��һ���ļ���|�ļ�
			for(File sub:src.listFiles()){    
				copydirDetail(sub,new File(dest,sub.getName()));     
			}
		}
	}	
}
