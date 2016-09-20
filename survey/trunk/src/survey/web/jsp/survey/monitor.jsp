<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html>
	<head>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../survey/js/common.js"></script>
		<script language="javascript" src="../survey/js/boxover.js"></script>
		<script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
		<script language="javascript" src="js/jquery-1.7.1.min.js"></script>
		<script LANGUAGE="JavaScript">
function closed(id)
{   
	if(confirm("确定要关闭？")) 
	{
		window.location.href("mission.do?method=closeMission&missionId=" + id);
	}
}

function hurry(){
		
		var m = document.getElementsByName("missionId");
		var missionIds = "";
		
		for(var i=0;i<m.length;i++){
			if(m[i].checked==true){
				missionIds += m[i].value + ";";
			}	
		}
		if(missionIds.length==0){
			alert("请选择要催办的任务");
			return false;
		}
		var isCs="N";
		var cs = document.getElementById("chkCs");
		if(cs.checked==true)
		{
			isCs="Y";
		}		
		if(confirm("您确定要催办所选问卷么"))
		{
			//window.location.href("mission.do?method=hurry&missionIds="+missionIds+"&isCs="+isCs);
			document.getElementById("missionIn").value=missionIds;
			window.form1.action="mission.do?method=hurry&isCs="+isCs;
			window.form1.submit();
			
			
			done();
			doQuery();
		}
}


function checkCs(){
	var cs = document.getElementById("chkCs");
	if(cs.checked==true){
		cs.checked = false;
	}else{
		cs.checked = true;
	}	
}
function closeAll(){
		var m = document.getElementsByName("missionId");
		var missionIds = "";
		
		for(var i=0;i<m.length;i++){
			if(m[i].checked==true){
				missionIds += m[i].value + ";";
			}	
		}
		
		if(missionIds.length==0){
			alert("请选择要关闭的任务");
			return false;
		}
		if(confirm("您确定要关闭所选问卷么？"))
		{	
		
		window.location.href("mission.do?method=close&missionIds="+missionIds);
		done();
		doQuery();
	}
}

function selectDeptTree() {
		//window.open("../survey/jsp/report/queryDeptTree.htm")
		
	

		//window.showModalDialog("../survey/jsp/report/queryDeptTree.htm", 
		var re = window.showModalDialog("../survey/user.do?method=deptTreeQuery&_n=" + Math.random(), 
		window, 'dialogWidth:250px;dialogHeight:500px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');
		document.getElementById("selectDeptId").value = re[0];
		document.getElementById("deptName").value = re[1];
		doQueryType('0,1,2,3,5');
	}
	
function doQuerys() {
	var surveyId = document.getElementById("surveyId").value;
	var deptId=document.getElementById("selectDeptId").value;
	//alert(deptId);
	document.all.form1.action = "mission.do?method=queryMonitor&surveyId="+surveyId+"&applyDeptId="+deptId;
	document.all.form1.submit();
}
function doQueryType(isClosed){
	var surveyId = document.getElementById("surveyId").value;
	var deptId=document.getElementById("selectDeptId").value;
	//alert(deptId);
	document.all.form1.action = "mission.do?method=queryMonitor&surveyId="+surveyId+"&applyDeptId="+deptId+"&isClosed="+isClosed;
	document.all.form1.submit();
}
function doReset(){
	var surveyId = document.getElementById("surveyId").value;
	window.location.href("mission.do?method=monitor&surveyId="+surveyId);
}

function checkAll(){
	//全部未完成问卷
	var a = document.getElementsByName("missionId");
	//控制全部checkBox
	var all = document.getElementById("chkAll");
	if(all.checked==true){
		for(var i=0;i<a.length;i++){
			a[i].checked=true;
		}
	}else{
		for(var i=0;i<a.length;i++){
			a[i].checked=false;
		}
	
	}

}

function reset(){
	document.getElementById("form1").reset();
}

function done(){
		window.showModalDialog("../survey/jsp/survey/done.htm", 
		window, 'dialogWidth:240px;dialogHeight:180px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');

}

function doSubmit(){
	window.location.href="survey.do?method=adminList";
}

//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}
//分页相关操作
function doQuery(pageNum){
	
	var surveyId = document.getElementById("surveyId").value;
	location.href = 'mission.do?method=monitor&surveyId='+surveyId+'&pageNum='+pageNum;
}
function nextPage() {

	pageNum = document.getElementsByName("pageNum")[0].value;
	if (pageNum == 0) {
		pageNum = 1;
	}
	document.getElementsByName("pageNum")[0].value = Math.abs(pageNum) + 1;
	//alert(document.getElementsByName("pageNum")[0].value);
	doQuery(Math.abs(pageNum) + 1);
}

