<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'paperpreview.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script  src="js/jquery.min.js"></script>
<style>
.content {width: 100%;border: 2.7px #000 solid;border-radius: 8px;background-color: #e7e7e7;
}
.button {display: inline-block;outline: none;cursor: pointer;color: #000;background: #D0EEFF;margin-left:75%;
margin-top:30%;text-align: center;text-decoration: none;font: 14px/100% Arial, Helvetica, sans-serif;
padding: .5em 2em .55em;border-radius: .5em;-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);box-shadow: 0 1px 2px rgba(0, 0, 0, .2);}
.button:hover {text-decoration: none;background: #AADFFD;border-color: #78C3F3;color: #004974;}
.button:active {position: relative;top: 1px;}
.right{background-color:#e7e7e7;border: 1px #666 solid;width:30%;height:auto;margin:0;margin-top:3%;
margin-right:5%;margin-left:65%;float:right;position:fixed;}
p{margin-left: 3%;}
#lab1{margin-left: 30%;}
table {width:90%; height:20%;margin-top:3%;margin-left: 6%;text-align:center;}
td {border:1px #0099FF solid;}
#submit{width: 20%;margin-top: 4%;margin-left: 42%; background-color: #4a77d4; border: 1px solid #3762bc;    
color: #fff;padding: 8px 15px; font-size: 15px; line-height: normal; border-radius: 6px;display: inline-block;
outline: none;cursor: pointer;}
#submit:hover{background-color:#F60;color:#fff;}
#submit:active {position: relative;top: 1px;}
#log{border:2px #666 solid;background-color:#FFF;width: 80%;height:auto;text-align: center;}
li {list-style: none;display:inline-block;white-space:nowrap;margin-left:5%;}
#u1 {float: left;display:inline-block;vertical-align:top;margin-top: -0.5%;}
#u2 {float: left;display:inline-block;vertical-align:top;margin-left: 1%;}
#left{width: 69%;height:auto;margin-top:1%;margin-left:0.2%;margin-right:0.2;float:left;}
	
</style>
  </head>
  
  <body>
   <div class="content">
       
		<div id="left" align="center">
        	<div id="head" align="center">
				<div id="log" align="center">
					<Strong style=" margin:0; border:0;">职业技能鉴定国家题库</Strong>
					<h2 style="margin:0; padding:0; color:#000">${TESTPAPER.test_paper_name}</h2>
				</div>
			
				<div id="" align="center">
					<label>科目代码:${TESTPAPER.test_paper_grade}</label>&nbsp;&nbsp;
					<label>科目名称:${TESTPAPER.test_paper_work}</label>&nbsp;&nbsp;
					<label>准考证号:NO</label>&nbsp;&nbsp;
					<label>考生姓名:XXX</label>&nbsp;&nbsp;
				</div>	
			</div>
			<div style=" height:auto; text-align:left; margin-left:5%;">
				<c:forEach items="${requestScope.TESTANSWERONE}" var="question">
					<strong></strong>
					<a name="a001" id="a001"></a>
					<p>${question.test_answer_type}</p>
					<p>${question.test_answer_no}</p>
					<p>${question.test_answer_tigan}</p>
					<p>A、${question.test_answer_a}</p>
					<p>B、${question.test_answer_b}</p>
					<p>C、${question.test_answer_c}</p>
					<p>D、${question.test_answer_d}</p>
					<form id="做题中提交的" action="" method="post">
						<li><input type="radio" value="A" name="题号">A</li>
						<li><input type="radio" value="B" name="题号">B</li>
						<li><input type="radio" value="C" name="题号">C</li>
						<li><input type="radio" value="D" name="题号">D</li>
					</form>
				</c:forEach>


			</div>
		</div>

   
   <div class="right" >
			<h2 align="center">注意事项</h2>
			<p>1.本试卷依据2005年颁布的《数控车工》国家职业标准命制，考试时间:120分钟。</p>
			<p>2.请在考试之前核对自己的姓名，准考证号和所在单位的名称。</p>
			<p>3.请仔细阅读答题要求，在规定位置填写答案。</p>
			&nbsp;&nbsp;
			<label>剩余时间:45:00</label>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
			<label id="lab1">题目导航栏</label>
			<form action="">
			<table cellspacing="0px" id="tid">
				<tr>
					<td><a href="#a001">1</a></td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
					<td>7</td>
					<td>8</td>
					<td>9</td>
					<td>10</td>
				</tr>
				
				<tr>
					<td>11</td>
					<td>12</td>
					<td>13</td>
					<td>14</td>
					<td>15</td>
					<td>16</td>
					<td>17</td>
					<td>18</td>
					<td>19</td>
					<td>20</td>
				</tr>
				
				<tr>
					<td>21</td>
					<td>22</td>
					<td>23</td>
					<td>24</td>
					<td>25</td>
					<td>26</td>
					<td>27</td>
					<td>28</td>
					<td>29</td>
					<td>30</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
			</table>
		
		
			<ul id="u2">
				<li>共&nbsp;130&nbsp;题;</li>&nbsp;&nbsp;  
				<li>已答&nbsp;5&nbsp;题;</li>&nbsp;&nbsp;  
				<li>剩余&nbsp;125&nbsp;题;</li>&nbsp;&nbsp;  
			</ul>
		<input type="submit" value="提交" id="submit"/>
		</form>
		
		</div>
   
        <div>
			<a href="newexam.jsp"><button class="button" type="button">返回上一页</button></a>
		</div>
		
        <div>
  </body>
</html>