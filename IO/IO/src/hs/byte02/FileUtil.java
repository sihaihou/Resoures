package hs.byte02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 文件的拷贝
 * 文件夹的拷贝
 * @author 侯四海
 */
public class FileUtil {
	 /**
	  *  文件的拷贝	   	 	 	
	  * @param src  源文件
	  * @param dest  目的地文件
	  * @throws Exception
	  */
	 public static void copyFile(File src,File dest )throws Exception {
		//不是文件或者为null	 
		 if(!src.isFile()){
			 System.out.println("只能拷贝文件");
			throw new Exception("只能拷贝文件");			
		 }
		//dest为已经存在的文件夹，不能创建与文件夹同名的文件
 		 if(dest.isDirectory()){
 		    	throw new Exception("不能创建与文件夹同名的文件");
 		 }
		 //选择流
		 InputStream is;		
		 is = new BufferedInputStream(new FileInputStream(src));
		 OutputStream os;
		//true为追加  false为覆盖   不写默认为覆盖
		 os=new BufferedOutputStream(new FileOutputStream(dest,false));
		 //3.文件拷贝     循环+读取+写出
		 byte[] car = new byte[1024];
		 int len=0;
		 //读取
		 while(-1!=(len=is.read(car))){	
			 //写出
				os.write(car, 0, len);						
		 }
		//强行刷新出去
		os.flush();
		//关闭流
		is.close();
		os.close();
	}	 
    /**
	 * 文件的拷贝
	 *     
	 *     
	 * @param srcpath   源路径
	 * @param destpath  目的地路径
	 * @throws Exception
	 */
	 public static void copyFile(String srcpath,String destpath ) throws Exception{
	    	copyFile(new File(srcpath),new File(destpath));
	 }
	
 	/**
 	 * 拷贝文件夹
	 * src  源File对象
	 * dest 目标File对象
 	 * @param src
 	 * @param dest
 	 */
    public static void copydir(File src,File dest){
    	if(src.isDirectory()){   //文件夹    	
			 dest= new File(dest,src.getName());
			//拷贝文件夹BUG修复
			 if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				 System.out.println("父目录不能拷贝到子目录");
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
    //拷贝文件夹细节	    
	public static void  copydirDetail(File src,File dest){
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
				copydirDetail(sub,new File(dest,sub.getName()));     
			}
		}
	}	
}
