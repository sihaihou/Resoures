package hs.byte02;

import java.io.File;

public class FileUtilApp2 {	
		public static void main(String[] args) {
			//ԴĿ¼
			String srcpath="E:/test/aaa/bbb";
			//Ŀ��Ŀ¼
			String destpath="E:/test/dir";
//			File src=new File(srcpath);
//    		File dest=new File(destpath);
//    		FileUtil.copydir(srcpath,destpath);
			FileUtil.copydir(srcpath, destpath);
			
		}
}
