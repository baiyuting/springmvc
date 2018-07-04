<%--
  Created by IntelliJ IDEA.
  User: baiyuting
  Date: 2018/2/28
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/back/add.js"></script>
</head>
<body>
<button id="addUploadComponent" name="addUploadComponent">表单中添加上传图片控件</button>
<a href="/list?currentPage=1&lineSize=2">查看列表</a>
<form id="submitForm" action="/add" method="post" enctype="multipart/form-data">
    标题：<input type="text" id="title" name="title"><br>
    摘要：<input type="text" id="summary" name="summary"><br>
    内容：<input type="text" id="content" name="content"><br>
    <div id="files"></div>
    <button type="submit">提交</button>
</form>

</body>
</html>
