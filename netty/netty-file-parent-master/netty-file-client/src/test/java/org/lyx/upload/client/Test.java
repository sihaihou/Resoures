/**
* 版权所有：蚂蚁与咖啡的故事
*====================================================
* 文件名称: Test.java
* 修订记录：
* No    日期				作者(操作:具体内容)
* 1.    2013-4-11			liuyuanxian(创建:创建文件)
*====================================================
* 类描述：(说明未实现或其它不应生成javadoc的内容)
* 
*/
package org.lyx.upload.client;

import java.io.File;

import org.lyx.file.client.FileClient;


public class Test {

	/**
	 * @param args
	 * @author liuyuanxian
	 */
	public static void main(String[] args) throws Exception {
		FileClient.replaceFile(new File("D:\\3\\1.jpg"), "3\\k\\1.jpg");
		// FileClient.deleteFile("3\\k\\1.jpg");
	}
	
}
