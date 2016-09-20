<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp" %>
<!DOCTYPE>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main_Top</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript"> 
 function show(){
	window.showModalDialog("http://10.17.2.3:8080/show/index.html" , window, 'dialogWidth:1024px;dialogHeight:768px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
}
function showNew(){
	window.showModalDialog("http://10.17.2.3:8080/show_new/index.html" , window, 'dialogWidth:1024px;dialogHeight:768px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
}

function goLibrary(){
	location.href="library.do?method=list";
}

var beObj;
function changBgStyle(obj,url){
	if(beObj!=null){
		beObj.className="tit2"
	}
	beObj = obj;
	if(obj.className=="tit2"){
		obj.className="tit2_c"
	}
	parent.document.getElementById("mainFrame").src=url;
}
</script>
</head>
<style>
a:hover { text-decoration: none;}
</style>
<body style="text-align:center">
<!-- 
<table width="100%" bgcolor="#C0C0C0">
	<tr>
		<td height="5px"></td>
	</tr>
	<tr>
		<td width="10%"></td>
		<td align="left" style="color:white;" width="22%"><a href="survey.do?method=adminList" target="mainFrame"><img src="../survey/images/log5.png"></img></a></td>
		<td width="5%"><a href="survey.do?method=WJList&type=2" target="mainFrame">问卷</a></td>
		<td width="5%"><a href="survey.do?method=WJList&type=1" target="mainFrame">考试</a></td>
		<td width="5%"><a href="#" onclick="show();return false;" target="mainFrame">帮助</a></td>
		<td align="right" width="45%" height="30" colspan="2">
			<table>
				<tr>
					<td align="center" height="32" colspan="2"style="font-size:25px;"><strong></strong></td>
				</tr>
				<tr>
					<td colspan="2"  align="center">
						&nbsp;<bean:write name="organName" />&nbsp;&nbsp;<bean:write name="userName" />&nbsp;&nbsp;|
						&nbsp;&nbsp;<a href="um_logout" style="color:#333333" target="_parent">退出</a>
						</td>
				</tr>
			</table>
		</td>
		<td width="15%"></td>
	</tr>
</table>
<table width="100%" style="height:8px" bgcolor="#A9A9A9">
	<tr>
		<td style="height:1px"></td>
	</tr>
</table>
<table width="100%" height="30px" bgcolor=#DCDCDC>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
 -->
 <div style="width: 100%;background-color: #6B5E33;color: #fff;">
 	<div style="width: 1024px;height: 20px;margin:0 auto;text-align: right;">
 		&nbsp;<!-- <bean:write name="organName" /> -->&nbsp;&nbsp;<bean:write name="userName" />&nbsp;&nbsp;|
						&nbsp;&nbsp;<a href="um_logout" style="color:#fff;" target="_parent">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	</div>
 </div>
 <div style="width: 100%;background-color: #fff;">
 	<div style="width: 1024px;height: 88px;margin:0 auto;border-bottom: 0px solid #377954">
 		<div style="width: 250px;float: left;margin-top: 20px">
 			<a href="survey.do?method=adminList" target="mainFrame"><img src="../survey/images/logNew.png" style="width: 250px;height: 80px"></img></a>
 		</div>
 		<div style="width: 250px;height: 40px;float: left;font-size: 14px;font-weight: bolder;line-height: 40px;margin-top: 40px;">
 			&nbsp;
 		</div>
 		<div class="tit1">
 			<div class="tit2" onclick="changBgStyle(this,'survey.do?method=WJList&type=2');"> 				
 				调查问卷
 			</div>
 		</div>
 		<div class="tit1">
 			<div class="tit2" onclick="changBgStyle(this,'survey.do?method=WJList&type=1');"> 				
 				考试
 			</div>
 		</div>
 		<div class="tit1">
 			<div class="tit2" onclick="changBgStyle(this);"> 				
 				<a href="#" onclick="show();return false;" target="mainFrame">帮助</a>
 			</div>
 		</div>
 		<div style="width: 200px;height: 40px;float: left;font-size: 14px;font-weight: bolder;line-height: 40px;margin-top: 40px;text-align: right">
 			
 		</div>
 	</div>
 </div>
</body>
</html>
