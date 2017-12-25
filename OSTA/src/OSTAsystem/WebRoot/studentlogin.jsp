<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>OSTA考试系统</title>
<style>
input{width:200px; height:28px; margin-top:10px; border:1px solid #999}
marquee{color: #F00; width:98%; height:10%;font:20px Tahoma, Geneva, sans-serif}
#d{ width:50%; height:50%;border:2px solid #999; border-radius:50px; background-color: #CCC; margin-top:10%; margin-left:20%}
select{width:200px; height:30px}
.inp{width:100px; height:40px; background-color:#0CF}
.inp1{width:100px; height:40px; background-color:#06F; margin-left:30px; margin-bottom:20px}
.inp2{margin-left:30px}
</style>
</head>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function(){
$("#inp").val(''); 
});

</script>
<body>
<marquee>欢迎来到厦门市职业技能鉴定中心，请核实好个人各项信息，按提示开始答卷！</marquee>
	
	<div align="center" id="d">
    <h2>厦门市职业技能鉴定中心--学生考试系统</h2>
    <hr />
		<form action="StudentLoginServlet" onsubmit="return check()" method="post">
        
            
            考试名称：<select> 
       <option selected="selected">初级作业员</option> 
            
		</select><br />
            
			准考证号：<input id="inp"  name="accurate" type="text"/><br />
            
			身份证号：<input id="inp" name="card" type="text" /><br />
            
			姓 名：<input id="inp" name="uname" type="text" class="inp2"/><br>  
                    
			<input type="submit" value="登录" class="inp"/>
            <input type="reset" value="重置" class="inp1"/>         
            
		</form>
		</div>
</body>
</html>
