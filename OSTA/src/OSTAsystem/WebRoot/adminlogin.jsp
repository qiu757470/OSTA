<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OSTA劳动技能鉴定考试系统</title>
<style>
	html,body{ width:98%; height:98%}
	#d{ width:50%; height:55%; border:solid 5px #CCC; background-color:#CCC;border-radius:30px; margin-left:300px;}
	.t{width:150px; height:30px; border:solid #999; margin-top:15px}
	.t1{width:80px; height:30px;border:solid #999; margin-top:10px}
	.login{width:88px; height:40px; margin-top:40px; background-color:#999}
	.reset{width:88px; height:40px; margin-top:40px; margin-left:40px; background-color:#999}
</style>


</head>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function(){
$("#inp").val(''); 
});

</script>
<script>
var code="" ; //在全局 定义验证码
function createCode(){ 
code = "";
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("checkCode");
checkCode.value = "";
var selectChar = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
     'S','T','U','V','W','X','Y','Z');
for(var i=0;i<codeLength;i++) {
var charIndex = Math.floor(Math.random()*32);
code +=selectChar[charIndex];
}
if(code.length != codeLength){
createCode();
}
document.getElementById("checkCode").innerHTML = code;
}
function validate () {
var inputCode = document.getElementById("checkNum").value.toUpperCase();
if(inputCode.length <=0) {
alert("请输入验证码！");
return false;
}
else if(inputCode != code ){
alert("验证码输入错误！");
createCode();
return false;
}
else {
alert("验证码通过！");
return true;
}
}

</script>
<body onload="createCode();">
<div align="center" id="d"  >
	<form id="form1" action="AdminLoginServlet" method="post">
	<h1>考试登陆系统</h1>
	<hr />
   	 	账号：<input id="inp" name="acc"  size="20"type="text" class="t" /><br>
        
       	 密码：<input id="inp" name="pwd"  size="20"type="password"  class="t"/><br>
        
       	 验证码：<input  type="text"name="code" class="t1"id="checkNum"/>
        <a id="checkCode" onclick="createCode()" style=" background-color:#FFF; padding:9px 20px; margin-left:10px"></a><br>
 		 <input type="submit"value="登陆"  class="login" id="gotoCheck"onclick="validate();" />
         <input type="reset"value="重置"  class="reset"/>
    </form>
     </div>
</body>
</html>
