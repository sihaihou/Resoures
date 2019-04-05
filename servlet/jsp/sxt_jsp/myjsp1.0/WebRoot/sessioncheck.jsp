<%
	String name = (String)session.getAttribute("name");
	if(name == null ||!name.equals("name")){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>