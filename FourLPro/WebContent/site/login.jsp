<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="type" scope="request" class="java.lang.String" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link type="text/css" href="<%=request.getContextPath()%>/data/css/new-loginV2.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/data/css/page.css" />

</head>
<body>
	<div class="content-layout">
		<div class="login-box-warp">
			<div class="login-box no-longlogin module-static" id="J_LoginBox">
				<div class="bd">
					<div class="static-form" id="J_StaticForm">
						<div class="login-title">密码登录</div>
						<form
							action="/FourLPro/login"
							method="post" id="J_Form">
							<div class="field username-field">
								<label for="TPL_username_1"> 
								<i class="iconfont" title="会员名"></i>
								</label> 
								<input
									type="text" name="username" id="TPL_username_1"
									class="login-text J_UserName" value="会员名/邮箱/手机号" maxlength="32"
									tabindex="1" >
							</div>

							<div class="field pwd-field">
								<label id="password-label" for="TPL_password_1"><i
									class="icon iconfont" title="登录密码"></i></label> 
									<span id="J_StandardPwd"> 
									<input type="password" name="password" id="TPL_password_1" class="login-text"
									maxlength="40" tabindex="2">
									</span>
							</div>
							<div class="submit">
								<button type="submit" class="J_Submit" tabindex="3"
									id="J_SubmitStatic">登 录</button>
							</div>
							<div class="login-links">
								<a
									href="https://passport.taobao.com/ac/password_find.htm?from_site=0&amp;lang=zh_CN&amp;login_id="
									tabindex="6" class="forget-pwd" target="_blank"> 忘记密码</a> <a
									href="http://reg.taobao.com/member/newbie.htm?from=login"
									class="register" target="_blank" tabindex="7">免费注册</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>