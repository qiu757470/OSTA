<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
      <script  src="js/jquery.min.js"></script>
    <title>My JSP 'studentmain.jsp' starting page</title>
   <style>
.first{
	opacity: 0.8;
	position: absolute;
	width: 99%;
	height: 98%;
	overflow: hidden;
	border:3px solid #000
}
.top { color:#333333; text-align:center; width:100%; font:italic bold 100px Georgia, "Times New Roman", Times, serif}
.down{ color:#333333; text-align:center; width:100%; font:italic bold 50px Georgia, "Times New Roman", Times, serif}
</style>

</head>

<body>
<div class="first">
<div class="top">信息核实</div>
<div>
    <table border="1" align="center" width="700" height="200">
  <tr>
  <td align="center">准考证号</td>
  <td align="center">${STUINFO.stu_info_ticket}</td>
  <td align="center"></td>
  <td align="center"></td>
</tr>
<tr>
  <td align="center">考生姓名</td>
  <td align="center">${STUINFO.stu_info_name}</td>
  <td align="center">身份证号码</td>
  <td align="center">${STUINFO.stu_info_identity}</td>
</tr>
 <tr>
  <td align="center">身份证号码</td>
  <td align="center">${STUINFO.stu_info_ticket}</td>
  <td align="center">400</td>
  <td align="center">500</td>
</tr>
<tr>
  <td align="center">考试科目代码</td>
  <td align="center">${TESTPAPERLIST.test_paper_grade }</td>
  <td align="center">考试科目名称</td>
  <td align="center">${TESTPAPERLIST.test_paper_name}</td>
</tr>
<tr>
  <td align="center">考试工种</td>
  <td align="center">${TESTPAPERLIST.test_paper_work }</td>
  <td align="center">等级</td>
  <td align="center">${TESTPAPERLIST.test_paper_level }</td>
</tr>
</table>
</div>
<div>
<p align="center">&nbsp;&nbsp;请核实上方表格中的信息是否属于个人信息，若信息正确则进入下一步考场信息核实！</p><br />
<p align="center">若信息错误请与考场的监考员联系！</p>
</div>
<div class="down">
考前须知
</div>
<div align="center">
<ol >
  <li >请认真核实考试信息</li>
  <li>请认真核实考场信息</li>
  <li>请遵守考场纪律</li>
</ol>
</div>
<a href="StudentLoginServlet?actio=stupreview" ><p align="center">等待考试中.....</p></a>
</div>
</body>
</html>