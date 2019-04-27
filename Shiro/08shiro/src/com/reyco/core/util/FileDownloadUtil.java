package com.reyco.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadUtil {
	/**
	 * @param filename  下载文件名
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws Exception
	 */
	public static void download(String filename,HttpServletRequest request,HttpServletResponse response) throws Exception{  
        String fileName = request.getServletContext().getRealPath("download")+"\\"+filename; 
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
        filename = URLEncoder.encode(filename,"UTF-8");  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
    }  
	
	/**
	 * 
	 * @param file  下载的文件
	 * @param request  HttpServletRequest
	 * @param response  HttpServletResponse
	 * @throws Exception
	 */
	public static void download(File file,HttpServletRequest request,HttpServletResponse response) throws Exception{  
		download(file.getName(),request,response);
    }  
	
	
}
