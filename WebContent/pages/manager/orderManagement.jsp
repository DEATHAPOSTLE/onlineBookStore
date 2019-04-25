<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<!--[if lt IE 9]>
		<script type="text/javascript" src="lib/html5.js"></script>
		<script type="text/javascript" src="lib/respond.min.js"></script>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/lib/Hui-iconfont/1.0.8/iconfont.css" />
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/css/style.css" />
		<!--[if IE 6]>
		<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
		<script>DD_belatedPNG.fix('*');</script><![endif]-->

<title>达达图书商城后台系统</title>
</head>
<body>
		<header class="navbar-wrapper">
				<div class="navbar navbar-fixed-top">
					<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/index">达达图书商城后台系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">达达</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
						<nav class="nav navbar-nav">
							
						</nav>
						<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
							<ul class="cl">
								<li>${sessionScope.user_information.userName}</li>
								<li> <a href="/pages/mall/login.jsp"> 返回首页</a>
								</li>
								<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
									<ul class="dropDown-menu menu radius box-shadow">
										<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
										<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
										<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
										<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
										<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
										<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
									</ul>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</header>

			<aside class="Hui-aside">

					<c:if test="${sessionScope.user_information.userType == 4}">
				  
					  <div class="menu_dropdown bk_2">
						  <dl id="menu-article">
							  <dt><i class="Hui-iconfont">&#xe616;</i> 订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
							  <dd>
								  <ul>
									  <li><a href="./GetAllOrdersServlet" title="订单管理"> 订单管理</a></li>
									  <li><a href="./rejectedList" title="售后服务"> 售后服务</a></li>
								  </ul>
							  </dd>
						  </dl>
						  <dl id="menu-article">
							  <dt><i class="Hui-iconfont">&#xe616;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
							  <dd>
								  <ul>
									  <li><a href="./commodityAdministration" title="物流查询"> 商品上下架</a></li>
									  <li><a href="./addCommoditys" title="物流查询"> 商品添加</a></li>
									  <li><a href="./PofitServlet" title="销售利润"> 销售利润</a></li>
								  </ul>
							  </dd>
						  </dl>
					  </div>
					  </c:if>
					  
					<c:if test="${sessionScope.user_information.userType == 3}">
					  
					  <div class="menu_dropdown bk_2">
					  
						  <dl id="menu-article">
							  <dt><i class="Hui-iconfont">&#xe616;</i> 商品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
							  <dd>
								  <ul>
									  <li><a href="./bookAudit" title="安全审核">安全审核</a></li>
								  </ul>
							  </dd>
						  </dl>
					  </div>
					  </c:if>
				  </aside>
				  <div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="./index" class="maincolor">首页</a> <span class="c-999 en">&gt;</span><span class="c-666">订单管理</span></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			订单管理
		</article>
	<form role="form" class="form-inline" style="margin-bottom: 15px"  action="searchOrderByIdServlet" method="post">
		<input type="text" placeholder="请输入订单编号" class="input-text radius size-M" style="width: 30%" id="orderId" name="orderId">
		<input class="btn btn-primary radius" type="submit" value="搜索">
	</form>
	    <table class="table table-border table-bordered table-striped">
			<thead>
				<tr>
					<th>订单编号</th>
					<th>商品编号</th>
					<th>金额</th>
					<th>买家用户名</th>
					<th>收货人电话</th>
					<th>收货地址</th>
					<th>订单状态</th>
					<th>下单时间</th>
					<th>发货时间</th>
					<th>收货时间</th>
					<th>操作</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${orders}">
		    		<tr>
		    			<td>${order.orderId}</td>
		    			<td>${order.commodityID}</td>
		    			<td>${order.orderPrice}</td>
		    			<td>${order.userName}</td>
		    			<td><input type="text" class="input-text radius phoneNumber" value="${order.phoneNumber}"></td>
		    			<td><input type="text" class="input-text radius orderAddr" value="${order.orderAddr}"></td>
		    			<td>
		    			<c:if test="${order.orderStatus eq 1 }">
		    			   <span>买家已付款</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 2 }">
		    			   <span>商家已发货</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 3 }">
		    			   <span>买家已确认收货，交易成功</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 4 }">
		    			   <span>退货审核中</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 5 }">
		    			   <span>退货审核通过，等待买家寄回商品</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 6 }">
		    			   <span>退货成功</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 7 }">
		    			   <span>商家拒绝退货</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 8 }">
		    			   <span>退货满足要求，退货成功</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 9 }">
		    			   <span>退货不满足要求，商品寄回客户</span>
		    			</c:if>
		    			<c:if test="${order.orderStatus eq 10 }">
		    			   <span>退货商品已寄出，待审核</span>
		    			</c:if>
		    			
		    			
		    			</td>
		    			
		    			<td>${order.orderDTime}</td>
		    			<td>${order.deliveryDTime}</td>
		    			<td>${order.receiveDTime}</td>
		    			<td>
		    			<c:if test="${order.orderStatus eq 1 }">
		    			<form action="/onlineBookStore/deliverCommodity">
		    				<input type="hidden" value="${order.orderId}" name="orderId">
		    				<a href="#" class="deliverBtn">发货</a>
		    			</form>
		    			   
		    			</c:if>
		    			<c:if test="${order.orderStatus ne 1 }">
		    			   <span>已发货</span>
		    			</c:if>
		    			
		    			</td>
		    			<td>
		    			<form class="editOrder" action="/onlineBookStore/updateOrders">
		    			    <input type="hidden" name="orderId" value="${order.orderId}">
		    				<input type="hidden" name="phoneNumber" class="input-text radius hidePhoneNumber" value="">
		    				<input type="hidden" name="orderAddr" class="input-text radius hideOrderAddr" value="">
		    				<a href="#" class="submitBtn">确认编辑</a>
		    			</form>
		    				
		    			</td>
		    			
		    			
		    		</tr>
				</c:forEach>
			</tbody>
		</table>
	    </div>
</section>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/layer/2.4/layer.js"></script>
 
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/js/H-ui.admin.page.js"></script> 


<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
$(".deliverBtn").on("click", function () {
	$(this).parents("form").submit()
})
$(".submitBtn").on("click", function () {
	var thisRow = $(this).parent().parent().parent()
	var phoneNumber = thisRow.find(".phoneNumber").val()
	var orderAddr = thisRow.find(".orderAddr").val()
	thisRow.find(".hidePhoneNumber").val(phoneNumber)
	thisRow.find(".hideOrderAddr").val(orderAddr)
	if (thisRow.find(".hidePhoneNumber").val() != '' && thisRow.find(".hideOrderAddr").val() != '') {
		$(this).parents("form").submit()		
	} else {
		alert("请输入正确的地址和电话")
	}
})

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>