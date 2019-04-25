<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书商城</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/swiper.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="./index">图书商城</a></li>
						<li>|</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
				    <c:if test="${sessionScope.user_information.userName != null}">
							<div class="gouwuche fr"><a href="./shopingCar">购物车</a></div>
					
					</c:if>
					<c:if test="${sessionScope.user_information.userName != null}">
                            <div class="gouwuche fr"><a href="./FavoriteServlet">收藏夹</a></div>
                    
                    </c:if>
					<div class="fr">
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
							<li><a href="./getUserOrder" target="_blank">我的订单</a></li>
							<li>|</li>
							<li><a href="./logOut">退出登录</a></li>
						</ul>
					</c:if>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index"><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="./findCommodity?conditionName=军事&&type=3">军事</a></li>
					<li><a href="./findCommodity?conditionName=娱乐&&type=3">娱乐</a></li>
					<li><a href="./findCommodity?conditionName=科技&&type=3">科技</a></li>
					<li><a href="./findCommodity?conditionName=生活&&type=3">生活</a></li>
					<li><a href="./findCommodity?conditionName=文学&&type=3">文学</a></li>
				</ul>
			</div>
			<div class="search fr" style="position: relative;">
				<form action="/onlineBookStore/findCommodity" method="post" style="position: relative;">
				<!-- 	<div class="" style="position: absolute;top: -35px;left: 0;height: 16px;">
						<input type="radio" value="1" name="type" id="type-radio1" checked><span style="margin-right: 10px;height: 16px;display: inline-block;">书名</span>
						<input type="radio" value="2" name="type" id="type-radio2"><span style="margin-right: 10px;height: 16px;display: inline-block;">出版社</span>
						<input type="radio" value="3" name="type" id="type-radio3"><span style="margin-right: 10px;height: 16px;display: inline-block;">分类</span>
						<input type="radio" value="4" name="type" id="type-radio4"><span style="margin-right: 10px;height: 16px;display: inline-block;">作者</span>
					</div> -->
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="" name="conditionName">
					</div>
					<div class="submit fl">
					
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<a href="./toAdvancedQuery" style="position: absolute;top: 45px;left: -64px;font-size: 14px;height: 14px;line-height: 14px">高级查询</a>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	<!-- start banner_y -->
		<div class="banner_y center">
			<div class="nav" style="float:left">				
				<ul>
					<li>
						<a href="">军事</a>
						<div class="pop">
						<c:forEach var="list" items="${listMilitary}" varStatus="status">
							<div class="left fl" style="height:100px;">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img style="width:70px;height:70px;" src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}" alt=""></div>
											<span class="fl">${list.commodityName}</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">选购</a></div>
								</div>
							 <div class="clear"></div>
						    </div>
						</c:forEach>
						</div>
					</li>
					<li>
						<a href="">娱乐</a>
						<div class="pop">
						 <c:forEach var="list" items="${listEntertainment}" varStatus="status">
							<div class="left fl" style="height:100px;">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img style="width:70px;height:70px;" src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}" alt=""></div>
											<span class="fl">${list.commodityName}</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">选购</a></div>
								</div>
							 <div class="clear"></div>
						    </div>
						</c:forEach>
						</div>
					</li>
					<li>
						<a href="">科技</a>
						<div class="pop">
						<c:forEach var="list" items="${listScience}" varStatus="status">
							<div class="left fl" style="height:100px;">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img style="width:70px;height:70px;" src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}" alt=""></div>
											<span class="fl">${list.commodityName}</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">选购</a></div>
								</div>
							 <div class="clear"></div>
						    </div>
						</c:forEach>
					    </div>
					</li>
					<li>
						<a href="">生活</a>
						<div class="pop">
						<c:forEach var="list" items="${listLife}" varStatus="status">
							<div class="left fl" style="height:100px;">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img style="width:70px;height:70px;" src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}" alt=""></div>
											<span class="fl">${list.commodityName}</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">选购</a></div>
								</div>
							 <div class="clear"></div>
						    </div>
						</c:forEach>
						
						</div>
					</li>
					<li>
						<a href="">文学</a>
						<div class="pop">
						<c:forEach var="list" items="${listLiterature}" varStatus="status">
							<div class="left fl" style="height:100px;">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img style="width:70px;height:70px;" src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}" alt=""></div>
											<span class="fl">${list.commodityName}</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">选购</a></div>
								</div>
							 <div class="clear"></div>
						    </div>
						</c:forEach>
						
						</div>
					</li>
				</ul>
			</div>
			<div class="swiper-container" style="float:left;width: 992px;height: 460px;">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img src="${pageContext.request.contextPath}/pages/mall/image/banner2.jpg" alt="">
						</div>
						<div class="swiper-slide">
							<img src="${pageContext.request.contextPath}/pages/mall/image/banner2.jpg" alt="">
						</div>
						<div class="swiper-slide">
							<img src="${pageContext.request.contextPath}/pages/mall/image/banner2.jpg" alt="">
						</div>
					</div>
					<!-- 如果需要分页器 -->
					<div class="swiper-pagination"></div>

				</div>
		</div>	
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">推荐图书</div>
			<div class="main center">
			<c:forEach var="list" items="${recommendShoplist}" varStatus="status" begin="0" end="4">
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}"><img src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}" alt=""></a></div>
					<div class="pinpai"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">${list.commodityName}</a></div>
					<div class="youhui">剩余：${list.commoditySurplus}件</div>
					<div class="jiage">${list.commodityPrice}￥</div>
				</div>
			</c:forEach>
				
				<div class="clear"></div>
			</div>
			
		</div>
		<div class="peijian w">
			<div class="biaoti center">图书</div>
			<div class="main center">
				<div class="content">
				 <c:forEach var="list" items="${allCommoditylist}" varStatus="status" begin="0" end="9">
				
					<div class="remen fl" style="margin-bottom: 5px">
						<div class="xinpin"><span>${list.commodityType}</span></div>
						<div class="tu"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}"><img src="${pageContext.request.contextPath}/pages/mall/bookImage/${list.commodityPicture}"></a></div>
						<div class="miaoshu"><a href="${pageContext.request.contextPath}/commodityDetail?shopId=${list.commodityId}">${list.commodityName}</a></div>
						<div class="jiage">${list.commodityPrice}￥</div>
						<div class="pingjia">剩余：${list.commoditySurplus}件</div>
						<div class="piao">
							<a href="">
								<span>作者：${list.commodityAuthor}</span>
								<span>评价：${list.commodityRate}星</span>
							</a>
						</div>
					</div>
					
					</c:forEach>
					<div class="clear"></div>
				</div>
						
			</div>
		</div>
		<footer class="mt20 center">			
			<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
		</footer>
	</body>
</html>


<script src="${pageContext.request.contextPath}/pages/mall/js/swiper.js"></script>
<script>        
	var mySwiper = new Swiper ('.swiper-container', {
		direction: 'vertical', // 垂直切换选项
		loop: true, // 循环模式选项
		autoplay: {
			disableOnInteraction: false,
		},
		// 如果需要分页器
		pagination: {
		el: '.swiper-pagination',
		},
	})        
</script>