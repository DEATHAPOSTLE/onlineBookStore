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
			<div class="search fr">
				<form action="/onlineBookStore/findCommodity" method="post" style="position: relative;">
					<div class="" style="position: absolute;top: -35px;left: 0;height: 16px;">
						<input type="radio" value="1" name="type" id="type-radio1" checked><span style="margin-right: 10px;height: 16px;display: inline-block;">书名</span>
						<input type="radio" value="2" name="type" id="type-radio2"><span style="margin-right: 10px;height: 16px;display: inline-block;">出版社</span>
						<input type="radio" value="3" name="type" id="type-radio3"><span style="margin-right: 10px;height: 16px;display: inline-block;">分类</span>
						<input type="radio" value="4" name="type" id="type-radio4"><span style="margin-right: 10px;height: 16px;display: inline-block;">作者</span>
					</div>
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="" name="conditionName">
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

	
	<!-- xiangqing -->
	<div class="xiangqing">
		<div class="neirong w">
			
			<form action="./advancedQuery" method="post" style="position: relative;">
		         <p><span>作者:</span><input type="text" name="author" class="" ></p>
				 <p><span>分类:</span><input type="text" name="type" class="" ></p>
				 <p><span>出版社:</span><input type="text" name="press" class="" ></p>
				 <p><span>价格区间:</span>￥：<input type="text" name="lowPrice" class="" >
				 ---￥：<input type="text" name="highPrice" class="" ></p>
			    
			     <p><input type="submit" class="sousuo" value="搜索"/></p>
		  </form>
		
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
	</div>

	</body>
</html>

<script src="${pageContext.request.contextPath}/pages/mall/js/jquery-1.11.1.min.js"></script>
<script>

</script>