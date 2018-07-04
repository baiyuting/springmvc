<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script type="text/javascript" src="/js/addItem.js"></script>
</head>
<body>
<form action="/add"  method="post" enctype="multipart/form-data">
    内容：<input type="text" id="content" name="content"><br>
    图片：<input type="file" id="img" name="img"><br>
    投票项（一行对应一个选项）：<br>
    <textarea id="items" name="items">
    </textarea><br>
    <button type="submit">提交</button>
</form>


</body>
</html>