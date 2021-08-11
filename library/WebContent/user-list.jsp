<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"  import="entity.User,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head >

<meta charset="utf-8" >
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />

<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

<title>个人信息</title>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 借阅者管理 <span class="c-gray en">&gt;</span> 借阅者列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="userListServlet" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container" style="margin-left:35%">
     <form action="searchUserServlet" method="post">
     <select name="search_item">
       <option value="id">用户ID</option>
       <option value="uName">用户名</option>
     </select>
		<input type="text" class="input-text" style="width:200px" placeholder="输入..." id="" name="name" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i>搜索</button>
     </form>
</div>

<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a href="javascript:;" onclick="user_add('添加借阅者','addUser.jsp','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加借阅者</a></span> </div>	
<span>0代表教师        1代表学生       2代表其他用户</span>

<div>
<table class="table table-border table-bordered table-bg" border="1" style="margin:0 auto" >
		<thead>
			<tr>
				<th scope="col" colspan="11">个人信息</th>
			</tr>
			<tr class="text-c">
				<th width="40">用户ID</th>
				<th width="40">用户名</th>
				<th width="40">用户密码</th>
				<th width="40">真实姓名</th>
				<th width="40">性别</th>
				<th width="40">年龄</th>
				<th width="40">电话</th>
				<th width="50">角色</th>
				<th width="40">已借阅图书数量</th>
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
				<input type="button" onclick="user_del(${u.id})" value="删除" />
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>

<script type="text/javascript">
function user_add(title,url,w,h){
	layer_show(title,url,w,h);
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

function update(){
	window.location.reload();
}
</script>
	
</body>
</html>