<%
	String admin = (String)session.getAttribute("admin");
	if(admin == null ||!admin.equals("admin")){
		request.getRequestDispatcher("userlogin.jsp").forward(request, response);
	}
%>