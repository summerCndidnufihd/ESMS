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

<title>个人信息</title>
</head>
<%
  User u=(User)session.getAttribute("user");
%>
<body>
<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">已借的图书列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">书号</th>
				<th width="90">书名</th>
				<th width="90">作者</th>
				<th width="90">出版社</th>
				<th width="90">类型</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${book }" var="c">
			<tr class="text-c">
				<td>${c.book_id }</td>
				<td>${c.book_name }</td>
				<td>${c.book_author }</td>
				<td>${c.book_publish }</td>
				<td>${c.book_type }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

</body>
</html>