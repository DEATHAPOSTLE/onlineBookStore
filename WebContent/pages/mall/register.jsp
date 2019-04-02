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

<div class="bg">
   
                    <form role="form" action="/onlineBookStore/toRegister" method="post" class="login-form">
                        <div class="form-group">
                            <label class="sr-only" for="form-username">姓名</label>
                            <input type="text" name="form-nameCn" placeholder="请输入姓名..." class="form-username form-control" id="form-username">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="form-password">Password</label>
                            <input type="password" name="form-password" placeholder="请输入密码..." class="form-password form-control" id="form-password">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="form-password">Password</label>
                            <input type="password" name="form-password" placeholder="请再次输入密码..." class="form-password form-control" id="form-password">
                        </div>
                        <button type="submit" class="btn btn-success">点此注册</button>
                            <button type="button" class="btn logoutBtn">返回登录</button>
                    </form>
              
</div>
</body>
</html>

<script type="text/javascript">
$(".logoutBtn").on("click", function () {
	window.location.href="./login"
})
</script>
