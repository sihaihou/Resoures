package com.exam.core.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.core.util.FileUploadUtil;
import com.exam.core.util.JSONResult;

@RequestMapping("/upload")
@RestController
public class FileUploadController {
	
	@RequestMapping("/mp4")
	public String mp4(@RequestParam("file")MultipartFile file) throws IOException {
		if(null == file) {
			return JSONResult.failCreate("", "").toJSON();
		}
		String path="D:\\application\\workspace\\exam\\src\\main\\webapp\\upload";
		if(null == path || path.equals("")) {
			return JSONResult.failCreate("", "").toJSON();
		}
		String fileName =FileUploadUtil.fileUpload(path, file);
		return JSONResult.create(fileName).toJSON();
	}
	@RequestMapping("/upload")
	public String upload(@RequestParam("file")MultipartFile file) throws IOException {
		if(null == file) {
			return JSONResult.failCreate("", "").toJSON();
		}
		String path="D:\\application\\workspace\\exam\\src\\main\\webapp\\upload";
		if(null == path || path.equals("")) {
			return JSONResult.failCreate("", "").toJSON();
		}
		String fileName =file.getOriginalFilename();
		fileName = path + "\\"+fileName;
		file.transferTo(new File(path));
		return JSONResult.create(fileName).toJSON();
	}
}
