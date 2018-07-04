<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>

<form action="<%=basePath%>/pages/back/emp/upload.action" method="post" enctype="multipart/form-data">
雇员姓名：<input type="text" name="ename" id="ename"/>
部门名称：<input type="text" name="dept.dname" id="dept.dname"/>
雇员照片：<input type="file" name="photo" id="photo"/>
<input type="submit" value="提交">
</form>

</body>
</html>
