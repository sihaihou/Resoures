package com.reyco.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayUtil {
	public static void sayPlay( String fileName,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ��ȡtomcat ·��
		String ROOT = request.getServletContext().getRealPath("download/"+fileName);
		// ��� wav IO��
		try {
			response.setHeader("Content-Type", "audio/mpeg");
			File file = new File(ROOT);
			int len_l = (int) file.length();
			byte[] buf = new byte[2048];
			FileInputStream fis = new FileInputStream(file);
			
			OutputStream out = response.getOutputStream();
			len_l = fis.read(buf);
			while (len_l != -1) {
				out.write(buf, 0, len_l);
				len_l = fis.read(buf);
			}
			out.flush();
			out.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void doGet(String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
		// ������Ӧ��������

		response.setHeader("Content-type", "text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");// �������
		response.setContentType("text/html;charset=UTF-8");// �������
		//String sentences = request.getParameter("text");
		try {
			sayPlay( fileName,request, response);
		} catch (Exception e) {
			System.out.printf(e.getMessage());
		}

	}
}
