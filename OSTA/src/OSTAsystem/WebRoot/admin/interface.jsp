<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
	html,body{ width:100%; height:98%}
	#d{width:100%; height:20%; background-color:#999}
	#d1{width:100%; height:20%; background-color:#999}
	#d2{width:100%; height:40%; background-color:#9F0; background-image:url(001.jpg)}
	#d3{width:100%; height:20%; background-color:#999}
	.time{margin-left: 800px}
	.b{width:150px; height:50px; margin-left:30%; background-color:#CCC}
	.b1{width:150px; height:50px; margin-left:15%;background-color:#CCC}
</style>
</head>
<script>
	var timer;
		function start(){
			var t = new Date();
			var y = t.getFullYear();
			var mon = t.getMonth()+1;
			var d = t.getDate();
			var h = check(t.getHours());
			var mi = check(t.getMinutes());
			var s = check(t.getSeconds());
			document.getElementById("time").innerHTML = y+"年"+mon+"月"+d+"日"+h+":"+mi+":"+s;
			timer = setTimeout('start()',1000);
		}
		
		function check(i){
			if(i<10){
				i = "0"+i;
			}
			return i;
		}
	window.onload = function(){
		start();
	}
</script>
<body>
	<div  align="center"id="d">
    	<h1>${sessionScope.xiamen}--鉴定站考试管理系统欢迎你！</h1>
        <span id="time" class="time">2017年6月28日20：49：09</span>
    	<hr />
    </div>
	<div id="d1">
    	<a href="InterfaceServlet?action=addtest"><button  class="b">新建考试</button></a>
    	<a href="InterfaceServlet?action=help"><button class="b1">帮助</button></a>
    </div>
    <div id="d2">
    </div>
    <div align="center" id="d3">
    	<h4>传一在线</h4>
    
    </div>
</body>
</html>
