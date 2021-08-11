<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />

<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

<title>详情信息</title>
</head>
<body>
	<table class="table table-border table-bordered table-bg" border="1" style="margin:0 auto" >
		<thead>
			<tr>
				<th scope="col" colspan="10">个人信息</th>
			</tr>
			<tr class="text-c">
				<th width="40">用户名</th>
				<th width="40">用户密码</th>
				<th width="40">真实姓名</th>
				<th width="40">性别</th>
				<th width="40">年龄</th>
				<th width="40">电话</th>
				<th width="50">角色</th>
				<th width="40">已借阅图书数量</th>
				<th width="40">可借图书数量</th>
				<th width="40">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${user }" var="u">
			<tr class="text-c">
				<td>${u.id }</td>
				<td>${u.uName }</td>
				<td>${u.uPwd }</td>
				<td>${u.uRealName }</td>
				<td>${u.uSex }</td>
				<td>${u.uAge }</td>
				<td>${u.uPhone }</td>
				<td>${u.actor }</td>
				<td>${u.uBorrow }</td>
				<td class="td-manage"> 
				<input type="button" onclick="update_btn(${u.id })" value="编辑" />
				<input type="button" onclick="user_del(${u.id })" value="删除" />
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">	
//修改
function update_btn(id){
	location.href="recordUserInfoServlet?id="+id;
}

	//删除
function user_del(id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax(
				{
					url:'delUserServlet',
					async : false,
		            cache : false,
		            traditional: true,
		            type : 'POST',
					data:{
						id : id
					},
					success:function(result){
						layer.closeAll();
						layer.msg('已删除!',{icon: 5,time:1000});
						window.location.reload();刷新父级页面
						var index = layer.getFrameIndex(window.name); //获取当前页面索引
						layer.close(index); //关闭当前页面
					},
					error:function(result){
						layer.closeAll();
						//layer.msg(result.msg);
					}
				});	
	});
}
</script>
</body>
</html>