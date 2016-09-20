
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>" target="_self">
    
    <title>问卷下发</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
		function addUser(){

		window.showModalDialog("user.do?method=dispatchUserDialog" , window, 'dialogWidth:500px;dialogHeight:500px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
//		window.open("user.do?method=userDialog");
		intoUser();
		}
		
		function intoUser(){
		
		var id = document.getElementById("uid").value;
		var userName = document.getElementById("uname").value;
		   var optValue =id+',1';
		   
		   if(window.frames[2].exists('selectedBox', optValue)) {
			    return false;
  			}
	
		  var destbox=window.parent.frames[2].g('selectedBox');

 		  if(id!=""){
 			 destbox.add(new Option(userName, optValue));
 		}

	}
	
	function dispatchOut(){
		
		var id = document.getElementById("surveyId").value;
		window.showModalDialog("mail.do?method=toSendMailOutside&surveyId="+id , window, 'dialogWidth:600px;dialogHeight:470px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
		//window.open("mail.do?method=toSendMailOutside&surveyId="+id);
	}
	
	function doCloseAndRefresh(){
		window.close();
	}
	
	function queryPos(){
		var posName = document.getElementById("posName").value;
		var organId = document.getElementById("organ.umOrganId").value;
		
		window.frames[1].location.href="dispatch.do?method=addUsersByPosition&posName="+encodeURI(encodeURI(posName))+"&organId="+organId;
	}
	
</script>
  </head>
  <body>
  <input type="hidden" name="uid" id="iduid">
  <input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="surveyId" />">
  <input type="hidden" value="增加" onclick="intoUser()" />
  <table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<tr>
    <td height="30px" colspan="2" style="color:#0e9cdf;font-size:14px;vertical-align:middle;"><strong>&nbsp;&nbsp;首页 >> 下发 >> 选择用户</strong></td>
  </tr>
  </tr>
  <tr style="font-size: 16px">
    <td align="center" height="25px" width="15%"></td>
    <td align="center" width="65%">&nbsp;
    	<strong>问卷名称：<logic:notEmpty name="surveyName"><bean:write name="surveyName" /></logic:notEmpty></strong>
    </td>
	<td align="center" height="30px" width="20%"> </td>
  </tr>
</table>
  <table align="center" valign="middle">
  	<tr>
  		<td colspan="3">
  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="uname" id="iduname" value="点击选择用户" onmouseover="this.style.cursor='hand'"
		onclick="addUser()" readonly="true"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<html:select name="userForm" property="organ.umOrganId" onchange="queryPos()">
			<option value="21">全系统</option>
			<html:optionsCollection name="organLabelList"/>
		</html:select> 
		&nbsp;&nbsp;
		<input type="text" id="posName" value="请输入岗位名称" onclick="this.value='';">&nbsp;
  		<input type="button" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;" name="sub" value="查询" onclick="queryPos()">
  		</td>
  	</tr>
  	<tr>
  		<td align="right">
  			<table>
  			 <tr>
  				</td>
  			</tr>
  			<tr>
  				<td style="font-size:12px" height="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>机构选择框：</strong></td>
  			</tr>
  			<tr>
  			<td align="center">
    		<iframe marginwidth="0" marginheight="0" width="90%" height="188px" src="dispatch.do?method=left" name="left"> </iframe>
    		</td>
			<td width="70px">
    		&nbsp;
    		</td>
    		</tr>
    		<tr>
    		<td align="right" colspan="2">
    		<iframe scrolling="no" marginwidth="0" marginheight="0" frameborder="0"width="95%" height="188px" src="dispatch.do?method=middle" name="middle" ></iframe>
			</td>
			</tr>
			</table>  		
  		</td>
  		<td align="center">
  			<table cellpadding="0" cellspacing="0" valign="top">
  				<tr>
  					<td align="center">

  					</td>
  				</tr>
  				<tr>
  					<td align="center">
  						<iframe width="100%"  scrolling="no" marginwidth="0" marginheight="0" frameborder="0" height="388px" src="dispatch.do?method=right" name="right" ></iframe>
  					</td>
  				</tr>
  			</table>	
  		</td>
  	</tr>
  	<tr>

  	  	<td colspan="2" align="center">
  	  		&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="button" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;"  value="下发问卷" onclick="dispatchSurvey()">
  		</td>

  	</tr>

  </table>
  	<script>
  		//调用frame中right页面，执行权限限制。
  		function dispatchSurvey(){
  			window.frames[2].doSubmit(document.getElementById("surveyId").value);
  		}
  		
  	</script>
  </body>
</html>
