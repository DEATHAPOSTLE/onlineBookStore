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

	
	<!-- xiangqing -->
	<form action="post" method="">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">图书详情</div>
			<!-- <nav class="fr">
				<li><a href="">概述</a></li>
				<li>|</li>
				<li><a href="">变焦双摄</a></li>
				<li>|</li>
				<li><a href="">设计</a></li>
				<li>|</li>
				<li><a href="">参数</a></li>
				<li>|</li>
				<li><a href="">F码通道</a></li>
				<li>|</li>
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav> -->
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl"><img src="${pageContext.request.contextPath}/pages/mall/bookImage/${commodityBase.commodityPicture}"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20">${commodityBase.commodityName}</div>
			<div class="jianjie mr40 ml20 mt10">书籍分类：${commodityBase.commodityType}</div>
			<div class="jiage ml20 mt10">${commodityBase.commodityPrice}元</div>
			<div class="ft20 ml20 mt10">剩余数量：${commodityBase.commoditySurplus}</div>
			<div class="jiage ml20 mt10">评分：${commodityBase.commodityRate}星</div>
			<div class="jianjie ml20 mt20">出版社：${commodityBase.commodityPress}</div>
			<div class="jianjie ml20 mt20">作者：${commodityBase.commodityAuthor}</div>
			
		
			<div class="xiadan ml20 mt20">
					<input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
					<input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />
					
				<form action="${pageContext.request.contextPath}/pay" style="display: inline-block">
                    <div class="quantity_box">
                        <ul class="product-qty">
                            <span>数量</span>
                            <input type="number" class="form-control shopNumber" id="" placeholder="请输入数量"  name="shopNumber" value="1">
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    
                    <c:if test="${sessionScope.user_information.idCard != null}">
                    <div class="row" style="margin: 0;margin-bottom: 15px">
                    <span style="color: #555;font-size: 0.85em;padding-bottom: 0.5em;display: block;text-transform: uppercase;">地址</span>
		            	    <select name="userAddr" class="form-control">
		                       <option value="${sessionScope.user_information.userAddr1}" >${sessionScope.user_information.userAddr1}
		                       <option value="${sessionScope.user_information.userAddr2}" >${sessionScope.user_information.userAddr2}
		                       <option value="${sessionScope.user_information.userAddr3}" >${sessionScope.user_information.userAddr3}
		                       <option value="${sessionScope.user_information.userAddr4}" >${sessionScope.user_information.userAddr4}
		                       <option value="${sessionScope.user_information.userAddr5}" >${sessionScope.user_information.userAddr5}
		                    </select>
            	    </div>
                    
                    <!-- 这里是隐藏的地址信息 -->
                     <!--<input type="hidden" name="userAddr" value=""> -->                    
                    </c:if>
                    
                    
                    
                    
                    <input type="hidden" value="${commodityBase.commodityId}" name="shopId">
                    <a href="#" title="购买" class="btn btn-primary btn-normal btn-inline payA" target="_self">购买</a>
                    <button type="submit" class="payBtn" style="display: none"></button>
                    </form>
                    <form action="addShopingCar" style="display: inline-block">
                    <input type="hidden" value="${commodityBase.commodityId}" name="commodityId">
                    <input type="hidden" value="1" name="commodityNumber" class="shopCarNumber">
                    <a href="#" title="添加购物车" class="btn btn-primary btn-normal btn-inline carA" target="_self">添加购物车</a>
                    <button type="submit" class="carBtn" style="display: none"></button>
                    </form>
			</div>
			<div class="left fl"><img src="${pageContext.request.contextPath}/pages/mall/bookImage/${commodityBase.commodityIntroduce}"></div>
			
		</div>
		<div class="clear"></div>
	</div>
	</form>
	<!-- footer -->
	<footer class="mt20 center">			
		<div class="mt20">Copyright © 2019 - 2019 All Rights Reserved.图书公司 版权所有</div>
	</footer>

	</body>
</html>

<script>
    jQuery(document).ready(function($){

        $('#etalage').etalage({
            thumb_image_width: 300,
            thumb_image_height: 400,
            source_image_width: 900,
            source_image_height: 1200,
            show_hint: true,
            click_callback: function(image_anchor, instance_id){
                alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
            }
        });
        
        
        var barWidth = ${commodityBase.commodityRate}
        var str=Number(barWidth / 5 * 100).toFixed();
            str+="%";
            console.log(str)
        $(".progress-bar").css("width", str)

    });
</script>
<script src="${pageContext.request.contextPath}/js/mall/easyResponsiveTabs.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true   // 100% fit in a container
        });
    });
    $(".payA").on("click", function() {
    	if ($(".shopNumber").val() == '') {
    		alert("数量不能为空")
    		return
    	} else {
    		$(".payBtn").click()
    	}
    })
    $(".carA").on("click", function() {
    	if ($(".shopNumber").val() == '') {
    		alert("数量不能为空")
    		return
    	} else {
    		$(".carBtn").click()
    	}
    
    })
    var shopNumber = ''
    $(".shopNumber").on("change", function () {
    	shopNumber = $(".shopNumber").val()
    	$(".shopCarNumber").val(shopNumber)
    	console.log($(".shopCarNumber").val())
    })
</script>