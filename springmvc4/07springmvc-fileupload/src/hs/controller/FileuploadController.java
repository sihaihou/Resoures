package hs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileuploadController {
	//文件上传
	@RequestMapping("/upload")
	public String fileupload(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest req) throws Exception{
		
		String path=req.getRealPath("/fileupload");
		InputStream is=file.getInputStream();
		OutputStream os=new FileOutputStream(new File(path,file.getOriginalFilename()));		
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=is.read(buffer))!=-1){
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
		return "index.jsp";
	}
	
	//批量上传
	@RequestMapping("/batch")
	public String batch(@RequestParam("file")CommonsMultipartFile file[],HttpServletRequest req) throws Exception{
		
		String path=req.getRealPath("/fileupload");
		for(int i=0;i<file.length;i++){
			InputStream is=file[i].getInputStream();
			OutputStream os=new FileOutputStream(new File(path,file[i].getOriginalFilename()));
			int len=0;
			byte[] buffer=new byte[1024];
			while((len=is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
			os.close();
			is.close();
		}
		return "index.jsp";
	}
}
