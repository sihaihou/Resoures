package hs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.java.javaURLContextFactory;
import org.apache.struts2.ServletActionContext;
/**
 * servlet �����ط�ʽ
 * @author Administrator
 */
public class DownloadAction {
	public String execute() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		//��ȡ�����ļ���·��
		String path = req.getRealPath("/download");
		File file = new File(path,"���ǳ۹���-ֻҪΪ���һ��.mp4");
		resp.setContentLength((int)file.length());	
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename="+ java.net.URLEncoder.encode("���ǳ۹���-ֻҪΪ���һ��.mp4", "UTF-8"));
		byte[] buffer = new byte[1024];
		int len = 0;
		InputStream is =new FileInputStream(file);
		OutputStream os = resp.getOutputStream();
		while(-1!=(len=is.read(buffer))){
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();	
		return null;
	}
}
