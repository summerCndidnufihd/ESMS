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
<c:if test="${!empty user }">
<form action="${ pageContext.request.contextPath}/updateUserInfoServlet" method="post" >
	<table class="table table-border table-bordered table-bg" border="1" style="margin:0 auto" >
		<thead>
			<tr>
				<th scope="col" colspan="9">个人信息</th>
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
				<input type="button" onclick="update_btn('${u.id}')" value="修改" />
				<a title="删除" href="javascript:;" id="${u.id }" onclick="user_del(this.id)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
	</c:if>
</body>
</html>