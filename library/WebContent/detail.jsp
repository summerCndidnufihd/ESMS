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

<%
User user=(User)session.getAttribute("user");
if("error".equals(request.getParameter("message"))){ %>

<script type="text/javascript">
    alert("此书已被借，请选择其他书！");
</script>
<%}else{%>
    <!-- 没有收到任何错误信息 -->
<% }%>
  

<body>
<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">书籍列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">书号</th>
				<th width="90">书名</th>
				<th width="90">作者</th>
				<th width="90">出版社</th>
				<th width="90">类型</th>
				<th width="90">已借出</th>
				<th width="90">总数量</th>
				<th width="90">操作</th>
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
				<td class="td-manage">
				<input type="button" onclick="update_btn(${u.book_id })" value="编辑" />
				<input type="button" onclick="book_del(${u.book_id })" value="删除" />
				<input type="button" onClick="book_borrow(${u.book_id },<%=user.getActor() %>,<%=user.getuBorrow() %>)" value="借阅" />
				</td>
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
//修改
function update_btn(id){
	location.href="recordBookInfoServlet?id="+id;
}

/*借阅图书*/
function book_borrow(id,actor,uBorrow){
	layer.confirm('确认要借阅吗？',function(index){
		$.ajax(
				{
					url:'borrowBookServlet',
					async : false,
		            cache : false,
		            traditional: true,
		            type : 'POST',
					data:{
						id : id,
						actor:actor,
						uBorrow:uBorrow
					},
					success:function(result){
						layer.closeAll();
						
					},
					error:function(result){
						layer.closeAll();
						//layer.msg(result.msg);
					}
				});	
	});
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