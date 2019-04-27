package hs.buffered04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 
 * 处理流
 * 文件的拷贝    +  添加的缓冲流     ————提高性能
 * 			缓冲流(字节流)
 * 
 * 1，建立联系   File对象  源头 目的地
 * 2，选择流
 *    	文件输入流	InputStream  FileInputStream
 *     	文件输出流    	OutputStream  FileOutputStream	
 * 3，操作: 拷贝
 * 		byte[] flush=new byte[1024];
 *      int len=0;
 *      while(-1=(len=输入流。read(flush))){
 *      	输出流 write(flush,0,len)
 *      }
 *      输出流。flush；
 * 4，释放资源：关闭两个流     
 */
public class Bufferedbyte {
	 public static void copyFile(String srcpath,String destpath ) throws Exception{
	    	try {	    		
	    		//1，建立联系(存在且为文件)  +目的地(文件可以不存在)
	    		File src=new File(srcpath);
	    		File dest=new File(destpath);	
	    		if(!src.isFile()){//不是文件或者为null	
//	    			System.out.println("只能拷贝文件");	
	    			throw new Exception("只能拷贝文件");																					
				}
	    		//dest为已经存在的文件夹，不能创建与文件夹同名的文件
	    		if(dest.isDirectory()){
	    			throw new Exception("不能创建与文件夹同名的文件");
	    		}
	    		//选择流
				InputStream is=new BufferedInputStream(new FileInputStream(src));
				OutputStream os=new BufferedOutputStream(new FileOutputStream(dest,true));//true为追加  false为覆盖   不写默认为覆盖							
				//3.文件拷贝     循环+读取+写出
				byte[] car = new byte[1024];
				int len=0;
				try {
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
				} catch (IOException e) {	
					System.out.println("拷贝文件失败");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在");
				e.printStackTrace();
			}
	    }
		public static void main(String[] args) throws Exception   {
			 String src="E:/test/test1.java";
			 String dest="E:/test/test2.txt";	
		     copyFile(src, dest);
		
		}
}
