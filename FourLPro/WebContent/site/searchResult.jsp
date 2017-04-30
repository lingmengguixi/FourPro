<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="useBean.entity.UsedBook,java.util.ArrayList,org.apache.catalina.connector.Request"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%!String search;%>
<%-- <% --%>
//  	search = new String(request.getParameter("search").getBytes("ISO8859-1"), "UTF-8");
//  	out.print("\"" + search + "\"");
<%--  %> --%>
<title>搜索  的结果
</title>
<style type="text/css">
#box {
	width: 1200px;
	margin: auto;
}

#book {
	width: 300px;
	height: 500px;
	float: left;
	border: 1px;
}

#book2 {
	width: 300px;
	height: 500px;
	float: left;
}

#book3 {
	width: 300px;
	height: 500px;
	float: left;
}

#book4 {
	width: 300px;
	height: 500px;
	float: left;
}

#book5 {
	width: 300px;
	height: 500px;
	float: left;
}

#book6 {
	width: 300px;
	height: 500px;
	float: left;
}

#book7 {
	width: 300px;
	height: 500px;
	float: left;
}

#book8 {
	width: 300px;
	height: 500px;
	float: left;
}

.p1 {
	color: #B22222;
	font_size: 15px;
}

.p2 {
	font_size: 10px;
}

.p3 {
	font_size: 15px;
	text-align: center;
}
</style>
</head>
<body>
	<%!ArrayList<UsedBook> books = null;%>
	<%
		books = (ArrayList<UsedBook>) request.getAttribute("books");
	%>
	<%!String path = null;%>
	<%
		path = request.getContextPath();
		request.setCharacterEncoding("UTF-8");
	%>
	<div id="box">
		<table border="0" width="1200px" align="center"
			style="background-color: #F0FFF0">
			<tr>
				<td width="60%"><a href="http://www.baidu.com" target="_blank">首页</a></td>
				<td width="10%"><a href="http://www.baidu.com" target="_blank">注册</a></td>
				<td width="10%"><a href="<%=path%>/site/login.jsp"
					target="_blank">登录</a></td>
			</tr>
		</table>
		<div id="searchBox">
			<form name="form1" action="/FourLPro/search" method="post">
				<table border="1" width="500" align="center">
					<tr>
						<td width="80%"><input name="search" type="text"
							value="请输入要搜索的图书" accept-charset="UTF-8" /></td>
						<td><input type="submit" name="tijiao" value="提交" /></td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<div id="book">
			<img style="border: 0px;" width="300px" height="300px" alt=""
				src="<%=path%>/data/img/1.jpg" />
			<p class="p1">RMB 59</p>
			<a href="">java语言程序设计</a>
			<p class="p2">林永平（卖书人的id）</p>
		</div>
	</div>
	<hr width="2000px">
	<div id="bottom">
		<p class="p3">出品人：李兆坤，林永平，刘孟莹，林泽森</p>
		<br>
		<p class="p3">单位：华南农业大学数学与信息学院15级软件工程1班</p>
	</div>
</body>
</html>