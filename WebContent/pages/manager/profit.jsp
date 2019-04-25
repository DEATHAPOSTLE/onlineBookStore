<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
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
    <nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="./index" class="maincolor">首页</a> <span class="c-999 en">&gt;</span><span class="c-666">销售利润</span></nav>
    <div class="Hui-article">
    
        <table class="table table-border table-bordered table-striped">
            <thead>
                <tr>
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>商品类型</th>
                    <th>商品价格</th>
                    <th>出版社</th>
                    <th>作者</th>
                    <th>进价</th>
                    <th>利润</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${commoditys}" varStatus="status">
                    <tr>
                        <td>${list.commodityId}</td>
                        <td>${list.commodityName}</td>
                        <td>${list.commodityType}</td>
                        <td>${list.commodityPrice}</td>
                        <td>${list.commodityPress}</td>
                        <td>${list.commodityAuthor}</td>
                        <td>${list.commodityInPrice}</td>
                        <td>${list.commodityProfit}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
</section>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/layer/2.4/layer.js"></script>
 
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/js/H-ui.admin.page.js"></script> 


<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>