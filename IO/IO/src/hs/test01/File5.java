package hs.test01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
/**
 * ͨ��listFiles() �����Ҹ�Ŀ¼�£����е�Ŀ¼���ļ��� �ݹ飡
 * �����ڲ�����дaccept�ķ�������ĳһ������Ŀ¼���ļ���
 * listRoots()  ��·��
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
    	// ͨ��listFiles() �����Ҹ�Ŀ¼�£����е�Ŀ¼���ļ���
    	if(f.isDirectory()){
    		for(File temp:f.listFiles()){
    			test(temp);
    		}   		
    	}
	    	/*//�����ڲ�����дaccept�ķ������Һ�ĳһ������ Ŀ¼���ļ���
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
