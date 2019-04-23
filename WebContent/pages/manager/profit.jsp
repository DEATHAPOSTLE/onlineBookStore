<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="_meta.jsp" %>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>达达图书商城后台系统</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<%@ include file="_header.jsp" %>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<%@ include file="_menu.jsp" %>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="./index" class="maincolor">首页</a> <span class="c-999 en">&gt;</span><span class="c-666">销售利润</span></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			销售利润
		</article>
		<table class="table table-border table-bordered table-striped">
			<thead>
				<tr>
					<th>商品ID</th>
					<th>商品名称</th>
					<th>商品类型</th>
					<th>商品价格</th>
					<th>出版社</th>
					<th>作者</th>
					<th>进价</th>
					<th>利润</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${commoditys}" varStatus="status">
					<tr>
						<td>${list.commodityId}</td>
						<td>${list.commodityName}</td>
						<td>${list.commodityType}</td>
						<td>${list.commodityPrice}</td>
						<td>${list.commodityPress}</td>
						<td>${list.commodityAuthor}</td>
						<td>${list.commodityInPrice}</td>
						<td>${list.commodityProfit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<%@ include file="_footer.jsp" %>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>