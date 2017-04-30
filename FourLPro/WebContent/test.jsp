<p><% String n = request.getParameter("name");
	if(n!=null&&!"".equals(n.trim())){
		out.print(n);
	}
%></p>