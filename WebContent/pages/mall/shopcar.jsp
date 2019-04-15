<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="order by dede58.com" />
<title>我的购物车</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/mall/css/style.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/mall/css/bootstrap.css">
</head>
<body>
	<!-- start header -->
	<!--end header -->

	<!-- start banner_x -->
	<div class="banner_x center">
		<a href="./index"><div class="ad_top fl"></div></a>

		<div class="wdgwc fl ml40">我的购物车</div>
		<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
		<div class="dlzc fr">
			<c:if test="${sessionScope.user_information.userName == null}">

				<ul>
					<li><a href="./login">登录</a></li>
					<li>|</li>
					<li><a href="./register">注册</a></li>
				</ul>
			</c:if>
			<c:if test="${sessionScope.user_information.userName != null}">

				<ul>
					<li><a href="./userInformation">欢迎，${sessionScope.user_information.userName}</a></li>
					<li>|</li>
					<li><a href="./logOut">退出登录</a></li>
				</ul>
			</c:if>

		</div>
		<div class="clear"></div>
	</div>


	<div class="xiantiao"></div>
	<div class="gwcxqbj" style="height: auto;">
		<div class="gwcxd center">
			<table class="table table-hover">
				<thead>
					<td></td>
					<td>商品名称</td>
					<td>商品图片</td>
					<td>商品剩余数量</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计</td>
					<td>操作</td>
				</thead>
				<tbody>
				<c:forEach var="shopCar" items="${shopCart}" varStatus="status">
					<tr>
						<td><input type="checkbox"></td>
						<td>
							<a href="#">${shopCar.commodityName}</a>
						</td>
						<td>
							<img
								src="${pageContext.request.contextPath}/images/${shopCar.commodityPicture}"
								alt="" / style="width: 30px; height: 30px;display: block">
						</td>

						<td>${shopCar.commoditySurplus}</td>
						<td>￥${shopCar.commodityPrice}元</td>
						<td>${shopCar.commodityNumber}件</td>
						<td></td>
						<td>
							<a href="./delShopingCar?shopId=${shopCar.shoppingCartId}">删除</a>
							<!-- <form action="${pageContext.request.contextPath}/pay">
								<input type="hidden" value="${shopCar.commodityId}" name="shopId">
								<input type="hidden" name="shopNumber"
									value="${shopCar.commodityNumber}"> <a href="#"
									title="Online Reservation"
									class="btn btn1 btn-primary btn-normal btn-inline payA"
									target="_self">总价：${shopCar.commodityPrice * shopCar.commodityNumber}</a>
								<button type="submit" class="payBtn" style="display: none"></button>
							</form> -->
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

			<!-- <form action="./shopingCartAccountServlet">
				<c:if test="${sessionScope.user_information.userName != null}">
					<div class="col-md-2">
						<select name="userAddr" class="form-control">
							<option value="${sessionScope.user_information.userAddr1}">${sessionScope.user_information.userAddr1}
							<option value="${sessionScope.user_information.userAddr2}">${sessionScope.user_information.userAddr2}
							<option value="${sessionScope.user_information.userAddr3}">${sessionScope.user_information.userAddr3}
							<option value="${sessionScope.user_information.userAddr4}">${sessionScope.user_information.userAddr4}
							<option value="${sessionScope.user_information.userAddr5}">${sessionScope.user_information.userAddr5}
						</select>
					</div>


					这里是隐藏的地址信息
					<input type="hidden" name="userAddr" value="">
				</c:if>
				<input name="shopCartId" value="${shopCar.shoppingCartId}"
					class="shopCartId" type="hidden">
				<button title="购买" class="jrgwc" type="submit">结算</button>
				<button type="submit" class="payBtn" style="display: none"></button>
			</form> -->



		</div>
		<div class="jiesuandan mt20 center">
			<div class="tishi fl ml20">
				<ul>
					<li><a href="./index">继续购物</a></li>
					<!-- <li>|</li>
					<li>共<span>2</span>件商品，已选择<span>1</span>件
					</li> -->
					<div class="clear"></div>
				</ul>
			</div>
			<div class="jiesuan fr">
				<!-- <div class="jiesuanjiage fl">
					合计（不含运费）：<span>2499.00元</span>
				</div> -->
				<div class="jsanniu fr">
					<input class="jsan" type="submit" name="jiesuan" value="去结算" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>

	</div>




	<!-- footer -->
	<footer class="mt20 center">
		<div class="mt20">Copyright © 2019 - 2019 All Rights
			Reserved.图书公司 版权所有</div>
	</footer>

</body>
</html>
