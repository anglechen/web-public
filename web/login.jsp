<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/static/meta.jsp" %>
<% 
	Object error = request.getAttribute("error");
	String strError = "";
	if(error != null)strError = error.toString();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>欢迎登录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/login/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/login/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/login/css/component.css" />
<!--[if IE]>
	<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎登录</h3>
						<form action="<%=basePath %>/login" name="loginForm" id="loginForm" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name=name id="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2" ><a class="act-but submit" id="submit" href="javascript:;" style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="<%=basePath %>/static/login/js/TweenLite.min.js"></script>
		<script src="<%=basePath %>/static/login/js/EasePack.min.js"></script>
		<script src="<%=basePath %>/static/login/js/rAF.js"></script>
		<script src="<%=basePath %>/static/login/js/demo-1.js"></script>
		<script type="text/javascript" src="<%=basePath %>/static/ace/assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>/static/layer/layer.js"></script>
		<script type="text/javascript">
			function preSubmit(){
				var name = $("#name").val();
				var password = $("#password").val();
				if(!name || !password){
					return false;
				}
				return true;
			}
			
			$(function(){
				if( "<%=error%>" != "null"){
					layer.msg("<%=strError%>");
					<%
						error = null;
					%>
				}
				$("#submit").on("click",function(){
					if(preSubmit()){
						$("#loginForm").submit();
					}else{
						alert("用户名或密码不能为空");
					}
					
				})
			})
		</script>
		
</body>
</html>