package JavaCompiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
/**
 * 动态编译
 * @author Administrator
 *
 */
public class TestJavaCompiler {
	public static void main(String[] args) throws Exception {
		try {
			String path="public class hello{public static void main(String [] args){System.out.println( \"Hello wolrd...\");}}";
			File file=new File(path);
			File src=file.createTempFile("Hello",".java",new File("E:/test"));
			Thread.sleep(2000);
			src.deleteOnExit();
//			JavaCompiler com=ToolProvider.getSystemJavaCompiler();
//			int result=com.run(null, null, null, "E:/home/Helloworld.java");
//			System.out.println(result==0?"编译成功":"编译失败");
			
			//通过JavaCompiler调用执行改目录下的类
			JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
			int result2=compiler.run(null, null, null, "E:/test/01/Hello.java");
			System.out.println(result2==0?"编译成功":"编译失败");
			System.out.println("-------------------------------");
			
			//通过Runtime调用执行类
			Runtime run=Runtime.getRuntime();
			Process porecss=run.exec("java -cp E:/test/01  Hello");
			InputStream is=porecss.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String str="";
			while(null!=(str=br.readLine())){
				System.out.println(str);
			}
			
			
			/*URL[] urls=new URL[]{new URL("file:/"+"E:/test/01/")};
			URLClassLoader loader=new URLClassLoader(urls);
			Class clazz=loader.loadClass("Hello");
			//调用加载类的main方法
			Method m=clazz.getMethod("main", String[].class);
			m.invoke(null, (Object)new String[]{});*/
			//由于可变参数是JDK5.0以后才有，代码回编译成m.invoke(null,"aa","bb");就发生了参数不匹配的问题；
			//因此必须加上(Object)转型，避免这个问题。
			//public static void xxx(String[] a,String[] b){}  
			//public static void main(String[] args){}  
			} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