function prevPage() {
	pageNum = document.getElementsByName("pageNum")[0].value;
	if (pageNum == 0) {
		pageNum = 1;
	}
	document.getElementsByName("pageNum")[0].value = Math.abs(pageNum) - 1;
	doQuery(Math.abs(pageNum) - 1);
}

function jumpPage() {

	pageNum = document.getElementsByName("jumpPageNum")[0].value;
	if (!(/^\d+$/g.test(pageNum))) {
		document.getElementsByName("jumpPageNum")[0].value = '';
		return false;
	}
	//alert(pageNum);
	document.getElementsByName("pageNum")[0].value = pageNum;
	doQuery(pageNum);
}
window.onload = function(){    
	if(location.search.indexOf("?")==-1){       
		location.href += "?myurl";
	 }
    else{
	     if(location.search.indexOf("myurl")==-1)
	      location.href += "&myurl";
    } 
} 
</SCRIPT>
<style>
　　html { 
　　overflow-y:auto!important; 
　　*overflow-y:scroll; 
　　} 
	
	.tables{
	width:80%;
	align:center;
	
	}
	
	.btn{
	background-color:#0e9cdf;
	height: 25px;
	color: white;
	border: 1px;
	border-color: #828282;
}
</style>
</head>

<body >
  	<form id="form1" name="form1" method="post" action="">
  				<input type="hidden" id="missionIn" name="missionIn"/>
  				<script src="../survey/js/SophyCalendar.js" charset="gb2312"
				type="text/javascript"></script>
<input type="hidden" id="surveyId" value="<bean:write name="surveyId" />">
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" class="titBar2">
  <tr>
  	 <td height="30px" colspan="1" class="titBar3">&nbsp;&nbsp;
   <a href="survey.do?method=WJList&type=2"  target="mainFrame">返回首页</a>
   </td>
   <td colspan="2" class="titBar">
   <a href="survey.do?method=edit&surveyId=<bean:write name="surveyId" />"  target="mainFrame">问卷设计</a>
    >><a href="dispatch.do?method=index&surveyId=<bean:write name="surveyId" />"  target="mainFrame">问卷下发</a>
    >><strong> <a href="mission.do?method=monitor&surveyId=<bean:write name="surveyId" />"  target="mainFrame">结果分析</a></strong> </td>
  </tr>
  </table>
   <table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" style="background-color: white;">
  <tr>
    <td width="50%" style="font-size: 18px" align="center" colspan="2">&nbsp;
    	<strong><bean:write name="surveyName" /></strong>
    </td>
  </tr>
</table>
<table width="80%" align="center" border="0" cellpadding="5" cellspacing="0">
<tr><td  width="95%" align="right"><div class="addButton" style="width:80px;"><a href="report.do?method=times&surveyId=<bean:write name="surveyId" />" onclick="" style="color: #fff">分数汇总&nbsp;&nbsp;&nbsp;</a></div></td>
      <td width="5%" align="right"> 
      <div class="addButton" style="width:80px;"><a href="report.do?method=requestDetail&surveyId=<bean:write name="surveyId" />" style="color: #fff" onclick="">下发明细&nbsp;&nbsp;&nbsp;</a> </div></td></tr>
		 <!--  <td width="" align="left" nowrap>
			开始时间：<input name="startDate" type="text" class="input1" id="startDate" style="width:100px; cursor: hand"
						onclick="calendar.show('startDate')" value="<logic:notEmpty name="startDate"><bean:write name="startDate" /></logic:notEmpty>" readonly>
						<img src="../survey/images/icon_06.gif" width="24" height="19" style="cursor: hand" align="absbottom" onclick="calendar.show('startDate')">
						&nbsp;&nbsp; 
		<td>
			结束时间：<input name="endDate" type="text" class="input1" id="endDate" style="width:100px; cursor: hand"
						onclick="calendar.show('endDate')" value="<logic:notEmpty name="endDate"><bean:write name="endDate" /></logic:notEmpty>" readonly>
						<img src="../survey/images/icon_06.gif" width="24" height="19" style="cursor: hand" align="absbottom" onclick="calendar.show('endDate')">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td>
			任务所属部门：<input name="applyDeptId" type="hidden" id="selectDeptId" value="<logic:notEmpty name="applyDeptId"><bean:write name="applyDeptId" /></logic:notEmpty><logic:empty name="applyDeptId">21</logic:empty>" />
					<input id="deptName" type="text" style="width: 200px;cursor: hand" readonly="true" value="<logic:notEmpty name="deptName"><bean:write name="deptName" /></logic:notEmpty><logic:empty name="deptName">合众人寿</logic:empty>" onclick="selectDeptTree()" />
					<img src="../survey/images/open.gif" width="16" height="16" style="cursor: hand" align="middle" onClick="selectDeptTree()">
		</td>
		<td align="center">	
				<input name="Submit" type="button" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" value=" 查询 "onClick="doQuery()">
				&nbsp;&nbsp;
                <input name="Reset" type="button" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" value="重置" onclick="doReset()" />
                &nbsp;&nbsp;
               </td>
	</tr>
	-->
	
