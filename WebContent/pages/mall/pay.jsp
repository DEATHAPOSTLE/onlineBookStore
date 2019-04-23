<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>订单支付</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/pay.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/mall/css/amazeui.css">
</head>
<body>
		<div class="pay">
			<!--主内容开始编辑-->
			<div class="tr_recharge">
				<div class="tr_rechtext">
					<p class="te_retit"><img src="${pageContext.request.contextPath}/pages/mall/images/coin.png" alt="">支付中心</p>
					<p></p>
					<p></p>
				</div>
					<div class="tr_rechbox">
						<div class="tr_rechhead">
							<img src="${pageContext.request.contextPath}/pages/mall/images/ys_head2.jpg">
							<p>帐号：
								<a>${sessionScope.user_information.userName}</a>
								<span style="margin-left: 20px">余额：<a>${sessionScope.user_information.money}</a></span>
								<c:if test="${sessionScope.user_information.userType ==2}">
						          <span>您是会员，享有八折优惠</span>
					            </c:if>
							</p>
							<div class="tr_rechheadcion">
								<img src="${pageContext.request.contextPath}/pages/mall/images/coin.png" alt="">
								<span>总价：<span>${priceCount}元</span></span>
							</div>
						</div>
						<!-- <div class="tr_rechli am-form-group">
							<ul class="ui-choose am-form-group am-form-success" id="uc_01">
								<li class="selected">
									<label class="am-radio-inline">
								        	<input type="radio" value="" name="docVlGender" required="" data-validation-message="请选择一项充值额度" class="am-field-valid"> 10￥
									    </label>
								</li>
								<li class="">
									<label class="am-radio-inline">
									        <input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度" class="am-field-valid"> 20￥
								      	</label>
								</li>

								<li class="">
									<label class="am-radio-inline">
									        <input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度" class="am-field-valid"> 50￥
								        </label>
								</li>
								<li class="">
									<label class="am-radio-inline">
									        <input type="radio" name="docVlGender" data-validation-message="请选择一项充值额度" class="am-field-valid"> 其他金额
								        </label>
								</li>
							</ul>
						</div> -->
						<!-- <div class="tr_rechoth am-form-group" style="display: none;">
							<span>其他金额：</span>
							<input type="number" min="10" max="10000" value="10.00元" class="othbox" data-validation-message="充值金额范围：10-10000元" pattern="^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$" required="required">
						</div> -->
						<div class="tr_rechcho am-form-group am-form-success">
							<span>充值方式：</span>
							<label class="am-radio">
							        <input type="radio" name="radio1" checked><img src="${pageContext.request.contextPath}/pages/mall/images/wechatpay.png">
							    </label>
							<label class="am-radio" style="margin: 10px 0 0 0;">
							        <input type="radio" name="radio1"><img src="${pageContext.request.contextPath}/pages/mall/images/zfbpay.png">
                            </label>
						</div>
						<div class="tr_rechnum">
							<span>应付金额：</span>
							<p class="rechnum">${priceCount}元</p>
						</div>
					</div>
					<div class="tr_paybox">
					
					
					 <c:if test="${type == 1}">
						<form method="post" action="${pageContext.request.contextPath}/pay" class="">
					     <input name="shopId" value="${shopId}" class="shopCartId" type="hidden"> 
					     <input name="userAddr" value="${userAddr}" class="userAddr" type="hidden"> 
					     <input name="shopNumber" value="${shopNumber}" class="userAddr" type="hidden"> 
					
						<input type="submit" value="确认支付"  class="tr_pay am-btn">
						</form>
						</c:if>
						
					<c:if test="${type == 2}">
				         <form method="post" action="./shopingCartAccountServlet" class="">
					      <input name="shopCartId" value="${shopCartId}" class="shopCartId" type="hidden"> 
					      <input name="userAddr" value="${userAddr}" class="userAddr" type="hidden"> 
						<input type="submit" value="确认支付" class="tr_pay am-btn">
						</form>
						</c:if>
							
						
						
					</div>
			</div>
		</div>

		<script src="${pageContext.request.contextPath}/pages/mall/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/pages/mall/js/amazeui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/pages/mall/js/ui-choose.js"></script>

		<script type="text/javascript">
			
		</script>
	

</body>
</html>