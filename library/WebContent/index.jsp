<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="UTF-8" import="entity.User"%>
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
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

<title>主页面</title>
</head>
<%
  User u=(User)session.getAttribute("user");
%>
<body>
<div class="top">
  <img src="images/top.jpg" alt="" width="100%" height="580"/>
</div>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont"></i> 查看图书<i class="Hui-iconfont menu_dropdown-arrow">></i></dt>
			<dd>
				<ul>
					<li><a data-href="bookUserServlet" data-title="查看图书"  href="javascript:void(0)" >查看图书</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont"></i> 图书借还<i class="Hui-iconfont menu_dropdown-arrow">></i></dt>
			<dd>
				<ul>
					<li><a data-href="continueBookServlet" data-title="归还图书" href="javascript:void(0)">归还图书</a></li>
					
			</ul>
		</dd>
	</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont"></i> 借阅记录<i class="Hui-iconfont menu_dropdown-arrow">></i></dt>
			<dd>
				<ul>
					<li><a data-href="borrowInfoServlet" data-title="查看借阅记录" href="javascript:void(0)">查看借阅记录</a></li>
					<li><a data-href="borrowBookList" data-title="查看借书列表" href="javascript:void(0)">查看借书列表</a></li>
					
			</ul>
		</dd>
	</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont"></i> 个人设置<i class="Hui-iconfont menu_dropdown-arrow">></i></dt>
			<dd>
				<ul>
					<li><a data-href="searchInfoServlet" data-title="查看个人信息" href="javascript:void(0)">查看个人信息</a></li>
					
			</ul>
		</dd>
	</dl>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="主页" data-href="welcome.jsp">主页</span>
					<em></em></li>
		</ul>
	</div>
	<div class="Hui-tabNav-more btn-group">
		<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a>
		<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
	</div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe id="iframe-welcome" data-scrolltop="0" scrolling="yes" frameborder="0" src="welcome.html"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
	</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
	/*$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}
			},
			'closeall': function(t) {
				alert('Trigger was '+t.id+'\nAction was Email');
			},
		}
	});*/
});
/*个人信息*/
function myselfInfo(title,url,id){
	$.ajax(
			{
				url:'myselfInfoServlet',
				async : false,
	            cache : false,
	            traditional: true,
	            type : 'POST',
				data:{
					id : id
				},
				success:function(result){
					
				},
				error:function(result){
					//layer.closeAll();
					//layer.msg(result.msg);
				}
			});	
	//window.location.reload();//刷新父级页面
}
//续借图书
function continueBook(title,url,id){
	//layer_show(title,url,w,h);
	$.ajax(
			{
				url:'continueBookServlet',
				async : false,
	            cache : false,
	            traditional: true,
	            type : 'POST',
				data:{
					id : id
				},
				success:function(result){
					
				},
				error:function(result){
					//layer.closeAll();
					//layer.msg(result.msg);
				}
			});	
	//window.location.reload();//刷新父级页面
}
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

</script>
</body>
</html>