</table>

<table align="center"  width="80%" style="background-color: white;margin-top: 15px;border: 1px solid #DDDEE3;" >
	<tr> <td class="tdTitle" colspan="3"><Strong>下发及完成情况：</Strong></td></tr>
	<tr>
		<td align="left" style="color:#0e9cdf;font-size: 14px; ">
		<br/><input name="applyDeptId" type="hidden" id="selectDeptId" value="<logic:notEmpty name="applyDeptId"><bean:write name="applyDeptId" /></logic:notEmpty><logic:empty name="applyDeptId">21</logic:empty>" />
		<div style="width:250px;float: left;"><input id="deptName" type="text" style="width: 200px;cursor: hand" readonly="true" value="<logic:notEmpty name="deptName"><bean:write name="deptName" /></logic:notEmpty><logic:empty name="deptName">合众人寿保险股份有限公司</logic:empty>" onclick="selectDeptTree()" />
		</div>
		<logic:iterate id="element" name="missionCondition" >
			
			<div style="background-color: #32CD32;width:100px;float:left;"><strong> <logic:equal value="0,1,5"  name="isClosed">&nbsp;&nbsp;<a href="#" onclick="doQueryType('0,1,5');" style="color: #fff;"> 未完成：<bean:write name="element" property="unFinishNum" /></a></logic:equal></strong></div>
			<div style="background-color: #99FF66;width:100px;float:left;"> <logic:notEqual value="0,1,5"  name="isClosed">&nbsp;&nbsp;<a href="#" onclick="doQueryType('0,1,5');" style="color: #000;"> 未完成：<bean:write name="element" property="unFinishNum" /></a></logic:notEqual></div>
			
			<div style="background-color: #32CD32;width:100px;float:left;"><strong> <logic:equal value="2"  name="isClosed">&nbsp;&nbsp;<a href="#" onclick="doQueryType('2');" style="color: #fff;"> 已完成：<bean:write name="element" property="finishNum" /></a></logic:equal></strong></div>
			<div style="background-color: #99FF66;width:100px;float:left;"> <logic:notEqual value="2"  name="isClosed">&nbsp;&nbsp;<a href="#" onclick="doQueryType('2');" style="color: #000;"> 已完成：<bean:write name="element" property="finishNum" /></a></logic:notEqual></div>
 			
 			<div style="background-color: #32CD32;width:100px;float:left;"><strong> <logic:equal value="3"  name="isClosed">&nbsp;&nbsp;<a href="#" onclick="doQueryType('3');" style="color: #fff;"> 已关闭：<bean:write name="element" property="closeNum" /></a></logic:equal></strong></div>
			<div style="background-color: #99FF66;width:100px;float:left;"> <logic:notEqual value="3"  name="isClosed">&nbsp;&nbsp;<a href="#" onclick="doQueryType('3');" style="color: #000;"> 已关闭：<bean:write name="element" property="closeNum" /></a></logic:notEqual></div>
			 <div style="width:30px;float:left;">&nbsp;</div>
			<div style="background-color: #32CD32;width:100px;float:left;"> <strong><logic:equal value="0,1,2,3,5"  name="isClosed">&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="doQueryType('0,1,2,3,5')" style="color: #fff;">全部：<bean:write name="element" property="allNum" /></a></logic:equal></strong></div>
			 <div style="background-color: #99FF66;width:100px;float:left;"><logic:notEqual value="0,1,2,3,5"  name="isClosed">&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="doQueryType('0,1,2,3,5')" style="color: #000;">全部：<bean:write name="element" property="allNum" /></a></logic:notEqual></div>
		</logic:iterate>                               
		
		</td>
	</tr>
</table>
<table width="80%" align="center" border="1" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;font-size:12px;background-color: white;margin-top: 0px;border: 1px solid #DDDEE3;">

