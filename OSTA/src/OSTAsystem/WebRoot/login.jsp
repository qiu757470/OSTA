<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
	button{ width:200px; height:200px;border-radius: 50%;background-color:#0FF}
	#d{float:left; margin-top:10%; margin-left:25%}
	#d1{margin-top:10%;margin-left:50%}
</style>
</head>

<body>
<div  align="center" id="d">
	<a href="adminlogin.jsp"><button><h2>管理员登录</h2></button></a>
</div>
<div id="d1">
	<a  href="studentlogin.jsp"><button><h2>学生端登陆</h2></button></a>
</div>
</body>
</html>