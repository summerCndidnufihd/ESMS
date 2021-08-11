<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"  import="entity.User,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
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

<title>借阅信息</title>
</head>
<body>
<div class="page-container" style="margin-left:35%">
     <form action="searchUserBorrowBookServlet" method="post">
     <select name="search_item">
       <option value="userQuery">借阅者借阅记录查询</option>
       <option value="bookQuery">书籍借阅记录查询</option>
     </select>
		<input type="text" class="input-text" style="width:200px" placeholder="输入ID..." id="" name="name" >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i>搜索</button>
     </form>
</div>
<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="5">借阅记录</th>
			</tr>
			<tr class="text-c">
				<th width="90">借阅者ID</th>
				<th width="90">书号</th>
				<th width="90">借阅时间</th>
				<th width="90">截止时间</th>
				<th width="90">归还时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${borrow }" var="c">
			<tr class="text-c">
				<td>${c.user_id }</td>
				<td>${c.book_id }</td>
				<td>${c.borrow_start }</td>
				<td>${c.borrow_end }</td>
				<td>${c.borrow_back }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>