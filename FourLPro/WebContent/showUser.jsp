<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" scope="request" class="useBean.user.User" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
  function f2(){
	  var nameNew=document.getElementById("nameNew");
	  var passwordNew=document.getElementById("passwordNew");
	  document.getElementById("name").innerHTML=nameNew.value;
	  document.getElementById("password").innerHTML=passwordNew.value;
	  var form1=document.getElementById("change");
	  form1.submit();
  }
</script>
</head>
<style type="text/css">
button#button21 {
    margin-top:20;
    float:right;
    line-height:3;
    position:relative;
    color:crimson;
}
</style>
</head>
<body>
   id:       <span id="id"><%=user.getId()%></span><br>
   姓名:       <span id="name"><%=user.getName() %></span><br>
   密码:       <span id="password" ><%=user.getPassword() %></span><br>
   <img src="bg6.jpg" >
   <br>
    <form id="change" action="http://localhost:8080/FourLPro/change" method="post"
target="iframe2">
     <input id="idNew" type="hidden" name="idNew" value="<%=user.getId()%>"></input>
              名字：<input id="nameNew" name="nameNew" value="<%=user.getName()%>"></input>
              密码：<input id="passwordNew" name="passwordNew" value="<%=user.getPassword()%>"></input> 
    </form>
    <br><br>
     <button id="button21" onclick="f2()"> 确认修改 </button>
</body>
</html>