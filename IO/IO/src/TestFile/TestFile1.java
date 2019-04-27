package TestFile;

import java.io.File;

public class TestFile1 {
			static void printFile(File file,int level){
				for(int i=0;i<level;i++){
					System.out.print("-");
				}
				System.out.println(file.getName());				
				if(file.isDirectory()){
					File [] files=file.listFiles();
				for(File temp:files){
					printFile(temp,level+1);
				}
			}
		}
			public static void main(String[] args) {
				File f=new File("E:/test");
				printFile(f,1);
			}		
}
