<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.User,entity.Borrow,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
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

<title>借还列表</title>
</head>
<%
  User u=(User)session.getAttribute("user");
  int m=0;
  String actor="";String s="";
  Date end=null;
  System.out.print(u.getuMaxBorrow());
  System.out.print(u.getuBorrow());
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
		  m=u.getuMaxBorrow()-u.getuBorrow();
		  if(m<0){
			  s="您借书已达限制！";
		  }else{
			  s=String.valueOf(m);
		  }
		  actor="其他用户";
	  }
  }
System.out.print("这是哪。。");
System.out.print(u);
%>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 图书借阅 <span class="c-gray en">&gt;</span> 借阅信息 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" onclick="update()" href="#" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">个人信息列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">账户ID</th>
				<th width="40">账户名</th>
				<th width="40">真实姓名</th>
				<th width="50">角色</th>
				<th width="40">已借图书数量</th>
				<th width="40">可借图书数量</th>
			</tr>
		</thead>
		<tbody>
			<tr class="text-c">
				<td><%=u.getId() %></td>
				<td><%=u.getuName() %></td>
				<td><%=u.getuRealName() %></td>
				<td><%=actor %></td>
				<td><%=u.getuBorrow() %></td>
				<td><%=s%></td>
			</tr>
		</tbody>
	</table>
	
<div id="content" style="backgraoud-color:white;color:black;" >

</div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="5">借阅列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">书号</th>
				<th width="90">借阅时间</th>
				<th width="90">截止时间</th>
				<th width="90">归还时间</th>
				<th width="90">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${con }" var="c">
			<tr class="text-c">
				<td>${c.book_id }</td>
				<td>${c.borrow_start }</td>
				<td>${c.borrow_end }</td>
				<td>${c.borrow_back }</td>
				<td class="td-manage">
				<a style="text-decoration:none;"  id="" onClick="backBook(<%=u.getId() %>,${c.book_id })" href="javascript:;" title="归还图书"><i class="Hui-iconfont">归还</i></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!-- 搜索操作 -->
<script type="text/javascript" src="js/search.js"></script>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>  <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.15/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
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
/**
 * 刷新
 */

 function update(){
 	window.location.reload();
 }
</script>
</body>
</html>