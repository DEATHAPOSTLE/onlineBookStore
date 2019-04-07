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
        <fieldset>
            <legend>
                上传单个文件
            </legend>
            <!-- 文件上传时必须要设置表单的enctype="multipart/form-data"-->
            <form action="${pageContext.request.contextPath}/UploadServlet"
                method="post" enctype="multipart/form-data">
                上传文件：
                <input type="file" name="file">
                <br>
                <input type="submit" value="上传">
            </form>
        </fieldset>
        <hr />
        <fieldset>
            <legend>
                上传多个文件
            </legend>
            <!-- 文件上传时必须要设置表单的enctype="multipart/form-data"-->
            <form action="${pageContext.request.contextPath}/UploadServlet"
                method="post" enctype="multipart/form-data">
                上传文件：
                <input type="file" name="file1">
                <br>
                上传文件：
                <input type="file" name="file2">
                <br>
                <input type="submit" value="上传">
            </form>
        </fieldset>
    </body>
</html>

<script type="text/javascript">
$(".logoutBtn").on("click", function () {
	window.location.href="./index"
})
</script>
