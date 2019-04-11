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
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="/" class="maincolor">首页</a> <span class="c-999 en">&gt;</span><span class="c-666">空白页</span></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			售后服务
		</article>
		  <table class="table table-border table-bordered table-striped">
			<thead>
				<tr>
					<th>序号</th>
					<th>商品名称</th>
					<th>商品图片</th>
					<th>商品价格</th>
					
					<th>姓名</th>
					<th>收货地址</th>
					<th>电话号码</th>
					<th>用户类型</th>
					
					<th>订单状态</th>
					<th>下单时间</th>
					<th>订单金额</th>
					
					<th>退货时间</th>
					<th>操作</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rejected" items="${dto}">
		    		<tr>
		    			<td>${((page.pageNo-1)*page.pageSize)+status.count}</td>
		    			<td>${rejected.commodityName}</td>		    			
		    			<td>${rejected.commodityPicture}</td>
		    			<td>${rejected.commodityPrice}</td>
		    			
		    			<td>${rejected.handicappedName}</td>
		    			<td>${rejected.userAddr1}</td>
		    			<td>${rejected.userPhoneNumber}</td>
		    			<td>${rejected.userType}</td>
		    			
		    			<td>${rejected.orderStatus}</td>
		    			<td>${rejected.orderDTime}</td>
		    			<td>${rejected.orderPrice}</td>
		    			
		    			<td>${rejected.rejectedDTime}</td>
		    			<td>
                          <c:if test="${rejected.rejectedStatus eq 1}">
		    			     <span>已同意退货</span>
		    			  </c:if>
		    			  <c:if test="${rejected.rejectedStatus eq 2}">
		    			     <span>已拒绝退货</span>
		    			  </c:if>
		    			  <c:if test="${rejected.rejectedStatus eq 3}">
		    			     <a href="${pageContext.request.contextPath}/rejectedAudit?rejectedId=${rejected.rejectedId}">同意退货</a>
		    			     <a href="${pageContext.request.contextPath}/refuseRejected?rejectedId=${rejected.rejectedId}">拒绝退货</a>
		    			  </c:if>
		    			  <c:if test="${rejected.rejectedStatus eq 4}">
		    			     <span>退货完成</span>
		    			  </c:if>
		    			  <c:if test="${rejected.rejectedStatus eq 5 }">
		    			     <a href="${pageContext.request.contextPath}/meetRejected?rejectedId=${rejected.rejectedId}&requirements=7">满足要求</a>
		    			     <a href="${pageContext.request.contextPath}/meetRejected?rejectedId=${rejected.rejectedId}&requirements=6">不满足要求</a>
		    			  </c:if>
		    			  <c:if test="${rejected.rejectedStatus eq 6}">
		    			     <span>商品不满足退货要求，请将商品寄回买家</span>
		    			  </c:if>
		    			  <c:if test="${rejected.rejectedStatus eq 7}">
		    			     <span>商品满足退货要求，已返款给买家账户</span>
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