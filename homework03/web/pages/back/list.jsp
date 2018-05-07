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
    <script type="text/javascript" src="/js/back/list.js"></script>
</head>
<body>
<input type="hidden" id="lineSize" name="lineSize" value="${lineSize}">
<input type="hidden" id="auditStatus" name="auditStatus" value="${auditStatus}">
<c:if test="${user.grade==0}">
    <a href="/pages/back/add.jsp">发布新闻</a>
</c:if>
<select id="select" name="select">
    <option value="1">通过审核</option>
    <option value="0">未通过审核</option>
</select>
<table>
    <tr>
        <td>标题</td>
        <td>发布时间</td>
        <td>摘要</td>
        <td>内容</td>
        <td>审核状态</td>
        <td>审核日期</td>
        <td>审核用户id</td>
        <td>审核失败原因</td>
        <c:if test="${user.grade==1}">
            <td>审核</td>
        </c:if>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td id="${item.id}title">${item.title}</td>
            <td>${item.publishTime}</td>
            <td id="${item.id}summary">${item.summary}</td>
            <td id="${item.id}content">${item.content}</td>
            <td id="${item.id}imgs">
                    <c:forEach items="${item.imgList}" var="img">
                        <img src="${img}">
                    </c:forEach>
            </td>
            <td id="${item.id}auditStatus">${item.auditStatus}</td>
            <td>${item.auditDate}</td>
            <td>${item.auditUserId}</td>
            <td id="${item.id}auditFailReason">${item.auditFailReason}</td>
            <c:if test="${user.grade==1}">
                <td><button onclick="toEditJsp(${item.id})">审核</button></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<c:if test="${currentPage-1 > 0}">
    <a href="/list?currentPage=${currentPage-1}&lineSize=${lineSize}&auditStatus=${auditStatus}">上一页</a>
</c:if>
<c:if test="${currentPage*lineSize+1<=count}">
    <a href="/list?currentPage=${currentPage+1}&lineSize=${lineSize}&auditStatus=${auditStatus}">下一页</a>
</c:if>
</body>
</html>
