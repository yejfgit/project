<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript">
 parent.document.getElementById("loading").style.display = 'none';
parent.document.getElementById("tips").style.display = 'none';
window.onload=function(){
	var type=document.getElementById("type").value;
// 	alert(type);
	if(type==1)
	{
		history.go(-1);
		//  window.parent.frames[0].location.reload();
	if(!window.name){
        window.name = 'test';
        window.parent.frames[0].location.reload();
      }
     }
}
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #0D2A4C;
	margin: 0px;
	background-color:#f8f8f0;
}
</style>
</head>

<body > 
<table>
	<logic:notEmpty name="missionId" >
	<input type="hidden" name="missionId" id="missionId" value="<bean:write name="missionId" />" />
	</logic:notEmpty>
	<logic:notEmpty name="leftTime" >
	<input type="hidden" name="leftTime" id="leftTime" value="<bean:write name="leftTime" />" />
	</logic:notEmpty>
	<logic:notEmpty name="answerInfo" >
	<input type="hidden" name="answerInfo" id="answerInfo" value="<bean:write name="answerInfo" />" />
	</logic:notEmpty>
	<logic:notEmpty name="type" >
	<input type="hidden" name="type" id="type" value="<bean:write name="type" />" />
	</logic:notEmpty>
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr><td width="35%"></td>
  <td>
			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" background="">
				<tr valign="middle">
					<td class="bigtitlebg" valign="bottom">
                       <Strong>温馨提示：<bean:write name="info" /></Strong>
					</td>
					
				</tr>
			</table>
	</td></tr>
</table>
</body>
</html>

