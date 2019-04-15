<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="./index" class="maincolor">首页</a> <span class="c-999 en">&gt;</span><span class="c-666">安全审核</span></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			安全审核
		</article>
		<table class="table table-border table-bordered table-striped">
			<thead>
				<tr>
					<th>审核编号</th>
					<th>商品名称</th>
					<th>商品图片</th>
					<th>商品类型</th>
					<th>商品价格</th>
					<th>商品介绍</th>
					<th>作者</th>
					<th>出版社</th>
					<th>审核步骤</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
		    		<tr>
		    			<td>${list.examineId}</td>
		    			<td>${list.commodityName}</td>
		    			<td>${list.commodityPicture}</td>
		    			<td>${list.commodityType}</td>
		    			<td>${list.commodityPrice}</td>
		    			<td>${list.commodityIntroduce}</td>
		    			<td>${list.commodityPress}</td>
		    			<td>${list.commodityAuthor}</td>
		    			
		    			<td>
		    			<c:if test="${list.commodityExamine eq 1 }">
		    			   <span>审核通过</span>
		    			</c:if>
		    			<c:if test="${list.commodityExamine eq 2 }">
		    			   <span>审核不通过</span>
		    			</c:if>
		    			<c:if test="${list.commodityExamine eq 3 }">
		    			   <span>待审核</span>
		    			</c:if>
		    			
		    			</td>
		    			<td>
		    			<c:if test="${list.commodityExamine eq 3 }">
		    			<a href="${pageContext.request.contextPath}/adoptAudit?id=${list.examineId}">审核通过</a>
		    			<a href="${pageContext.request.contextPath}/refuseAudit?id=${list.examineId}">审核不通过</a>

		    			   
		    			</c:if>
		    			<c:if test="${list.commodityExamine ne 3 }">
		    			   <span>已审核</span>
		    			</c:if>
		    			
		    			</td>
		    			
		    			
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