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
<%
  User u=(User)request.getAttribute("user");
  request.setCharacterEncoding("utf-8");
  int m=0;
  String actor="";String s="";
  if(u.getActor()==0){
	  m=u.getuMaxBorrow()-u.getuBorrow();
	  if(m<0){
		  s="您借书已达限制！";
	  }else{
		  s=String.valueOf(m);
	  }
	  actor="教师";
  }else{
	  if(u.getActor()==1){
		  m=u.getuMaxBorrow()-u.getuBorrow();
		  if(m<0){
			  s="您借书已达限制！";
		  }else{
			  s=String.valueOf(m);
		  }
		  actor="学生";
	  }else{
		  if(u.getActor()==2){
			  m=u.getuMaxBorrow()-u.getuBorrow();
			  if(m<0){
				  s="您借书已达限制！";
			  }else{
				  s=String.valueOf(m);
			  }
			  actor="其他用户";
		  }else{
			  m=u.getuMaxBorrow()-u.getuBorrow();
			  if(m<0){
				  s="您借书已达限制！";
			  }else{
				  s=String.valueOf(m);
			  }
			  actor="管理员";
		  }
	  }
  }
System.out.print("这是哪。。");
System.out.print(u.getActor());
System.out.print(u);
%>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont"> <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" onclick="update()" href="#" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div>
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
			<tr class="text-c">
				<td><%=u.getuName() %></td>
				<td><%=u.getuPwd() %></td>
				<td><%=u.getuRealName() %></td>
				<td><%=u.getuSex() %></td>
				<td><%=u.getuAge() %></td>
				<td><%=u.getuPhone() %></td>
				<td><%=actor %></td>
				<td><%=u.getuBorrow() %></td>
				<td><%=s%></td>
				<td class="td-manage"> <a title="编辑" href="javascript:;" onclick="update_btn(<%=u.getId() %>)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a></td>
			</tr>
		</tbody>
	</table>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>

<script type="text/javascript">
//修改
function update_btn(id){
	location.href="recordUserInfoServlet?id="+id;
}
//归还
function backBook(id1,id2){
	layer.confirm('确认要归还吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		$.ajax(
				{
					url:'backBookServlet',
					async : false,
		            cache : false,
		            traditional: true,
		            type : 'POST',
					data:{
						id1 : id1,
						id2 : id2
					},
					success:function(result){
						layer.closeAll();
						alert("已归还！");
						//layer.msg('已归还!',{icon: 5,time:1000});
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
//刷新
function update(){
	window.location.reload();
}
</script>
	
</body>
</html>