<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/static/meta.jsp"%>
<%
	Object users = request.getAttribute("users");
%>
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<title>Insert title here</title>
<style type="text/css">
td, th {
	text-align: center;
}
</style>
</head>
<body>
	<div style="margin-bottom: 10px;">
		<button class="btn btn-sm  btn-primary" id="btn-add">
			<i class="icon-ok bigger-50"></i> 新增
		</button>
		<button class="btn btn-sm  btn-primary" id="btn-mod">
			<i class="icon-undo bigger-50"></i> 修改
		</button>
		<button class="btn btn-sm btn-primary" id="btn-del">
			<i class="icon-undo bigger-50"></i> 删除
		</button>
	</div>
	<div id="add" style="display: none;">
		<jsp:include page="add.jsp"></jsp:include>
	</div>
	<div id="search">
		<jsp:include page="search.jsp"></jsp:include>
	</div>
	${users}
	<div style="margin-top: 10px;">
		<table border="1" cellpadding="3" cellspacing="0"
			style="width: 100%; margin: auto" id="userTable">
			<thead>
				<tr>
					<th><input type = "checkbox" class="select-all"></th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>地址</th>
					<th>备注</th>
				</tr>
			</thead>

			<%-- 	<c:forEach items="${users}" var="item">
				<tr>
					<td>${item.userName}</td>
					</td>
					<td><c:if test="${item.sex == 1}">男</c:if> <c:if
							test="${item.sex != 1}">女</c:if></td>
					<td>${item.age}</td>
					<td>${item.addr}</td>
					<td>${item.idcard}</td>
				</tr>
			</c:forEach> --%>


		</table>
	</div>


	<script type="text/javascript">
		$(function(){
			<%-- alert("<%=users %>"); --%>
			var users = "${users}";
			
			var userTable = $('#userTable').DataTable( {
		        /* "data": users, */
		        "ajax":{
		        	"url":"<%=basePath%>/users/list",
		        	"data":function(){
		        		var data =  getFormData("#search-form");
		        		data.tdata = true;
		        		return data;
		        	},
		        	/* "data":{
		        		"tdata":"true"
		        	} */
		        },
		        "dom": 'rtip',
		        "columns": [
		        	{ "data": "" ,
		        		render : function(data, type, row, meta) {  
		                    // 显示行号  
		                    return "<input type='checkbox' value="+ row.id+">";
		                }  
		        	},
		            { "data": "account" ,
		            	render : function(data, type, row, meta) {  
		                    // 显示行号  
		                    if(row.account)return row.account;
		                    return "";
		                } 
		        	},
		            { "data": "sex",
		            	render : function(data, type, row, meta) {  
		                    // 显示行号  
		                    if(row.sex == 1)return '男';
		                    return "女";
		                } 
		            },
		            { "data": "age" ,
		            	render : function(data, type, row, meta) {  
		                    // 显示行号  
		                    if(row.age)return row.age;
		                    return "";
		                }  
		            },
		            { "data": "addr" ,
			            	render : function(data, type, row, meta) {  
			                    // 显示行号  
			                    if(row.addr)return row.addr;
			                    return "";
			                } 
		                },
		            { "data": "remarks"  ,
		            	render : function(data, type, row, meta) {  
		                    // 显示行号  
		                    if(row.remarks)return row.remarks;
		                    return "";
		                }
			         }
		        ],
		        columnDefs: [ {
		            orderable: false,
		            className: 'select-checkbox',
		            targets:   0
		            
		        } ],
		        select: {
		            style:    'os',
		            selector: 'td:first-child'
		        },
		        order: [[ 1, 'asc' ]],
		        "oLanguage": {//国际语言转化
	                   "oAria": {
	                       "sSortAscending": " - click/return to sort ascending",
	                       "sSortDescending": " - click/return to sort descending"
	                   },
	                   "sLengthMenu": "显示 _MENU_ 记录",
	                   "sZeroRecords": "对不起，查询不到任何相关数据",
	                   "sEmptyTable": "未有相关数据",
	                   "sLoadingRecords": "正在加载数据-请等待...",
	                   "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
	                   "sInfoEmpty": "当前显示0到0条，共0条记录",
	                   "sInfoFiltered": "（数据库中共为 _MAX_ 条记录）",
	                   "sProcessing": "<img src='../resources/user_share/row_details/select2-spinner.gif'/> 正在加载数据...",
	                   "sSearch": "模糊查询：",
	                   "sUrl": "",
	                   //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
	                   "oPaginate": {
	                       "sFirst": "首页",
	                       "sPrevious": " 上一页 ",
	                       "sNext": " 下一页 ",
	                       "sLast": " 尾页 "
	                   }
	               },
	 
		    } );
			
			$("#btn-search").on("click",function(){
				userTable.ajax.reload();
			})
			$("#btn-reset").on("click",function(){
				$("#search-form")[0].reset();
			})
			
			
			$("#btn-del").on("click",function(){
				var selects = $("#userTable tr td input:checked");
				var rs = [];
				for(var i = 0 ; i < selects.length; i++){
					rs.push(selects[i].value);
				}
				//发删除请求
				 $.ajax({
					 url:"<%=basePath%>/user",
					 type:"delete",
					 data:{
						 ids:rs.toString()
					 },
					 success:function(data){
						 layer.msg("删除成功！");
						 userTable.ajax.reload();
					 }
				})
			})
			
			$("#btn-add").on("click",function(){
				layer.open({
					  type: 1,
					  skin: 'layui-layer-rim', //加上边框
					  area: ['800px', '300px'], //宽高
					  content: $("#add"),
					  btn: ['保存', '取消'], //可以无限个按钮
					  yes:function(index, layero){
						  debugger
						 var data =  getFormData("#add-form");
						 
						 if(!validForm("#add-form")){
							 layer.msg("内容不能为空！");
							 return;
						 }
						 $.ajax({
							 url:"<%=basePath%>/users/add",
							 async:false,
							 type:"post",
							 data:data,
							 success:function(data){
								 layer.msg("保存成功！");
								 userTable.ajax.reload();
							 }
						 })
						 layer.close(index);
					  },
					});
			})
		
		//修改
		$("#btn-mod").on("click",function(){
			var selects = $("#userTable input:checked");
			
			if(selects.length > 1 || selects.length == 0){
				layer.msg("只能选择一个进行修改！");
				return false;
			}
			 var sdata = userTable.row($($("#userTable input:checked").parents("tr"))).data();
				layer.open({
					  type: 1,
					  skin: 'layui-layer-rim', //加上边框
					  area: ['800px', '300px'], //宽高
					  content: $("#add"),
					  btn: ['保存', '取消'], //可以无限个按钮
					  success:function(layero, index){
						  
						 
						  $("#add-form #userName").val(sdata.userName);
						  $("#add-form #sex").val(sdata.sex);
						  $("#add-form #age").val(sdata.age);
						  $("#add-form #addr").val(sdata.addr);
						  $("#add-form #idcard").val(sdata.idcard);
					  },
					  yes:function(index, layero){
						 var data =  getFormData("#add-form");
						 data.id = sdata.id;
						 if(!validForm("#add-form")){
							 layer.msg("内容不能为空！");
							 return;
						 }
						 $.ajax({
							 url:"<%=basePath%>/user",
							 async:false,
							 type:"PUT",
							 data:data,
							 success:function(data){
								 layer.msg("修改成功！");
								 userTable.ajax.reload();
							 }
						 })
						 layer.close(index);
					  },
					});
			})
			
		function getFormData(id){
			 var d = {};
			 var t = $(id).serializeArray();
			 $.each(t, function() {
			      d[this.name] = this.value;
			 });
			 return d;
		}
			
		function validForm(id){
			var flag = true;
			var inputs = $(id).find("input,select");
			inputs.each(function(index,element){
				if($(this).val() == ""){
					flag = false;
					return flag;
				}
			})
			return flag;
		}
		
		$(".select-all").on("click",function(){
			$("#userTable tr td input[type=checkbox]").each(function(){
				$(this).click();
			});
		})
	})
	</script>
</body>
</html>