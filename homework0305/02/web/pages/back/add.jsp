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
</head>
<body>
<a href="/list?currentPage=1&lineSize=2">查看列表</a>
<form action="/add" method="post">
    标题：<input type="text" id="title" name="title"><br>
    关键词：<input type="text" id="keyword" name="keyword"><br>
    内容：<input type="text" id="content" name="content"><br>
    <button type="submit">提交</button>
</form>

</body>
</html>
