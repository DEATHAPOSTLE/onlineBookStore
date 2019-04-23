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
		<div class="ddzx">商品管理</div>
		<div class="subddzx">
			<ul>
				<li><a href="" style="color:#ff6700;font-weight:bold;">新增商品</a></li>
				<li><a href="./commodityAdministration" style="color:#ff6700;font-weight:bold;">管理商品</a></li>
			
			
			</ul>
		</div>
	</div>
	
	<div class="rtcont fr" style="height: auto;">
			<form  method="post" action="/onlineBookStore/saveCommodity" enctype="multipart/form-data" class="">
				<div class="rtcont fr">
					<div class="subgrzl ml40"><span style="width: 117px;">商品名称</span>
						<span>
							<input class="" type="text" name="commodityName" value="" placeholder="更改商品名称" style="height: 30px"/>
						</span>
					</div>
					<div class="subgrzl ml40"><span style="width: 117px;">商品类型</span>
						<span> 
							<input class="" type="text" name="commodityType" value="" placeholder="更改商品类型" style="height: 30px"/>
						</span>
					</div>
					<div class="subgrzl ml40"><span style="width: 117px;">商品价格</span>
						<span>
							<input class="" type="text" name="commodityPrice" value="" placeholder="更改商品价格" style="height: 30px"/>
						</span>
					</div>
					<div class="subgrzl ml40"><span style="width: 117px;">出版社</span>
						<span>
							<input class="" type="text" name="commodityPress" value="" placeholder="更改出版社" style="height: 30px"/>
						</span>
					</div>
					<div class="subgrzl ml40"><span style="width: 117px;">作者</span>
						<span>
							<input class="" type="text" name="commodityAuthor" value="" placeholder="更改作者" style="height: 30px"/>
						</span>
					</div>
					<div class="subgrzl ml40"><span style="width: 117px;">上传商品图片</span>
						<span>
								<input type="file" name="commodityPicture" style="height: 30px"/>
						</span>
					</div>
					<div class="subgrzl ml40"><span style="width: 117px;">商品介绍图片</span>
						<span>
								<input type="file" name="commodityIntroduce" style="height: 30px"/>
						</span>
					</div>
				
				</div>
				<div class="login_submit" style="position: relative;">
							<input class="submit btn btn-primary" type="submit" name="submit" value="新增商品" style="position: absolute;top: 407px;left: 427px;">
				</div>
		</form>

	
	<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>
<!-- self_info -->
		</div>
<footer class="mt20 center">			
	<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
</footer>
	</body>
</html>
