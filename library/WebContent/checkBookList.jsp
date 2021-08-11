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

</div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">图书列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">书号</th>
				<th width="90">书名</th>
				<th width="90">作者</th>
				<th width="90">出版社</th>
				<th width="90">类型</th>
				<th width="90">正在借数量</th>
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
/
</script>
</body>
</html>