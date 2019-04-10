<%@ page contentType="text/html;charset=UTF-8" language="java"%>

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
				<form action="/onlineBookStore/findCommodity" method="post" style="position: relative;">
					<div class="radio-box" style="position: absolute;top: -35px;left: 0;">
						<input type="radio" name="type" id="type-radio1" checked><label for="type-radio1" style="margin-right: 10px;">书名</label>
						<input type="radio" name="type" id="type-radio2"><label for="type-radio2" style="margin-right: 10px;">出版社</label>
						<input type="radio" name="type" id="type-radio3"><label for="type-radio3" style="margin-right: 10px;">分类</label>
						<input type="radio" name="type" id="type-radio4"><label for="type-radio4" style="margin-right: 10px;">作者</label>
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

	<!-- start banner_y -->
		<div class="banner_y center">
			<div class="nav">				
				<ul>
					<li>
						<a href="">图书</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="./xiangqing.html" target="_blank">选购</a></div>
								</div>
							<div class="clear"></div>
						</div>
					</li>
				</ul>
			</div>
		
		</div>	
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			
			<div class="biaoti center">明星单品</div>
			<div class="main center">
				<div class="mingxing fl">
					<div class="sub_mingxing"><a href=""><img src="./image/pinpai1.png" alt=""></a></div>
					<div class="pinpai"><a href="">图书</a></div>
					<div class="youhui">图书图书图书图书图书图书图书图书</div>
					<div class="jiage">3499元起</div>
				</div>
				
				<div class="clear"></div>
			</div>
		</div>
		<div class="peijian w">
			<div class="biaoti center">图书</div>
			<div class="main center">
				<div class="content">
					<div class="remen fl"><a href=""><img src="./image/peijian1.jpg"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span>新品</span></div>
						<div class="tu"><a href=""><img src="./image/peijian2.jpg"></a></div>
						<div class="miaoshu"><a href="">图书</a></div>
						<div class="jiage">49元</div>
						<div class="pingjia">372人评价</div>
						<div class="piao">
							<a href="">
								<span>图书图书图书图书</span>
								<span>图书</span>
							</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="content">
					<div class="remen fl"><a href=""><img src="./image/peijian6.png"></a>
					</div>
					<div class="remen fl">
						<div class="xinpin"><span>新品</span></div>
						<div class="tu"><a href=""><img src="./image/peijian2.jpg"></a></div>
						<div class="miaoshu"><a href="">图书</a></div>
						<div class="jiage">49元</div>
						<div class="pingjia">372人评价</div>
						<div class="piao">
							<a href="">
								<span>图书图书图书图书</span>
								<span>图书</span>
							</a>
						</div>
					</div>
					
					<div class="remenlast fr">
						<div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>
						<div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>					
					</div>
					<div class="clear"></div>
				</div>				
			</div>
		</div>
		<footer class="mt20 center">			
			<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
		</footer>
	</body>
</html>