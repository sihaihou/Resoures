package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebServlet("/upload")
@MultipartConfig   //表明当前Servlet可以处理Multipart请求
public class fileUpload extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/upload");
		//
		Part part = request.getPart("fileName");
		System.err.println("part====="+part);
		String header = part.getHeader("Content-Disposition");
		//header:form-data; name="fileName"; filename="register.html"
		//分割 header 字符串
		int index = header.lastIndexOf("=");
		String fileName= header.substring(index+2,header.length()-1);
		
		part.write(path+"/"+fileName);
	}

}
