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
	table{ width:80%; height:70%; text-align:center}
	tr{ height:50px}
	#p-d{width:90%; height:20%; border:5px solid #999; margin-left: 5%; margin-top:20px}
	#p-d1{width:90%; height:65%; border: 5px solid #999; margin-left:5%; margin-top:20px}
	#p-d2{width:90%; height:10%; margin-left:5%}
	.p-i3{ width:120px; height:50px; background-color:#CCC}
	.p-b{width:100px; height:40px; background-color:#CCC; margin-left:30%}
	.p-b2{width:100px; height:40px; background-color:#CCC; margin-left:15%}
	.button{background:#380;  width:70px;  height:40px;  line-height:22px; color:#fff}
form { height:100px; margin-bottom:100px;margin-left:35%}  
input.file{  
    vertical-align:middle;  
    position:relative;  
    left:-218px;  
    filter:alpha(opacity=0);  
    opacity:0;  
    z-ind1ex:1;  
    *width:223px;
	border:1px solid #999;
	margin-left:20px

}  
  form input.viewfile {  
    z-index:99;  
    border:1px solid #999;  
    padding:2px;  
    width:250px; 
	height:30px;
    vertical-align:middle;  
    color:#999; 
	float:left;
	margin-left:20px
}  
  form input.submit {  
    border:0;  
    background:#380;  
    width:70px;  
    height:35px;  
    line-height:22px;  
    color:#fff;  
    cursor:pointer; 
	

}   
</style>
</head>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#fimport').on('click',function(){
		var a=prompt("请输入密码!");
		var form=new FormData(document.getElementById("myform"));
		$.ajax({
			type:"POST",
			url:"UploadServlet",
			datatype:"json",
			data:form,
			processData:false,
            contentType:false,
			success:function(backdata){
			},
			error:function(e){
				alert("错误！");
			}
		});
		
	});	
	});
</script>
<body>
	<div id="p-d">
    	<h2>试卷导入</h2>
       <form id="myform" action="FileUpServlet" method="post" name="upfiles" enctype="multipart/form-data">  
	<input type="text" name="viewfile" id="viewfile" class="viewfile" />   
    <button class="button">浏览</button></label>
    <input  type="file" size="27" name="upload" onchange="document.getElementById('viewfile').value=this.value;" class="file" />  

<input id="fimport" class="submit" type="button" value="导入" /> 
</form>  
    </div>
    <div id="p-d1">
    	<h2>试卷信息</h2>
        <table>
        	<tr>
            	<td>考试名称：</td><td id="name"></td><td>考试试卷：</td><td id="grade"></td>
            </tr>
        	<tr>
            	<td>考试时间：</td><td id="time"></td><td>考试类型：</td><td id="type"></td>
            </tr>
            <tr>
            	<td>鉴定工种：</td><td id="work"></td><td>鉴定机构：</td><td id="mechanism"></td>
            </tr>
            <tr>
            	<td>鉴定等级：</td><td id="level"></td><td>及格分数：</td><td id="no" ></td>
            </tr>
            <tr>
            	<td>考生人数：</td><td id="renshu"></td>
            </tr>
        </table>
        <a><button id="refresh" style="width:100px; height:40px; background-color:#CCC;" >刷新</button></a>
        <a href="PreviewServlet?action=pretest"><button class="p-b">预览试卷</button></a>
        <a href="PreviewServlet?action=prestudent"><button  class="p-b2">预览考生信息</button></a>
    </div>
	<div align="center" id="p-d2">
    	<a href="PreviewServlet?action=confirm"><button class="p-i3">确认考试信息</button></a>
    
    </div>
</body>
<script>
     $("#refresh").click(function(){
	 	$.ajax({
	 		  //提交数据的类型 POST GET
            type:"post",
            //提交的网址
            url:"PreviewInfoServlet",
            //提交的数据
            data:{
            },
            //返回数据的格式
             dataType: "json",//"xml", "html", "script", "json", "jsonp", "text". 
            //成功返回之后调用的函数             
            success:function(data){
            $("#name").html(data.name);
	           $("#test").html(data.test);
	           $("#grade").html(data.grade);
	           $("#time").html(data.time);
	           $("#type").html(data.type);                         
	           $("#work").html(data.work);
	           $("#mechanism").html(data.mechanism);
	           $("#level").html(data.level);
	           $("#no").html(data.no);
	           $("#renshu").html(data.renshu);
	         	
            },
            error:function(e){
                alert("错误！！");
            }
	 	});
	 });
    </script>
</html>
