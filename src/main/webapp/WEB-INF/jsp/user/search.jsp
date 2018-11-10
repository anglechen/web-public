<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div >
		<div id="accordion" class="accordion-style1 panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion" href="#collapseOne"> <i
							class="bigger-110 icon-angle-down"
							data-icon-hide="icon-angle-down"
							data-icon-show="icon-angle-right"></i> &nbsp;查询
						</a>
					</h4>
				</div>

				<div class="panel-collapse in" id="collapseOne"
					style="height: auto;" >
					<form class="form-horizontal" id="search-form" style="margin-top:10px;">
						<div class="form-group" style="height: 32px;">
							<label class="col-sm-1 control-label no-padding-right"
								for="form-field-1"> 姓名 </label>

							<div class="col-sm-5">
								<input type="text" name="userName" id="userName" placeholder="请输入姓名"
									class="col-xs-12 col-sm-12" />
							</div>
							<label class="col-sm-1 control-label no-padding-right"
								for="form-field-1"> 姓别 </label>

							<div class="col-sm-5">
								<select class="form-control" name="sex" id="sex">
									<option value="">请选择</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
						</div>

						<div class="space-4"></div>

						<div class="form-group">
							<label class="col-sm-1 control-label no-padding-right"
								for="form-field-1"> 年龄 </label>

							<div class="col-sm-5">
								<input type="text" name="age" id="age" placeholder=" 年龄 "
									class="col-xs-12" />
							</div>
							<label class="col-sm-1 control-label no-padding-right"
								for="form-field-1"> 备注 </label>

							<div class="col-sm-5">
								<input type="text" name="remarks" id=""remarks""
									placeholder=" 备注 " class="col-xs-12" />
							</div>
						</div>

						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-1 control-label no-padding-right"
								for="form-field-1"> 地址 </label>

							<div class="col-sm-11">
								<input type="text" name="addr" id="addr" placeholder=" 地址 "
									class="col-xs-12" />
							</div>

						</div>
					</form>
					<div style="    clear: both;float: right;margin-bottom: 10px;">
						<button class="btn btn-sm  btn-primary" type="button" id="btn-search">
							<i class="icon-ok bigger-110"></i> 搜索
						</button>
						<button class="btn btn-sm  btn-primary" type="button" id="btn-reset">
							<i class="icon-undo bigger-110"></i> 重置
						</button>
					</div>
				</div>
			</div>

		</div>
</body>
</html>