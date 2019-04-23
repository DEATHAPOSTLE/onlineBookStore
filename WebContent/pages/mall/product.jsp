<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2019/3/2
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/css/style.css" />
    <script>DD_belatedPNG.fix('*');</script>
    <!--/meta 作为公共模版分离出去-->

    <title>供货商管理</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">城乡残疾人爱心辅具后台</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="#">城乡残疾人爱心辅具后台</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav class="nav navbar-nav">

            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                <li><a href="./index">返回首页</a></li>
                    <li>超级管理员</li>
                    <li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">${sessionScope.user_information.idCard} <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="./logOut">退出</a></li>
                        </ul>
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
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<aside class="Hui-aside">

    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <dt>
                <i class="Hui-iconfont">&#xe616;</i> 退换货管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
            </dt>
            <dd>
                <ul>
                    <li>
                        <a href="rejectedList" title="退换货管理">退换货管理</a>
                    </li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-picture">
            <dt class="selected">
                <i class="Hui-iconfont">&#xe613;</i> 供货商管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
            </dt>
            <dd style="display: block">
                <ul>
                    <li class="current">
                        <a href="./commodityAdministration" title="供货商管理">供货商管理</a>
                    </li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe620;</i> 订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="./GetAllOrdersServlet" title="订单管理">订单管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe620;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a href="./BackCommentServlet" title="评论管理">评论管理</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box" style="overflow-y: auto;">
    <nav class="breadcrumb"  style="display: none"><i class="Hui-iconfont"></i> <a href="#" class="maincolor">首页</a>
        <span class="c-999 en">&gt;</span>
        <span class="c-666">供货商管理</span>
        <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
    </nav>
    <div class="box" style="padding: 15px">
        <table class="table table-border table-bordered table-striped">
                    <tr>
                          <th>商品序号</th>                       
		                  <th>商品名称</th>
		                  <th>商品种类</th>
		                  <th>商品价格</th>
		                  <th>商品介绍</th>
		                  <th>商品剩余数量</th>
		                  <th>商品评价</th>
		          		  <th>商品上/下架</th>
		          			<th>商品供货</th>
		                  
		            </tr>  
              <c:forEach var="commodity" items="${allList}" varStatus="status">
		    		<tr>
		    			<td>${((page.pageNo-1)*page.pageSize)+status.count}</td>
		    			<td>${commodity.commodityName}</td>
		    			<td>${commodity.commodityType}</td>
		    			<td>${commodity.commodityPrice}</td>
		    			<td>${commodity.commodityIntroduce}</td>
		    			<td>${commodity.commoditySurplus}</td>
		    			<td>${commodity.commodityRate}</td>
		    			<td>
		    			<c:if test="${commodity.commodityShelves eq 1 }">
		    			  <a href="${pageContext.request.contextPath}/shelves?shopId=${commodity.commodityId}&shelves=1">下架</a>
		    			</c:if>
		    			<c:if test="${commodity.commodityShelves eq 2 }">
		    			  <a href="${pageContext.request.contextPath}/shelves?shopId=${commodity.commodityId}&shelves=2">上架</a>		    			
                        </c:if>		    			
		    				
		    			</td>
		    			<td>
		    			<form action="updateCommodity">
		    			<span>
		    			<a href="#" class="updateBtn">供货</a>
		    			<input class="form-control" style="height: 18px;width: 40px;" type="number" value="0" name="number">件</span>
		    			  	
	    			  	<input type="hidden" name="shopId" value="${commodity.commodityId}">
	    			  	</form>
	    			  	</td>
		    			  	
		    	
		    		</tr>
		    		
				</c:forEach>
                            
         </table>               
    </div>
    <footer class="footer">
        <p>Copyright &copy; 2019.Company name All rights reserved.</p>
    </footer>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/manager/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
$(".updateBtn").on("click", function () {
	if ($(this).next().val() == '') {
		alert("请输入不为0的数字")
		return
	} else {
		$(this).parents("form").submit()
	}
	
})
</script>
<!--/请在上方写此页面业务相关的脚本-->

</body>
</html>
