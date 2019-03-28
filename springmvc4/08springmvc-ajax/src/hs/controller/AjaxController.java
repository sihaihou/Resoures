package hs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController{
	@RequestMapping("/ajax")
	public void ajax(String name,HttpServletResponse resp) throws IOException{
		if("hsh".equals(name)){
			resp.getWriter().println("true");
		}else{
			resp.getWriter().println("false");
		}
	}		
}
