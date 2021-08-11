<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.User,java.util.*"%>
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

<title>图书列表</title>
</head>

<body>
	
<div id="content" style="backgraoud-color:white;color:black;" >
<div class="page-container" style="margin-left:35%">
     <form action="searchBookServlet" method="post">
     <select name="search_item">
       <option value="book_id">书号</option>
       <option value="book_name">书名</option>
       <option value="book_author">作者</option>
       <option value="book_publish">出版社</option>
     </select>
		<input type="text" class="input-text" style="width:200px" placeholder="输入..." id="" name="name" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i>搜索</button>
     </form>
</div>
</div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="10">图书列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">书号</th>
				<th width="90">书名</th>
				<th width="90">作者</th>
				<th width="90">出版社</th>
				<th width="90">类型</th>
				<th width="90">已借出数量</th>
				<th width="90">总数量</th>
				<th width="90">被借阅次数</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${book }" var="u">
			<tr class="text-c">
				<td>${u.book_id }</td>
				<td>${u.book_name }</td>
				<td>${u.book_author }</td>
				<td>${u.book_publish }</td>
				<td>${u.book_type }</td>
				<td>${u.book_outNum }</td>
				<td>${u.book_haveNum }</td>
				<td>${u.book_state }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

<script type="text/javascript">
//添加图书
function book_add(title,url,w,h){
	layer_show(title,url,w,h);
}


//删除图书
function book_del(id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax(
				{
					url:'delBookServlet',
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