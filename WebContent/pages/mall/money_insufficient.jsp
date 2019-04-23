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
		<div class="pay" style="height: 80px">
		<p style="height: 80px;line-height: 80px;font-size: 22px;text-align:center">余额不足，请充值，3秒后跳转<a href="./recharge">充值</a>页面</p>
		</div>

		<script src="${pageContext.request.contextPath}/pages/mall/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/pages/mall/js/amazeui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/pages/mall/js/ui-choose.js"></script>

		<script type="text/javascript">
		(function () {
			debugger
			var timer = setTimeout(function () {
				window.location.href = "./recharge";
			}, 3000)
		})()
			
		</script>
	

</body>
</html>