package hs.byte02;

import java.io.File;
/**
 * �����ļ���
 * @author Administrator
 */
public class CopyFileDirbyte04 {
	 	/**
	 	 *  �����ļ���
	 	 * @param src  ԴFile����
	 	 * @param dest  Ŀ��File����
	 	 */
	    public static void copydir(File src,File dest){
	    	if(src.isDirectory()){   //�ļ���    	
	    		dest= new File(dest,src.getName());
	    		//�����ļ���BUG�޸�
//				 if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
//					 System.out.println("��Ŀ¼���ܿ�������Ŀ¼");
//					 return;
//				 }
	    	}   
	    	copydirDetail(src,dest);
	    }
	    public static void copydir(String srcpath,String destpath){
	    	File src=new File(srcpath);
    		File dest=new File(destpath);
    		copydir(src,dest);
	    }	
	    
	    /**
	     * �����ļ���ϸ��	    
	     * @param src
	     * @param dest
	     */
		public static void copydirDetail(File src,File dest){
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
					//�Լ����Լ� 
					copydirDetail(sub,new File(dest,sub.getName()));     
				}
			}
		}
		public static void main(String[] args) {
			String srcpath="E:/test/aaa/bbb";
			String destpath="E:/test/dir";
			File src=new File(srcpath);
			File dest=new File(destpath);
			if(src.isDirectory()){
				dest=new File(destpath,src.getName());
			}
    		//copydir(srcpath,destpath);
    		copydir(src,dest);
		}		
}
