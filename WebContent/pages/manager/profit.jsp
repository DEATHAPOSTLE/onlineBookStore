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
		<c:forEach var="list" items="${commoditys}" varStatus="status">
		  商品ID ： ${list.commodityId}
		  商品名称 ： ${list.commodityName}
		  商品类型 ： ${list.commodityType}
		 商品价格 ： ${list.commodityPrice}
		  出版社 ： ${list.commodityPress}
		  作者 ： ${list.commodityAuthor}
		  进价 ： ${list.commodityInPrice}
		  利润 ： ${list.commodityProfit}
		</c:forEach>
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