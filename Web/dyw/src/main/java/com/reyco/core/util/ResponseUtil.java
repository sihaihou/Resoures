package com.reyco.core.util;

import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

public class ResponseUtil {
	
	public static void export(HttpServletResponse response,String fileName,Workbook wb) throws Exception{
		fileName = URLEncoder.encode(fileName,"UTF-8");  
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);    
        response.setContentType("multipart/form-data");   
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.flush();
        out.close();
	}
	
	
}
