package hs.char03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * 字符流写出文件
 * @author 侯四海
 */
public class FileChar2 {
	public static void main(String[] args) {
		File dest=new File("E:/test/05.java");
		Writer w=null;
		try {
			w=new FileWriter(dest,false);
			String str="床前明月光,\r\n疑是地上霜.\r\n举头望明月，\r\n低头思故乡！\r\n";
//			wt.append("李白————");
			w.write(str);
			w.flush();
		} catch (IOException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
		}finally{
			if(w!=null){
				try {
					w.close();
					System.out.println("内容写出成功！");
				} catch (IOException e) {
					System.out.println("释放失败");
					e.printStackTrace();
				}
			}
		}
	}
}
