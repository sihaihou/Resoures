package hs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	/**
	 * 表单文件名
	 */
	private File file;
	/**
	 * 文件名
	 */
	private String fileFileName;
	/**
	 * 文件类型
	 */
	private String fileContentType;	
	/**
	 * 文件上传
	 * @return
	 * @throws IOException
	 */
	public String upload() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		//上传路径
		String path = request.getRealPath("/upload"); 
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(path,fileFileName));
		byte[] buffer = new byte[1024];
		int len = 0;
		while(-1!=(len=is.read(buffer))){
			os.write(buffer,0,len);
		}
		os.flush();
		os.close();
		is.close();
		return Action.SUCCESS;
	}

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}	
}
