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
    <script type="text/javascript" src="/js/list.js"></script>
</head>
<body>
<c:if test="${user.grade==1}">
    <a href="/pages/add.jsp">添加按钮</a>
</c:if>
<c:forEach items="${list}" var="item">
    <div id="${item.content.id}">
        <div>
                ${item.content.content}
        </div>
        <div>
            <img src="${item.content.img}">
        </div>
        <c:forEach items="${item.itemDTOS}" var="dto">
            <input type="checkbox" value="${dto.voted}" onchange="haveVoted(event, ${dto.voted}, ${dto.id})">${dto.item}${dto.voted}<br>
        </c:forEach>
    </div>
</c:forEach>
<c:if test="${pageNo > 1}">
    <a href="/list?pageNo=${pageNo-1}&pageSize=${pageSize}">上一页</a>
</c:if>
<c:if test="${pageNo * pageSize < total}">
    <a href="/list?pageNo=${pageNo+1}&pageSize=${pageSize}">下一页</a>
</c:if>
</body>
</html>
