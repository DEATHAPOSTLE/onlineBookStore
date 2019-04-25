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
					<li><a href="./getCommentByType?conditionName=军事">军事</a></li>
					<li><a href="./getCommentByType?conditionName=娱乐">娱乐</a></li>
					<li><a href="./getCommentByType?conditionName=科技">科技</a></li>
					<li><a href="./getCommentByType?conditionName=生活">生活</a></li>
					<li><a href="./getCommentByType?conditionName=文学">文学</a></li>
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
<!-- self_info -->
<div class="grzxbj">
	<div class="selfinfo center">
	<div class="lfnav fl">
		<div class="ddzx">订单中心</div>
		<div class="subddzx">
			<ul>
				<li><a href="./getUserOrder">我的订单</a></li>
			</ul>
		</div>
		<div class="ddzx">个人中心</div>
		<div class="subddzx">
			<ul>
				<li><a href="./userInformation" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
			</ul>
		</div>
	</div>
	<form  method="post" action="/onlineBookStore/saveUserInformation" class="">
		<div class="rtcont fr" style="height: auto;">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>昵称</span><span>${user.userName}</span></div>
			<div class="subgrzl ml40"><span>密码</span>
			  <span>
			   <input class="" type="password" name="userPassword" value="${user.userPassword}" placeholder="更改密码" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>手机号</span>
			  <span> 
			    <input class="" type="text" name="userPhoneNumber" value="${user.userPhoneNumber}" placeholder="更改电话" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>收货地址1</span>
			  <span>
			    <input class="" type="text" name="userAddr1" value="${user.userAddr1}" placeholder="请输入地址1" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>收货地址2</span>
			  <span>
			    <input class="" type="text" name="userAddr2" value="${user.userAddr2}" placeholder="请输入地址2" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>收货地址3</span>
			  <span>
                <input class="" type="text" name="userAddr3" value="${user.userAddr3}" placeholder="请输入地址3" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>收货地址4</span>
			  <span>
			    <input class="" type="text" name="userAddr4" value="${user.userAddr4}" placeholder="请输入地址4" style="display:inline-block;height: 30px"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>收货地址5</span>
			  <span>
                 <input class="" type="text" name="userAddr5" value="${user.userAddr5}" placeholder="请输入地址5" style="display:inline-block;height: 30px"/> 
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
</html>