<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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