package hs.byte02;

import java.io.File;
/**
 * 拷贝文件夹
 * @author Administrator
 */
public class CopyFileDirbyte04 {
	 	/**
	 	 *  拷贝文件夹
	 	 * @param src  源File对象
	 	 * @param dest  目标File对象
	 	 */
	    public static void copydir(File src,File dest){
	    	if(src.isDirectory()){   //文件夹    	
	    		dest= new File(dest,src.getName());
	    		//拷贝文件夹BUG修复
//				 if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
//					 System.out.println("父目录不能拷贝到子目录");
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
	     * 拷贝文件夹细节	    
	     * @param src
	     * @param dest
	     */
		public static void copydirDetail(File src,File dest){
			//如果是文件        —— 直接copy
			if(src.isFile()){ //文件 
				try {
					FileUtil.copyFile(src, dest);//copy
				} catch (Exception e) {
					e.printStackTrace();
				}
			//如果是文件夹  ——确保目录存在 ——遍历获取下一级文件夹|文件
			//文件夹
			}else if(src.isDirectory()){   
				//确保目录存在 
				dest.mkdirs();			  
				 //—遍历获取下一级文件夹|文件
				for(File sub:src.listFiles()){   
					//自己调自己 
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
