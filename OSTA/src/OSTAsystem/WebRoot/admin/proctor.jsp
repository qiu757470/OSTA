<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
table {
	width: 80%
}

#b {
	width: 50%;
	margin-top: 3%;
	margin-left: 25%;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 8px 15px;
	font-size: 15px;
	line-height: normal;
	border-radius: 6px;
	display: inline-block;
	outline: none;
	cursor: pointer;
}

<
style>.content {
	height:;
	width: 99.8%;
	border: 2.7px #000 solid;
	border-radius: 8px;
	background-color: #e7e7e7;
}

.top {
	width: 100%;
	height: 25%;
	background-color:;
	margin-top: 0.5%;
	width: 99.5%;
	height: 10%;
	border: 2px #000000 solid;
	color: #fff;
	text-align: center;
	text-shadow: 0 0 10px;
	letter-spacing: 5px;
}

.h1 {
	margin-top: 0.5%;
	width: 99.5%;
	height: 10%;
	border: 2px #000000 solid;
	color: #fff;
	text-shadow: 0 0 10px;
	letter-spacing: 5px;
	text-align: center;
}

#h1 {
	width: 100%;
	height: 40%;
	border: 2px #000000 solid;
	color: #fff;
	text-shadow: 0 0 10px;
	letter-spacing: 5px;
	text-align: center;
}

#h_left {
	width: 15%;
	height: 20%;
	background-color: #999999;
	margin-left: 0.1%;
	float: left;
}

.img {
	width: 70%;
	height: 50%;
	margin-top: 8%;
	margin-left: 5%;
}

#h_right {
	float: right;
	width: 74.8%;
	height: 58%;
	margin-top: -7%;
	background-color: ##FF0000;
	border: 1px #333333 solid;
}

li {
	list-style: none;
	display: inline-block;
	white-space: nowrap;
}

#u1 {
	float: left;
	display: inline-block;
	vertical-align: top;
	margin-top: 2.5%;
}

#center {
	width: 74%;
	height: 68%;
}

#c_left {
	margin-top: 0.1%;
	margin-left: -2.3%;
	float: left;
	width: 25%;
	height: 98%;
}

#l_box {
	border: 1px #000000 solid;
	margin-left: 10%;
	width: 80%;
	height: 100%;
}

#submit {
	width: 50%;
	margin-top: 3%;
	margin-left: 25%;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 8px 15px;
	font-size: 15px;
	line-height: normal;
	border-radius: 6px;
	display: inline-block;
	outline: none;
	cursor: pointer;
}

#submit:hover {
	background-color: #F60;
	color: #fff;
}

#submit:active {
	position: relative;
	top: 1px;
}

#c_right {
	width: 75%;;
	height: 99%;
	margin-top: 0.3%;
	margin-left: 25%;
	background-color: #0099FF;
	border: 1px #CCCCCC solid;
}

#box {
	width: 15%;
	height: 25%;
	border: 2px solid #e7eaec;
	font-size: 13px;
	margin-right: 0px;
	margin-left: 50px;
	margin-top: 15Px;
	margin-bottom: 0px;
	background-color: #999;
	float: left;
}
</style>

</head>
<script src="js/jquery.min.js"></script>

<script type="text/javascript">
	var isCheckAll = true;
	function checkAll(objName) {
		var objNameList = document.getElementsByName(objName);
		if (null != objNameList && isCheckAll) {
			alert("全选操作");
			for (var i = 0; i < objNameList.length; i++) {
				objNameList[i].checked = "checked";
			}
			isCheckAll = false;
		} else {
			alert("反选操作");

			for (var i = 0; i < objNameList.length; i++) {
				objNameList[i].checked = "";
			}
			isCheckAll = !isCheckAll;
		}

	}
</script>
<script type="text/javascript">
 function aa(){
		$.ajax({
			type:"POST",
			url:"ProctorServlet?action=stusta&time="+new Date().getTime(),
			datatype:"json",
			success:function(data){
			var studentlist=eval((data));
			for (var i = 0; i < studentlist.length; i++) {
					if (studentlist[i].STU_INFO_STA) {
						$("#state" + studentlist[i].STU_INFO_TICKET).html("等待登录");
						$("#box" + studentlist[i].STU_INFO_TICKET).css("background-color", "#999");
					} else if (studentlist[i].STU_INFO_STA == "2" || studentlist[i].STU_INFO_STA == "2") {
						$("#state" + studentlist[i].STU_INFO_TICKET).html("考试中");
						$("#state" + studentlist[i].STU_INFO_TICKET).html("等待考试");
						$("#box" + studentlist[i].STU_INFO_TICKET).css("background-color", "#FFF");
					} else if (studentlist[i].STU_INFO_STA == "3") {
						$("#state" + studentlist[i].STU_INFO_TICKET).html("作弊违纪");
						$("#box" + studentlist[i].STU_INFO_TICKET).css("background-color", "#F00");
					} else {
						$("#state" + studentlist[i].STU_INFO_TICKET).html("已交卷");
						$("#box" + studentlist[i].STU_INFO_TICKET).css("background-color", "#0F0");
					}
				}
			},
			error:function(e){
			alert("错误！");
			}
		});
}	
var t=self.setInterval("aa()",1000);	


