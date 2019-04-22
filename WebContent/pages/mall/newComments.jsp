<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>图书商城</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/style.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/bootstrap.css">
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
				<li><a href="./getUserOrder">新增评论</a></li>
			</ul>
		</div>
	</div>
	<form  method="post" action="/onlineBookStore/saveUserInformation" class="">
		<div class="rtcont fr" style="height: auto;">
			<div class="grzlbt ml40">评论</div>
			<div class="subgrzl ml40"><span>星级</span>
			  <span>
			   <input class="commentsStars" type="number" name="userPassword" value="${user.userPassword}" placeholder="请输入星级" style="display:inline-block;height: 30px"/>
				</span>
				<span style="float: none;margin-left: -157px;text-align: left">星</span>
			</div>
			<div class="subgrzl ml40"><span>评论</span>
			  <span> 
			    <input class="" type="text" name="userPhoneNumber" value="${user.userPhoneNumber}" placeholder="请输入评论" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
		</div>
		<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="提交" >
		</div>
</form>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
<footer class="mt20 center">			
	<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
</footer>
	</body>
	<script src="${pageContext.request.contextPath}/pages/mall/js/jquery-1.11.1.min.js"></script>
	<script>
		$(".commentsStars").on("change", function () {
			if ($(".commentsStars").val() > 5) {
				$(".commentsStars").val(5)
			} else if ($(".commentsStars").val() < 1) {
				$(".commentsStars").val(1)
			}
		})
	</script>
</html>