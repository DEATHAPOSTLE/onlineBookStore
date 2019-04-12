<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="order by dede58.com" />
<title>我的购物车-小米商城</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/pages/mall/css/style.css">
</head>
<body>
	<!-- start header -->
	<!--end header -->

	<!-- start banner_x -->
	<div class="banner_x center">
		<a href="./index.html" target="_blank"><div class="ad_top fl"></div></a>

		<div class="wdgwc fl ml40">我的购物车</div>
		<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
		<div class="dlzc fr">
			<ul>
				<li><a href="./login.html" target="_blank">登录</a></li>
				<li>|</li>
				<li><a href="./register.html" target="_blank">注册</a></li>
			</ul>

		</div>
		<div class="clear"></div>
	</div>
	<div class="xiantiao"></div>
	<div class="gwcxqbj" style="height: auto;">
		<div class="gwcxd center">
			<div class="top2 center">
				<div class="sub_top fl"></div>
				<div class="sub_top fl">商品名称</div>
				<div class="sub_top fl">商品图片</div>
				<div class="sub_top fl">商品剩余数量</div>
				<div class="sub_top fl">单价</div>
				<div class="sub_top fl">数量</div>
				<div class="sub_top fl">小计</div>
				<div class="sub_top fr">操作</div>
				<div class="clear"></div>
			</div>
			<c:forEach var="shopCar" items="${shopCart}" varStatus="status">

				<div class="content2 center">
					<div class="sub_content fl ">
						<a href="#">${shopCar.commodityName}</a>
					</div>
					<div class="left-side col-xs-11 col-sm-3">
						<img
							src="${pageContext.request.contextPath}/images/${shopCar.commodityPicture}"
							alt="" / style="width: 100%; height: 148px">
					</div>

					<div class="sub_content fl ft20">${shopCar.commoditySurplus}</div>
					<div class="sub_content fl ft20">￥${shopCar.commodityPrice}元</div>
					<div class="sub_content fl">
						<p>${shopCar.commodityNumber}件</p>
						<a href="./delShopingCar?shopId=${shopCar.shoppingCartId}">删除</a>
						<form action="${pageContext.request.contextPath}/pay">
							<input type="hidden" value="${shopCar.commodityId}" name="shopId">
							<input type="hidden" name="shopNumber"
								value="${shopCar.commodityNumber}"> <a href="#"
								title="Online Reservation"
								class="btn btn1 btn-primary btn-normal btn-inline payA"
								target="_self">总价：${shopCar.commodityPrice * shopCar.commodityNumber}</a>
							<button type="submit" class="payBtn" style="display: none"></button>
						</form>
					</div>
					<div style="border-top: 1px solid #ccc; margin-top: 30px; padding-top: 30px">
						<form action="./shopingCartAccountServlet">
							<c:if test="${sessionScope.user_information.idCard != null}">
								<div class="col-md-2">
									<select name="userAddr" class="form-control">
										<option value="${sessionScope.user_information.userAddr1}">${sessionScope.user_information.userAddr1}

											<option value="${sessionScope.user_information.userAddr2}">${sessionScope.user_information.userAddr2}
	                       
										<option value="${sessionScope.user_information.userAddr3}">${sessionScope.user_information.userAddr3}
	                       
										<option value="${sessionScope.user_information.userAddr4}">${sessionScope.user_information.userAddr4}
	                       
										<option value="${sessionScope.user_information.userAddr5}">${sessionScope.user_information.userAddr5}
	                    
									</select>
            	    </div>
                    
                    
                    <!-- 这里是隐藏的地址信息 -->
                     <!--<input type="hidden" name="userAddr" value=""> -->                    
                    </c:if>
            		<input name="shopCartId" value="" class="shopCartId"
								type="hidden">
            		<a href="#" title="Online Reservation"
								class="btn btn1 btn-primary btn-normal btn-inline shopCartIdBtn"
								target="_self">全部结算</a>
            	</form>
            	
            </div>
				<div class="clear"></div></div>
										
				
			</c:forEach>
				
				
			</div>
			
			
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="./liebiao.html">继续购物</a></li>
						<li>|</li>
						<li>共<span>2</span>件商品，已选择<span>1</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>2499.00元</span>
				</div>
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
		<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
	</footer>

	</body>
</html>
