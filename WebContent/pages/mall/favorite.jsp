<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<c:forEach var="commodity" items="${commoditys}" varStatus="status">
序号 ${commodity.commodityId}
剩余数量：${commodity.commoditySurplus}；
<img src="images/${commodity.commodityPicture}" alt="image"
class="img-responsive zoom-img"
style="width: 100%; height: 256px; display: block">
评价：${commodity.commodityRate}星
价格${commodity.commodityPrice}
</c:forEach>
</body>
</html>