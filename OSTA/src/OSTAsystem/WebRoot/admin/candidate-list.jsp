<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
	table{ width:98%; height:50%; border:solid #666; border-collapse:collapse; margin-left:10px}
	tr,th,td{ width:20px; height:10px; border:solid #666; text-align:center}
</style>
</head>

<body>

 <div  style="width:90%; height:90%; margin-left:5%; border:5px solid #999">
 <h2>考生预览：</h2>
 	<table>
    	<tr>
        	<th>序号</th>
        	<th>姓名</th>
        	<th>身份证号</th>
        	<th>准考证号</th>
        	<th>考试名称</th>
        	<th>鉴定等级</th>
        </tr>
        <c:forEach items="${STUINFO}" var="item">
        <tr>
	    	<td>${item.stu_info_id}</td>
	    	<td>${item.stu_info_name}</td>
	    	<td>${item.stu_info_identity}</td>
	    	<td>${item.stu_info_ticket}</td>
		    <td>${items.test_paper_name}</td>
		    <td>${items.test_paper_level}</td> 
	    	
    	</tr>
    	</c:forEach>
        
    </table>
 
 </div>

</body>
</html>
