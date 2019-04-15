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
				<li><a href="./getUserOrder" >我的订单</a></li>
			</ul>
		</div>
		<div class="ddzx">个人中心</div>
		<div class="subddzx">
			<ul>
				<li><a href="./userInformation" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
			</ul>
		</div>
	</div>
	
		<div class="rtcont fr" style="height: auto;">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>昵称</span><span>${user.userName}</span><span><a href="/onlineBookStore/updateUserInformation">编辑个人资料</a></span></div>
			<div class="subgrzl ml40"><span>密码</span><span>【已隐藏】</span></div>
			<div class="subgrzl ml40"><span>手机号</span><span>${user.userPhoneNumber}</span></div>
			<div class="subgrzl ml40"><span>收货地址1</span><span>${user.userAddr1}</span></div>
			<div class="subgrzl ml40"><span>收货地址2</span><span>${user.userAddr2}</span></div>
			<div class="subgrzl ml40"><span>收货地址3</span><span>${user.userAddr3}</span></div>
			<div class="subgrzl ml40"><span>收货地址4</span><span>${user.userAddr4}</span></div>
			<div class="subgrzl ml40"><span>收货地址5</span><span>${user.userAddr5}</span></div>
			<div class="subgrzl ml40"><span>用户权限</span>
			  <span>
			       <c:if test="${user.userType eq 1}">
					  普通用户
		    	   </c:if>
		    	   <c:if test="${user.userType eq 2}">
					  会员
		    	   </c:if>
		    	   <c:if test="${user.userType eq 3}">
					  管理员
		    	   </c:if>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>余额</span><span>${user.money}</span><span><a href="/onlineBookStore/recharge">充值</a></span></div>
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