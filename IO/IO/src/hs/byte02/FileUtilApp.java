package hs.byte02;

import java.io.File;

public class FileUtilApp {
	public static void main(String[] args) throws Exception   {
		 String srcpath="E:/test/02.java";
		 String destpath="E:/test/03.java";
		 File src=new File(srcpath);
		 File dest=new File(destpath);			
		 //������ѡ��һ
//		 FileUtil.copyFile(src, dest);			
		 FileUtil.copyFile(srcpath, destpath);	
	}
}
