<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 忽略el表达式 servlet 3.0 默认会忽略  -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/static/meta.jsp"%>
<title>首頁</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- basic styles -->
<link href="<%=basePath%>/static/ace/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=basePath%>/static/ace/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="<%=basePath%>/static/ace/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=basePath%>/static/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="<%=basePath%>/static/ace/assets/css/ace-skins.min.css" />
</head>
<body>
	<div class="navbar navbar-default" id="navbar">


		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> 后台管理系统
				</small>
				</a>
			</div>
			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="<%=basePath%>/static/ace/assets/avatars/user.jpg"
							alt="Jason's Photo" /> <span class="user-info"> <small>欢迎光临,</small>
								<%-- <%=session.getAttribute("name") %> --%>
								<!-- session范围查找 -->
								<%-- ${ sessionScope.name } --%>
								${name}
								<%--${name } --%><!-- 自动在 page request session application 范围查找属性 -->
								
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="icon-cog"></i> 设置
							</a></li>

							<li><a href="#"> <i class="icon-user"></i> 个人资料
							</a></li>

							<li class="divider"></li>

							<li><a href="#" class="logOut"> <i class="icon-off "></i> 退出
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active" id="user"><a href="#"> <i
							class="icon-dashboard"></i> <span class="menu-text"> 用戶管理
						</span>
					</a></li>
				</ul>
				<!-- /.nav-list -->
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li class="active">控制台</li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">
					<%-- <jsp:include page="user/user.jsp"></jsp:include> --%>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<script type="text/javascript" src="<%=basePath %>/static/ace/assets/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>/static/ace/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/static/layer/layer.js"></script>
	<%-- 	<script src="<%=basePath %>/static/ace/assets/js/typeahead-bs2.min.js"></script>

 --%>

	<script type="text/javascript">
		$(function() {
			$("#user").on("click", function() {
				$.ajax({
					url:"<%=basePath%>/user/index",
					success:function(data){
						$(".page-content").html(data);
					}
				})
			})
			$("#user").click();
			
			$(".logOut").on("click",function(){
				$.ajax({
					url:"<%=basePath%>/login",
					type:"GET",
					success:function(data){
						if(data.loginOut == "success"){
							window.location = "login.jsp";
						}
					}
				})
			});
		})
	</script>

	</div>
</body>
</html>

