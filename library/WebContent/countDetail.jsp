<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="entity.User,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>详情页</title>


<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
</head>

<body>
<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="10">统计列表</th>
			</tr>
			
		</thead>
		<tbody>
		<c:forEach items="${num }" var="u">
			<tr class="text-c">
				<c:forEach var="entry" items="${u}">
				    <td> <c:out value="${entry.key}"/></td>
				   <td><c:out value="${entry.value}"/></td>
				  </c:forEach>
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


</script>
</body>
</html>