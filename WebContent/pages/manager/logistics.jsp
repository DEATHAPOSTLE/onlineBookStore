<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="_meta.jsp"%>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script><![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>达达图书商城后台系统</title>
</head>
<body>
	<!--_header 作为公共模版分离出去-->
	<%@ include file="_header.jsp"%>
	<!--/_header 作为公共模版分离出去-->

	<!--_menu 作为公共模版分离出去-->
	<%@ include file="_menu.jsp"%>
	<!--/_menu 作为公共模版分离出去-->

	<section class="Hui-article-box">
		<nav class="breadcrumb">
			<i class="Hui-iconfont"></i> <a href="/" class="maincolor">首页</a> <span
				class="c-999 en">&gt;</span><span class="c-666">商品上下架</span>
		</nav>

		<div>
			<table class="table table-border table-bordered table-striped">
				<tr>
					<th>商品序号</th>
					<th>商品名称</th>
					<th>商品种类</th>
					<th>商品价格</th>
					<th>商品介绍</th>
					<th>商品剩余数量</th>
					<th>商品评价</th>
					<th>商品上/下架</th>
					<th>商品供货</th>

				</tr>
				<c:forEach var="commodity" items="${allList}" varStatus="status">
					<tr>
						<td>${((page.pageNo-1)*page.pageSize)+status.count}</td>
						<td>${commodity.commodityName}</td>
						<td>${commodity.commodityType}</td>
						<td>${commodity.commodityPrice}</td>
						<td>${commodity.commodityIntroduce}</td>
						<td>${commodity.commoditySurplus}</td>
						<td>${commodity.commodityRate}</td>
						<td><c:if test="${commodity.commodityShelves eq 1 }">
								<a
									href="${pageContext.request.contextPath}/shelves?shopId=${commodity.commodityId}&shelves=1">下架</a>
							</c:if> <c:if test="${commodity.commodityShelves eq 2 }">
								<a
									href="${pageContext.request.contextPath}/shelves?shopId=${commodity.commodityId}&shelves=2">上架</a>
							</c:if></td>
						<td>
							<form action="./updateCommodity">
								<span> <a href="#" class="updateBtn">供货</a> <input
									class="form-control" style="height: 18px; width: 40px;"
									type="number" value="0" name="number">件
								</span> <input type="hidden" name="shopId"
									value="${commodity.commodityId}">
							</form>
						</td>


					</tr>

				</c:forEach>
			</table>

		</div>
	</section>




	<!--_footer 作为公共模版分离出去-->
	<%@ include file="_footer.jsp"%>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript">
$(".updateBtn").on("click", function () {
	if ($(this).next().val() == '') {
		alert("请输入不为0的数字")
		return
	} else {
		$(this).parents("form").submit()
	}
	
})
</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>