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

<form action="<%=basePath%>/pages/back/emp/add.action" method="post">
雇员编号：<input type="text" name="empno" id="empno" value="1234"/>
雇员姓名：<input type="text" name="ename" id="ename" value="smith"/>
雇员工资：<input type="text" name="salary" id="salary" value="800.0"/>
雇佣日期：<input type="text" name="hiredate" id="hiredate" value="2018-08-11"/>
部门名称：<input type="text" name="dept.dname" id="dept.dname" value="财务部"/>
<input type="submit" value="提交">
</form>

</body>
</html>
