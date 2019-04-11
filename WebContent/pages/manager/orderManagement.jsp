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
			订单管理
		</article>
	</div>
	<form role="form" class="form-inline" style="margin-bottom: 15px"  action="searchOrderByIdServlet" method="post">
		<input type="text" placeholder="请输入订单编号" class="input-text radius size-M" style="width: 30%" id="orderId" name="orderId">
		<input class="btn btn-primary radius" type="submit" value="搜索">
	</form>
	    <table class="table table-border table-bordered table-striped">
			<thead>
				<tr>
					<th>订单编号</th>
					<th>商品编号</th>
					<th>金额</th>
					<th>用户ID</th>
					<th>收货人电话</th>
					<th>收货地址</th>
					<th>订单状态</th>
					<th>下单时间</th>
					<th>发货时间</th>
					<th>收货时间</th>
					<th>操作</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
		    		<tr>
		    			<td>${order.orderId}</td>
		    			<td>${order.commodityID}</td>
		    			<td>${order.orderPrice}</td>
		    			<td>${order.userId}</td>
		    			<td><input type="text" class="input-text radius phoneNumber" value="${order.phoneNumber}"></td>
		    			<td><input type="text" class="input-text radius orderAddr" value="${order.orderAddr}"></td>
		    			<td>
		    			<c:if test="${order.orderStatus eq 1 }">
		    			   <span>买家已付款</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 2 }">
		    			   <span>商家已发货</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 3 }">
		    			   <span>买家已确认收货，交易成功</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 4 }">
		    			   <span>退货审核中</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 5 }">
		    			   <span>退货审核通过，等待买家寄回商品</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 6 }">
		    			   <span>退货成功</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 7 }">
		    			   <span>商家拒绝退货</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 8 }">
		    			   <span>退货满足要求，退货成功</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 9 }">
		    			   <span>退货不满足要求，商品寄回客户</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 10 }">
		    			   <span>退货商品已寄出，待审核</span>
		    			</c:if>
		    			
		    			
		    			</td>
		    			
		    			<td>${order.orderDTime}</td>
		    			<td>${order.deliveryDTime}</td>
		    			<td>${order.receiveDTime}</td>
		    			<td>
		    			<c:if test="${order.orderStatus eq 1 }">
		    			<form action="/onlineBookStore/deliverCommodity">
		    				<input type="hidden" value="${order.orderId}" name="orderId">
		    				<a href="#" class="deliverBtn">发货</a>
		    			</form>
		    			   
		    			</c:if>
		    			<c:if test="${order.orderStatus ne 1 }">
		    			   <span>已发货</span>
		    			</c:if>
		    			
		    			</td>
		    			<td>
		    			<form class="editOrder" action="/onlineBookStore/updateOrders">
		    			    <input type="hidden" name="orderId" value="${order.orderId}">
		    				<input type="hidden" name="phoneNumber" class="input-text radius hidePhoneNumber" value="">
		    				<input type="hidden" name="orderAddr" class="input-text radius hideOrderAddr" value="">
		    				<a href="#" class="submitBtn">确认编辑</a>
		    			</form>
		    				
		    			</td>
		    			
		    			
		    		</tr>
				</c:forEach>
			</tbody>
		</table>
	    
</section>

<!--_footer 作为公共模版分离出去-->
<%@ include file="_footer.jsp" %>
<!--/_footer /作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery/1.9.1/jquery.min.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
$(".deliverBtn").on("click", function () {
	$(this).parents("form").submit()
})
$(".submitBtn").on("click", function () {
	var thisRow = $(this).parent().parent().parent()
	var phoneNumber = thisRow.find(".phoneNumber").val()
	var orderAddr = thisRow.find(".orderAddr").val()
	thisRow.find(".hidePhoneNumber").val(phoneNumber)
	thisRow.find(".hideOrderAddr").val(orderAddr)
	if (thisRow.find(".hidePhoneNumber").val() != '' && thisRow.find(".hideOrderAddr").val() != '') {
		$(this).parents("form").submit()		
	} else {
		alert("请输入正确的地址和电话")
	}
})

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>