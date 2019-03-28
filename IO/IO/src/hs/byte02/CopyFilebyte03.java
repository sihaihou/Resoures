package hs.byte02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 文件的拷贝
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

public class CopyFilebyte03 {
	  /**
	   * 通过传递File对象拷贝
	   * @param src   源文件
	   * @param dest  目的地文件
	   * @throws Exception
	   */
	    public static void copyFile(File src,File dest) throws Exception{	    	
	    	try {	 
	    		//不是文件或者为null
	    		if(!src.isFile()){	
	    			//System.out.println("只能拷贝文件");	
	    			throw new Exception("只能拷贝文件");																					
				}
	    		//dest为已经存在的文件夹，不能创建与文件夹同名的文件
	    		if(dest.isDirectory()){
	    			throw new Exception("不能创建与文件夹同名的文件");
	    		}
	    		//选择流
				InputStream is=new FileInputStream(src);
				//true为追加  false为覆盖   不写默认为覆盖
				OutputStream os=new FileOutputStream(dest,true);							
				//3.文件拷贝     循环+读取+写出
				byte[] car = new byte[1024];
				int len=0;
				try {
					while(-1!=(len=is.read(car))){
						os.write(car, 0, len);						
					}
					os.flush();
					is.close();
					os.close();
					System.out.println("拷贝成功！");
				} catch (IOException e) {	
					System.out.println("拷贝文件失败");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在");
				e.printStackTrace();
			}
	    }
	    /**
	     * 通过传递路径拷贝
	     * @param srcpath   源文件路径
	     * @param destpath  目的地路径
	     * @throws Exception
	     */
	    public static void copyFile(String srcpath,String destpath ) throws Exception{
	    	copyFile(new File(srcpath),new File(destpath));
	    }
		public static void main(String[] args) throws Exception   {
			 //只能拷贝文件
			 //String src="E:/test/aaa";
			 String src="E:/test/02.java";
			 String dest="E:/test/03.java";	
		     //copyFile(src, dest);
		     copyFile(new File(src),new File(dest));
		}
}
