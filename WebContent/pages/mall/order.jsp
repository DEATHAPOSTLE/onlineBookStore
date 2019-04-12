<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>图书商城</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/style.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="#" target="_blank">图书商城</a></li>
						<li>|</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a href="./login.html" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="./register.html" target="_blank" >注册</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
	<a href="./index.html" target="_blank"><div class="ad_top fl"></div></a>
	<div class="nav fl">
		<ul>
			<li><a href="./liebiao.html" target="_blank">图书</a></li>
			<li><a href="">图书</a></li>
			<li><a href="">图书</a></li>
			<li><a href="">图书</a></li>
			<li><a href="">图书</a></li>
		</ul>
	</div>
	<div class="search fr">
		<form action="" method="post">
			<div class="text fl">
				<input type="text" class="shuru"  placeholder="">
			</div>
			<div class="submit fl">
				<input type="submit" class="sousuo" value="搜索"/>
			</div>
			<div class="clear"></div>
		</form>
		<div class="clear"></div>
	</div>
</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.html">我的个人中心</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr" style="height: auto">
			<div class="ddzxbt">交易订单</div>
			<div class="ddxq">
			
			 <c:forEach var="orders" items="${ordersList}" varStatus="status">
				<div class="ddspt fl"><img src="./image/gwc_xiaomi6.jpg" alt=""></div>
				<div class="ddbh fl">订单号:${orders.orderId}</div>
				<div class="ztxx fr">
					<ul>
					    <li>${orders.orderPrice}</li>
					    <li>${orders.phoneNumber}</li>
					    <li>${orders.orderAddr}</li>
						<li>${orders.orderDTime}</li>
						<li>${orders.deliveryDTime}</li>
						<li>${orders.receiveDTime}</li>
						<li>
                        <c:if test="${orders.orderStatus eq 1 }">
		    			   <span>买家已付款</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 2 }">
		    			   <span>商家已发货</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 3 }">
		    			   <span>买家已确认收货，交易成功</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 4 }">
		    			   <span>退货审核中</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 5 }">
		    			   <span>退货审核通过，请寄出商品至店家，并点击寄出</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 6 }">
		    			   <span>退货成功</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 7 }">
		    			   <span>商家拒绝退货</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 8 }">
		    			   <span>满足退货要求，退货成功，金钱将在1-7个工作日返回账户</span>
		    			</c:if>
		    		    <c:if test="${orders.orderStatus eq 9 }">
		    			   <span>不满足退货要求，商品将被寄回至您的发货地址</span>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 10 }">
		    			   <span>退货商品已寄出，待审核</span>
		    			</c:if>
                        </li>
						<li>
						<c:if test="${orders.rejectedStatus eq 1 }">
		    			   <a href="${pageContext.request.contextPath}/rejected?orderId=${orders.orderId}">退货</a>
		    			</c:if>
		    			<c:if test="${orders.orderStatus eq 2 }">
		    			   <a href="${pageContext.request.contextPath}/receivingShop?orderId=${orders.orderId}">确认收货</a>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 2 }">
		    			   <span>已超过七天，不允许退货</span>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 3 }">
		    			   <span>退货正在审核中，请耐心等待……</span>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 4 }">
		    			   <span>同意退货，在寄出商品后，请点击寄回按钮</span>
		    			   <a href="${pageContext.request.contextPath}/sendreJected?orderId=${orders.orderId}">已寄回</a>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 5 }">
		    			   <span>商家拒绝退货，请联系残联或拨打客服电话</span>
		    			   <a href="#">残联页面</a>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 6 }">
		    			   <span>退货商品已寄出，正在审核。</span>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 7 }">
		    			   <span>满足退货要求，将会在1-7个工作日将钱返回您的账户</span>
		    			</c:if>
		    			<c:if test="${orders.rejectedStatus eq 8 }">
		    			   <span>不满足退货要求，您的商品将会被寄回您的地址，或与客服协商。</span>
		    			</c:if>
						</li>
						<li>
						 <c:if test="${orders.rateStatus eq 1 }">
                            <a href="commentServlet?commodityId=${orders.commodityID}&orderId=${orders.orderId}">评价</a>
                           </c:if>
                            <c:if test="${orders.rateStatus eq 0 }">
                            <span>已评价</span>
                           </c:if>
						</li>
						<div class="clear"></div>
					</ul>
				 </c:forEach>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
<footer class="mt20 center">			
	<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
</footer>
	</body>
</html>