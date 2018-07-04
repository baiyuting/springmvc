<%--
  Created by IntelliJ IDEA.
  User: baiyuting
  Date: 2018/3/29
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/login" method="POST" id="loginForm" name="loginForm">
    用户id：<input type="text" name="id" id="id"><br>
    密&nbsp;码：<input type="text" name="password" id="password"><br>
    <button type="submit" id="subBut">登录</button>
    <button type="reset" id="resBut">重置</button>
  </form><br>
  </body>
</html>
