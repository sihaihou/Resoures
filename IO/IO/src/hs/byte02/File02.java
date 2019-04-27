package hs.byte02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * 写出文件
 * 1，建立联系  创建File对象   目的地
 * 2，选择流  ——文件输出流
 * 		1）OutputStream
 * 		1）FileOutputStream
 * 3,操作：write+flush
 * 4,释放资源  ——关闭
 * @author Administrator
 */
public class File02 {
		public static void main(String[] args) {
			//1，建立联系  创建File对象   目的地
			File file =new File("E:/test/02.java"); 
			//2，选择流  ——文件输出流   1）OutputStream  FileOutputStream
			OutputStream os=null;
			//以追加形式写出文件
			try {
				 os=new FileOutputStream(file,false);//true为追加  false为覆盖   不写默认为覆盖
				// 3,操作：write+flush
				String str="选择流  ——文件输出流  1）OutputStream 1）FileOutputStream"
						+ "3,操作：write+flush"
						+ "4,释放资源  ——关闭";
				//字符串转字节数组
				byte[] car=str.getBytes();
				try {
					os.write(car, 0, str.length());
					os.flush();//强行刷新出去
					System.out.println("文件写出成功！");
				} catch (IOException e) {
					System.out.println("文件写出失败");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("文件不存在");
				e.printStackTrace();
				// 4,释放资源  ——关闭
			}finally{
				if(null!=os){
					try {
						os.close();						
					} catch (IOException e) {
						System.out.println("文件释放失败");
						e.printStackTrace();
					}
				}
			}
		}
}
