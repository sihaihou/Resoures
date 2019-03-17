package com.reyco.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileuploadUtil {
	
	private final static String SUFFIX = ".mp4";
	/**
	 * 文件批量上传
	 * @param filePath
	 * @param file
	 * @param req
	 * @throws Exception
	 */
	public static void fileupload(String filePath,CommonsMultipartFile file[],Long timeStr,HttpServletRequest req) throws Exception{
		for(int i=0;i<file.length;i++){
			fileupload(filePath,file[i],timeStr,req);
		}
	}
	/**
	 * 文件上传
	 * @param filePath
	 * @param file
	 * @param req
	 * @throws Exception
	 */
	public static String fileupload(String path,CommonsMultipartFile file,Long timeStr,HttpServletRequest req) throws Exception{
		checkFilePath(path);
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		if(suffix.equalsIgnoreCase(SUFFIX)) {
			String newFileName = timeStr+suffix;
			InputStream is=file.getInputStream();
			OutputStream os=new FileOutputStream(new File(path,newFileName));
			int len=0;
			byte[] buffer=new byte[1024];
			while((len=is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
			os.flush();
			os.close();
			is.close();
			return newFileName;
		}
		return null;
	}
	/**
	 * 验证文件路径是否存在:无则创建
	 * @param path
	 */
	private static void checkFilePath(String path) {
		if(!StringUtils.isBlank(path)) {
			File file = new File(path);
			if (!file.exists()) {
				if (!file.isDirectory()) {
					file.mkdirs();
				}
			}else {
				file.mkdirs();
			}
		}
	}
	
	
	
}
