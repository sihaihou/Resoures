package com.exam.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	/**
	 * 文件格式
	 */
	private final static String MP4="mp4";
	/**
	 * 文件格式
	 */
	private final static String JPG="JPG";
	/**
	 * MP4格式语音上传
	 * @param path  文件上传目录
	 * @param file  上传的文件
	 * @throws IOException
	 */
	public static String fileUpload(String path,MultipartFile file,Integer id) throws IOException {
		String fileName = null;
		if(null != file) {
			fileName = file.getOriginalFilename();
			String[] arr = fileName.split("\\.");
			if(arr[arr.length-1].equalsIgnoreCase(JPG)) {
				InputStream is=file.getInputStream();
				int index = fileName.lastIndexOf(".");
				fileName = id+fileName.substring(index);
				checkFilePath(path);
				OutputStream os = new FileOutputStream(new File(path,fileName));
				int len=0;
				byte[] buffer=new byte[1024];
				while((len=is.read(buffer))!=-1){
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
				return fileName;
			}
		}
		return null;
	}
	/**
	 * MP4格式语音上传
	 * @param path  文件上传目录
	 * @param file  上传的文件
	 * @param id id
	 * @throws IOException
	 */
	public static String fileUpload(String path,MultipartFile file) throws IOException {
		String fileName = null;
		if(null != file) {
			fileName = file.getOriginalFilename();
			String[] arr = fileName.split("\\.");
			if(arr[arr.length-1].equalsIgnoreCase(MP4)) {
				InputStream is=file.getInputStream();
				checkFilePath(path);
				OutputStream os = new FileOutputStream(new File(path,fileName));
				int len=0;
				byte[] buffer=new byte[1024];
				while((len=is.read(buffer))!=-1){
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
				return fileName;
			}
		}
		return null;
	}
	/**
	 *  验证文件目录:存在不操作，不存在则创建
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
