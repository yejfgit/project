<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<SCRIPT LANGUAGE="JavaScript">

function ckAll(){
   var cbs = form1.getElementsByTagName("input");
   var qx = document.getElementById("qx");
   for(i=0;i<cbs.length;i++){
      if(cbs[i].type=="checkbox"){
         cbs[i].checked = qx.checked;
        }
       }
    }

function getAttachmentExt() {
	alert('a');
	var ckb = document.getElementsByName('checkBox1');
	alert(ckb.length);
	var s = '';
	for (var i = 0; i < ckb.length; i++) {
		if (ckb[i].checked) {
			s += ckb[i].value + ';';
		} 
	}
	alert(s);
	return s;	
}
  
function sendMail(){

    //var s1=document.getElementById("checkBox1").value;
 	  //alert(s1);
	var ckb = document.getElementsByName('checkBox1');
	var s = '';
	for (var i = 0; i < ckb.length; i++) {
		if (ckb[i].checked) {
			s += ckb[i].value + ';';
		} 
	}
   document.form1.target="_self";
   document.form1.action="mail.do?method=sendMail";
   document.form1.submit();
}
    
</SCRIPT>
</head>

<body>

survey project success!

<form name="form1" action="mail.do?method=sendMail" method="post"
			enctype="multipart/form-data" onSubmit="return check();">
<table>
<tr>
<td>选择考生:</td>
    <td align="center">全选：<input type="checkBox"  id="qx" onclick="ckAll()" ></td>
    <td align="center"><input name="Submit" type="button" class="btn-02" value="发出邀请" onclick="sendMail()"></td>
</tr>
</table>
<logic:iterate id="element" name="userList" >
<table  border="0" cellpadding="0" cellspacing="0">
<tr>
<td><bean:write name="element" property="realName" /></td>
<td><input type="checkBox" id="checkBox1" name="checkBox1" value="<bean:write name="element" property="id" />"/>
</tr>
</table>
</logic:iterate>
</form>
</body>
</html>

