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
						<c:if test="${sessionScope.user_information.userName == null}">
					
						<ul>
							<li><a href="./login" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="./register" target="_blank" >注册</a></li>
						</ul>
					 </c:if>
					 <c:if test="${sessionScope.user_information.userName != null}">
						
						<ul>
							<li><a href="./userInformation" target="_blank">欢迎，${sessionScope.user_information.userName}</a></li>
							<li>|</li>
							<li><a href="./getUserOrder" target="_blank">我的订单</a></li>
							<li>|</li>
							<li><a href="./logOut" target="_blank" >退出登录</a></li>
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
	<form  method="post" action="/onlineBookStore/toRecharge" class="">
		<div class="rtcont fr" style="height: auto;">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>昵称</span><span>${user.userName}</span></div>
			<div class="subgrzl ml40"><span>余额：</span>${user.money}
			  	<span>
			  	充值
			   	<input class="" type="text" name="money" value="" placeholder="请输入金额"/>
			  	元
			  	</span>
			
			</div>
			  	<span>
			  	注：一次性充值500元及以上，可以成为会员并享受折扣。
				</span>  
			<div class="login_submit">
				<input class="submit" type="submit" name="submit" value="提交" >
		    </div>
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
</html>