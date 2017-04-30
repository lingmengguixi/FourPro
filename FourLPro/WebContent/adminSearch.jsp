<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="result" scope="request" class="search.Result" />
<jsp:useBean id="demo" scope="request" class="sunYang.Mesage" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
  function a(value){

		   var type=document.getElementById("m2");
		   var findForm=document.getElementById("resultform");
		   type.value=value;
		   findForm.submit();
  }
</script>
</head>

<body>
    搜索类型:
    <%
      String t1="账号",t2="订单",t=null,action1="";
      
    %>
   <%
     if(demo.getMesage().equals("user")){
    	 %>用户<%
    	 t=t1;
    	 action1="http://localhost:8080/FourLPro/adminSee";
     }else if(demo.getMesage().equals("order")){
    	 %>订单<%
    	 t=t2;
    	 action1="http://localhost:8080/FourLPro/adminSee1";
     }else{
    	 %>未知<%
     }
   %>
   <br>
   搜到个数:
    <%=result.getElement().size()%>
    <form name="resultform" id="resultform"  action=<%=action1%> method="post" target="iframe2">
     <input type="hidden" id="m2" name="m2"/></input>
    </form>
  <%  
     out.println("<ul>");
     for(int i=1;i<=result.getElement().size();i++){
     	out.println("<li><a target=\"iframe2\" href=\"javascript:a('"+result.getElement().get(i-1)+"')\">"+t+i+":"+result.getElement().get(i-1)+"</a></li>");
     	//out.println("<li><a target=\"top.iframe2\" href=\"http://www.baidu.com\">"+t+i+":"+result.getElement().get(i-1)+"</a></li>");
     	  
     }
     out.println("</ui>");
    out.println("完毕");
    out.close();
  %>
</body>
</html>