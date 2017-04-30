<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>华农二手书交易平台</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/data/js/jquery.js"></script>
<script type="text/javascript">
	$(function() { //这里功能是鼠标移到second_caterogy1,会显示activity_category1（详细的菜单）的内容
		$('.activity_caterogy1').hide();
		$('.second_category1').mousemove(function() {
			$('.activity_caterogy1').show();
		}).mouseout(function() {
			$('.activity_caterogy1').hide();
		});
	});
	
	$(function() {
		$('.activity_caterogy2').hide();
		$('.second_category2').mousemove(function() {
			$('.activity_caterogy2').show();
		}).mouseout(function() {
			$('.activity_caterogy2').hide();
		});
	});
	$(function() {
		$('.activity_caterogy3').hide();
		$('.second_category3').mousemove(function() {
			$('.activity_caterogy3').show();
		}).mouseout(function() {
			$('.activity_caterogy3').hide();
		});
	});
	/*图片滚动效果*/
	var speedpic = 20;//速度数值越大速度越慢
	document.getElementById("advertise2").innerHTML = document
			.getElementById("advertise1").innerHTML;
	function Marqueepic() {
		if (document.getElementById("advertise2").offsetWidth
				- document.getElementById("advertise").scrollLeft <= 0) {
			document.getElementById("advertise").scrollLeft -= document
					.getElementById("advertise1").offsetWidth;
		} else {
			document.getElementById("advertise").scrollLeft++;
		}
	}
	var MyMarpic = setInterval(Marqueepic, speedpic);
	document.getElementById("advertise").onmouseover = function() {
		clearInterval(MyMarpic);
	}
	document.getElementById("advertise").onmouseout = function() {
		MyMarpic = setInterval(Marqueepic, speedpic);
	}
</script>
<style type="text/css">
#box {
	width: 1200px;
	margin: auto;
}

#list {
	width: 200px;
	height: 600px;
	float: left;
	background-color: #add8e6;
}

#advertise {
	width: 750px;
	height: 300px;
	float: left;
	overflow: hidden;
	margin: 0 auto;
}

#hot {
	width: 235px;
	height: 600px;
	background-color: #66cdaa;
	float: right;
}

#forgreen {
	width: 750px;
	height: 290px;
	float: top;
	background-image: url("<%=request.getContextPath()%>/data/img/bg.jpg");
}

.category {
	font-size: 15px;
	color: #696969;
}

.second_category1 {
	font-size: 15px;
}

.activity_caterogy1 {
	font-size: 15px;
}

.second_category2 {
	font-size: 15px;
}

.activity_caterogy2 {
	
}

.second_category3 {
	
}

.activity_caterogy3 {
	
}

h3 {
	color: #556b2f;
	font-size: 20px;
}

.p1 {
	text-align: center;
	font-size: 10px;
}

.picutre_many img {
	width: 750px;
	height: 300px;
}
</style>
</head>
<%!
	String path = null;
%>
<% 
	path = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
%>
<body>
	<div id="box">
		<table border="0" width="1200px" align="center"
			style="background-color: #F0FFF0">
			<tr>
				<td width="60%"><a href="http://www.baidu.com" target="_blank">首页</a></td>
				<td width="10%"><a href="http://www.baidu.com" target="_blank">注册</a></td>
				<td width="10%"><a
					href="<%=path%>/site/login.jsp" target="_blank">登录</a></td>
			</tr>
		</table>
	</div>
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

	<div id="list">
		<h2>图书分类</h2>
		<div class="category">
			<h3>教育</h3>
			<div class="second_category1">
				<div class="activity_caterogy1">
					<jsp:include page="printClassesDetail.jsp">
					<jsp:param name="className" value="教育"></jsp:param>
					</jsp:include>
				</div>
				<h4>
					<a href="">理学类</a>
				</h4>
			</div>
			<div class="second_category3">
				<div class="activity_caterogy3">
					<table width="150px" height="50px" border="1" align="right">
						<tr>
							<td><a href="">xx</a></td>
							<td><a href="">xx</a></td>
						</tr>
						<tr>
							<td><a href="">xx</a></td>
							<td><a href="">xx</a></td>
						</tr>
					</table>
				</div>
				<h4>
					<a href="">医学类</a>
				</h4>
			</div>
			<h3>小说</h3>
			<div class="second_category2">
				<h4>
					<a href="">中国小说</a>
				</h4>
				<div class="activity_caterogy2">
					<h3>test2</h3>
				</div>
				<h4>
					<a href="">外国小说</a>
				</h4>
			</div>
			<h3>生活</h3>
			<div class="second_category">
				<h4>
					<a href="">美食</a>
				</h4>
				<h4>
					<a href="">旅游</a>
				</h4>
			</div>
			<h3>科技</h3>
			<div class="second_category">
				<h4>
					<a href="">计算机</a>
				</h4>
				<h4>
					<a href="">科普</a>
				</h4>
			</div>
		</div>
	</div>
	<div id="advertise" class="picutre_many" style="overflow: hidden">
		<table cellspacing="0" cellpadding="0"
			style="width: 650px; border: 0px;">
			<tr>
				<td id="advertise1">
					<table style="border: 0px;" cellpadding="0" cellspacing="0">
						<tr id="pic">
							<td><img style="border: 0px;" alt=""
								src="<%=path%>/data/img/1.jpg" /></td>
							<td><img style="border: 0px;" alt=""
								src="<%=path%>/data/img/cat.jpg" /></td>
							<td><img style="border: 0px;" alt=""
								src="<%=path%>/data/img/1.jpg" /></td>
							<td><img style="border: 0px;" alt=""
								src="<%=path%>/data/img/cat.jpg" /></td>
							<td><img style="border: 0px;" alt=""
								src="<%=path%>/data/img/1.jpg" /></td>
						</tr>
					</table>
				</td>
				<td id="advertise2"></td>
			</tr>
		</table>
	</div>

	<div id="hot">
		<h2>热卖推荐hot</h2>
		<ol>
			<li><a href="">java程序语言设计</a></li>
			<li><a href="">我只爱学习java</a></li>
			<li><a href="">java程序语言设计</a></li>
			<li><a href="">java程序语言设计</a></li>
			<li><a href="">java程序语言设计</a></li>
			<li><a href="">java程序语言设计</a></li>
		</ol>
	</div>
	<div id="forgreen">
		<p class="p1">你知道吗，每年都有xxxx棵树被砍伐。其中，每年有xxxx树会用作制作书籍。（我没网查具体数据了）</p>
		<br>
		<p class="p1">买一本二手书，就拯救了xx棵树；把用不到的二手书卖给需要的人，也在拯救树木。</p>
		<p class="p1">我觉得我们课设的题目选的很好，所以想在这一块加个学校照片的背景，配上大概这样的文字。图不知道为什么又没显示，先这样。</p>
	</div>
	<hr width="2000px">
	<div id="bottom">
		<p class="p1">出品人：李兆坤，林永平，刘孟莹，林泽森</p>
		<br>
		<p class="p1">单位：华南农业大学数学与信息学院15级软件工程1班</p>
	</div>
</body>
</html>

