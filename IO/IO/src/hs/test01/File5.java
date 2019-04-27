package hs.test01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
/**
 * 通过listFiles() 可以找该目录下，所有的目录和文件！ 递归！
 * 匿名内部类重写accept的方法，找某一特征的目录或文件！
 * listRoots()  根路径
 * @author Administrator
 */
public class File5 {
	public static void main(String[] args) {
		String path="E:/test";
		File file =new File(path);
		File[] root=file.listRoots();
		System.out.println(Arrays.toString(root));
		for(File temp:root){
//			test(temp);
		}
		test(file);
	}
	
		
    public static void test(File f){
    	if(f==null||!f.exists()){
    		return ;
    	}
    	System.out.println(f.getAbsolutePath());
    	// 通过listFiles() 可以找该目录下，所有的目录和文件！
    	if(f.isDirectory()){
    		for(File temp:f.listFiles()){
    			test(temp);
    		}   		
    	}
	    	/*//匿名内部类重写accept的方法，找含某一特征的 目录或文件！
	    	if(f.isDirectory()){
	    		for(File temp:f.listFiles(new FilenameFilter(){
					@Override
					public boolean accept(File dir, String name) {
						return  new File(dir,name).isFile()&&name.endsWith(".java");   		
					}	    			
	    		})){
	    			test(temp);
	    		}   		
	    	}  */
    }
}
