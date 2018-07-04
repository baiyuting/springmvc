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
    <script type="text/javascript" src="/js/back/edit.js"></script>
</head>
<body>
<div>
    <input type="hidden" id="newsId" name="newsId" value="${param.newsId}">
    标题：<input type="text" id="title" name="title" readonly><br>
    摘要：<input type="text" id="summary" name="summary" readonly><br>
    内容：<input type="text" id="content" name="content" readonly><br>
    审核状态：
    <select id="auditStatus" name="auditStatus">
        <option value="1">通过审核</option>
        <option value="0">未通过审核</option>
    </select><br>
    审核失败原因：
    <textarea id="auditFailReason" name="auditFailReason"></textarea><br>
    <button id="button" name="button">提交</button>
</div>

</body>
</html>
