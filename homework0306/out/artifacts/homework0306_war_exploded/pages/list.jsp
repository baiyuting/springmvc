<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baiyuting
  Date: 2018/3/30
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="item">
    <div>
            ${item.content.content}
    </div>
    <div>
            ${item.content.img}
    </div>
    <c:forEach items="${item.itemDTOS}" var="dto">
        ${dto.item}
    </c:forEach>
</c:forEach>
<c:if test="${pageNo > 1}">
    <a href="/list?pageNo=${pageNo-1}&pageSize=${pageSize}">上一页</a>
</c:if>
<c:if test="${pageNo * pageSize < total}">
    <a href="/list?pageNo=${pageNo+1}&pageSize=${pageSize}">下一页</a>
</c:if>
</body>
</html>