<tr bgcolor="#828282">
<td width="4%" height="27" align="center" class="tabtitle"><input type="checkbox" id="chkAll" onclick="checkAll()"></td>
<td width="25%"  align="center"  class="tabtitle">机构名称</td>
<td width="6%"  align="center"  class="tabtitle">用户姓名</td>
<td width="15%"  align="center"  class="tabtitle">问卷名称</td>
<td width="5%"  align="center"  class="tabtitle">问卷状态</td>
<td width="12%"  align="center"  class="tabtitle">下发时间</td>
</tr>
<logic:notEmpty name="pagevo">
<logic:iterate id="element" name="pagevo" property="objectList" indexId="index1">
<tr>
<td align="center">
	<logic:equal value="1" name="element" property="isClosed">
    	<input type="checkBox" name="missionId" value="<bean:write name="element" property="missionId"/>">
	</logic:equal>
	<logic:equal value="0" name="element" property="isClosed">
    	<input type="checkBox" name="missionId" value="<bean:write name="element" property="missionId"/>">
	</logic:equal>
	<logic:equal value="5" name="element" property="isClosed">
    	<input type="checkBox" name="missionId" value="<bean:write name="element" property="missionId"/>">
	</logic:equal>
	&nbsp;
</td>
<td align="center"><bean:write name="element" property="deptFullName"/></td>
<td align="center"><bean:write name="element" property="realName" /></td>
<td align="center"><bean:write name="element" property="surveyName" /></td>
<td align="center">    
    <logic:equal value="1" name="element" property="isClosed">
    	未完成
	</logic:equal>
	<logic:equal value="0" name="element" property="isClosed">
    	未完成
	</logic:equal>
	<logic:equal value="5" name="element" property="isClosed">
    	未完成
	</logic:equal>
	<logic:equal value="2" name="element" property="isClosed">
    	已完成
	</logic:equal>
	<logic:equal value="3" name="element" property="isClosed">
    	已关闭
	</logic:equal>
</td>
<td align="center"><bean:write name="element" property="requestTime" format="yyyy-MM-dd HH:mm:ss" /></td>
</tr>
</logic:iterate>
</logic:notEmpty>
<logic:notEmpty name="pagevo">
<input type="hidden" name="pageNum" value="<logic:notEmpty name="pagevo"><bean:write name="pagevo" property="pageNum" /></logic:notEmpty><logic:empty name="pagevo">1</logic:empty>" />

<table width="80%" align="center" height="18"  border="0" bordercolor="#828282" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed;font-size:12px;background-color: white;margin-top: 0px;border: 1px solid #DDDEE3;">
  <tr>
    <td align="right">

		

			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0" style="table-layout:fixed;">
				<tr>
					<td align="right">
					第<bean:write name="pagevo" property="pageNum" />页
					共<bean:write name="pagevo" property="pageTotalNum" />页
					
					<logic:equal name="pagevo" property="hasPrevButton" value="1">
						<input type="button" name="bprev" value="上一页" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="prevPage();">
					</logic:equal>
					<logic:equal name="pagevo" property="hasPrevButton" value="0">
						<input type="button" name="bprev" value="上一页" style=" vertical-align:top;background-color:white" disabled="disabled">
					</logic:equal>
					<logic:equal name="pagevo" property="hasNextButton" value="1">
						<input type="button" name="bnext" value="下一页" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;border-color: #828282 " type="button" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" onClick="nextPage();">
					</logic:equal>
					<logic:equal name="pagevo" property="hasNextButton" value="0">
						<input type="button" name="bnext" value="下一页" style=" vertical-align:top;background-color:white" disabled="disabled">
					</logic:equal>
					&nbsp;&nbsp;
					转到第
					<input type="text" name="jumpPageNum" value="" size="1" onkeypress="if(event.keyCode==13){jumpPage();return false;}" />
					页
					<a href="javascript:void(0)" style="color: #333333;" onclick="jumpPage();return false;">确定</a>
					
					
					</td>
				</tr>
			</table>

	</td>
  </tr>
</table>

</logic:notEmpty>

</table>
<table align="center"  width="80%" style="background-color: white;margin-top: 15px">
   <tr>
  		<td class="tdTitle" colspan="4">问卷催办</td>
  </tr>
	<tr ><td colspan="4" ><span style="font-size: 14px;">邮件催办信息设置：<br/><br/></span>
			<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'hurryTips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 180 ;
			oFCKeditor.Value	= '<bean:write name="surveyForm" property="survey.hurryTips" filter="false"/>';
			oFCKeditor.Create() ;
		</script>
    </td></tr>
    
    <tr>
		<td colspan="4" width="80%" align="center">		
			<table width="100%">
				<tr>
				<td width="50%" align="left">
				<div class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" style="width: 90px;float: left;cursor: pointer;padding: 0 10px" onClick="checkCs()">
					<input type="checkbox" id="chkCs" onClick="checkCs()">抄送给自己
				</div>
				&nbsp;&nbsp;
				<input name="Reset" type="reset" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" value="批量催办" onClick="hurry()">
                                				&nbsp;&nbsp;
                <input name="Reset" type="reset" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)" value="批量关闭" onClick="closeAll()">
               </td>
                </tr>
               </table>
        </td>
	</tr>
</table>
</body>
</html>

