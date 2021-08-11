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

<title>添加图书详情信息</title>
</head>
<body>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="8">图书列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">书号</th>
				<th width="90">书名</th>
				<th width="90">作者</th>
				<th width="90">出版社</th>
				<th width="90">类型</th>
				<th width="90">已借出数量</th>
				<th width="90">剩余数量</th>
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
</body>
</html>