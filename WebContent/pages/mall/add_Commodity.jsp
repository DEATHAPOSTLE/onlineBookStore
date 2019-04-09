<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 2019/2/25
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


  <body>


<form  method="post" action="/onlineBookStore/saveCommodity" enctype="multipart/form-data" class="">
		<div class="rtcont fr">
			<div class="subgrzl ml40"><span> 商品名称</span>
			  <span>
			   <input class="" type="text" name="commodityName" value="" placeholder="更改密码"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>  商品类型：</span>
			  <span> 
			    <input class="" type="text" name="commodityType" value="" placeholder="更改电话"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>商品价格：</span>
			  <span>
			    <input class="" type="text" name="commodityPrice" value="" placeholder="请输入地址1"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>出版社：</span>
			  <span>
			    <input class="" type="text" name="commodityPress" value="" placeholder="请输入地址2"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>作者：</span>
			  <span>
			    <input class="" type="text" name="commodityAuthor" value="" placeholder="请输入地址2"/>
			  </span>
			</div>
			<div class="subgrzl ml40"><span>上传商品图片:</span>
			  <span>
			     <input type="file" name="commodityPicture" />
			  </span>
			</div>
			<div class="subgrzl ml40"><span>商品介绍图片:</span>
			  <span>
			     <input type="file" name="commodityIntroduce" />
			  </span>
			</div>
   
		</div>
		<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="新增商品" >
		</div>
</form>

            
        <hr />
        
    </body>
</html>