</script>

<script type="text/javascript">
$(function(){//作弊违纪
	$(".stusta").on("click",function(){
		$.ajax({
			type:"POST",
			url:"ProctorServlet?action=cheating",
			datatype:"json",
			data:$("#myform").serialize(),
			success:function(data){
			},
			error:function(e){
			alert("错误！");
			}
		});
	
	});

  });
$(function(){ //强制交卷
	$(".mandatory").on("click",function(){
		$.ajax({
			type:"POST",
			url:"ProctorServlet?action=papers",
			datatype:"json",
			data:$("#myform").serialize(),
			success:function(data){
			},
			error:function(e){
			alert("错误！");
			}
		});
	
	});
    
});
</script>
<body >
	<div align="center"
		style="width:99%; height:10%; border:2px solid #999">
		<h1>${TESTPAPERS.test_paper_mechanism}--鉴定站考试管理系统欢迎你！</h1>
	</div>
	<div
		style="width:99%; height:20%; border:2px solid #999; margin-top:10px">
		<h3>考试名称</h3>
		<table>
			<tr>
				<td>考试类型:</td>
				<td>${TESTPAPERS.test_paper_type}</td>
				<td>考试时间:</td>
				<td>${TESTPAPERS.test_paper_time}</td>
				<td>考生人数:</td>
				<td>10人</td>
				<td>鉴定级别:</td>
				<td>${TESTPAPERS.test_paper_level}</td>
				<td>鉴定工种：</td>
				<td>${TESTPAPERS.test_paper_work}</td>
			</tr>
		</table>
	</div>
	<div
		style="width:20%; height:90%; border:2px solid #999; margin-top:10px;float:left">
		<h3>考试状态</h3>
		等待考试
		<h3>考试时间倒计时</h3>
		<p id="timer" style="color:#F00">00:00:00</p>
		<form>
			<p>
				<input type="button" id="b" class="start" name="start" onclick="Start()"
					value="开始考试" />
			</p>
			<p>
				<input type="button" id="b" class="mandatory" name="mandatory"
					value="强制交卷" />
			</p>
			<p>
				<input type="button" id="b" class="stusta" name="cheating"
					value="作弊" />
			</p>
			<p>
				<input type="button" id="b" class="stusta" name="discipline"
					value="违纪" />
			</p>
			<p>
				<input type="button" id="b" name="suspended" value="暂停考试" />
			</p>
			<p>
				<input type="button" id="b" name="export" value="导出成绩" />
			</p>
		</form>
	</div>
	<div
		style="width:78%; height:90%; border:2px solid #999;margin-top:10px; margin-left:10px; float:left">
		<div id="" style="margin-top: 3%;">
			<label style="margin-left: 5%;">考生列表:&nbsp;</label> <label
				class="choice"><input type="checkbox"
				onclick="checkAll('stu')" />全选/全不选</label>

		</div>
		<form id="myform"method="post" action="ProctorServlet">
		<c:forEach items="${STUDENT}" var="item">
			<div id="box" class="box">
				<input type="checkbox" name="stu" /> <img
					style="width: 50px; height: 50px;" />
				<div style="margin-left: 5%; font-size: 14px">
					<label>准考证号:${item.stu_info_ticket}</label><br /> 
					<label>姓名:${item.stu_info_name}</label><br />
					<label id="state">状态:${item.stu_info_sta}</label><br /> 
					<label>成绩:${item.stu_info_grade}</label>
				</div>

			</div>
		</c:forEach>
	</form>
	</div>
</body>
<Script LANGUAGE="JavaScript">
	function Start() {
		var maxtime;
		if (window.name == '') {
			maxtime = 1 * 7200;
		} else {
			maxtime = window.name;
		}

		function CountDown() {
			if (maxtime >= 0) {
				hours = Math.floor(maxtime / 3600);
				minutes = Math.floor((maxtime - hours * 3600) / 60);
				seconds = Math.floor(maxtime % 60);
				msg = "距离考试结束还有" + hours + "时" + minutes + "分" + seconds + "秒";
				document.all["timer"].innerHTML = msg;
				if (maxtime == 5 * 60)
					alert('注意，还有5分钟!');
				--maxtime;
				window.name = maxtime;
			} else {
				clearInterval(timer);
				alert("考试时间到，结束!");
			}
		}
		timer = setInterval(CountDown, 1000);
	}
	function StopTime() {
		result = true;
	}
</script>
</html>
