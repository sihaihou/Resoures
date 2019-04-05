package hs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import hs.pojo.Cart;

public class AddCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String bookName = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		HttpSession session = request.getSession();
		Cart sc = (Cart)session.getAttribute("sc");
		if(sc == null) {
			sc = new Cart();
			session.setAttribute("sc", sc);
		}
		sc.addCart(bookName, price);
		/*
		StringBuilder result = new StringBuilder();
		result.append("{")				
				.append("\"bookName\":\""+bookName+"\"")
				.append(",")
				.append("\"totalBookNumber\":"+sc.getTotalBookNumber())
				.append(",")
				.append("\"totalBookPrice\":"+sc.getTotalBookPrice())
				.append("}");
		*/
		/**
		 *  π”√JackSon
		 */
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(sc);
		response.setContentType("text/javascript,charset=UTF-8");
		response.getWriter().println(result);
	}

}
