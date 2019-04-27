package hs.byte02;

import java.io.File;

public class CopyFileDirbyte04_test {	
	public static void copydirDetail(File src,File dest){
		if(src.isFile()){
			try {
				FileUtil.copyFile(src, dest);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(src.isDirectory()){
			dest.mkdirs();
			for(File sub:src.listFiles()){
				copydirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
	
	public static void copydir(File src,File dest){
		if(src.isDirectory()){
			 dest=new File(dest,src.getName());
			 //拷贝文件夹BUG修复
			 if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				 System.out.println("父目录不能拷贝到子目录");
				 return;
			 }
		}
		copydirDetail(src,dest);
	}
	
	public static void copydir0(String srcpath,String destpath){
		File src=new File(srcpath);
		File dest=new File(destpath);
		copydir(src,dest);	
	
	}
	public static void main(String[] args) throws Exception {
		String srcpath="E:/test/dir";
		String destpath="E:/test/pp";
		File src=new File(srcpath);
		File dest=new File(destpath);;
		if(src.isDirectory()){
			 dest=new File(destpath,src.getName());
		}
//		copydir(srcpath,destpath);
		copydir(src,dest);
	}		
}
