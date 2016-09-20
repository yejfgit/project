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
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="../survey/js/common.js"></script>
		<script language="javascript" src="../survey/js/boxover.js"></script>
</head>
<body>
<form name="form1" action="mail.do?method=sendMail" method="post" onSubmit="return done()">
<input type="hidden" id="deptId" name="deptId" value="<bean:write name="dept" property="id" />">
<table width="100%" height="24"  border="0" cellpadding="0" cellspacing="0" background="images/index_02.gif">
  <tr>
    <td class="bigtitlebg">&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/icon_05.gif" width="16" height="17"><span class="bigtitle">&nbsp; 下发问卷</span></td>
  </tr>
</table>
<table >
<tr><td>&nbsp;</td></tr>
<tr>
<td style="font-size:14px;"><strong>&nbsp;&nbsp;选择问卷：</strong></td>
<td> <html:select name="userForm" property="name1">
     	    <html:optionsCollection  name="surveyLabelList"/>
    </html:select></td>
</tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</table>
<table width="100%" border="0" align="center" cellpadding="2"
				cellspacing="0" style="table-layout:fixed">
<tr><td style="font-size:14px;">&nbsp;&nbsp;<strong>选择考生：</strong></td></tr>
<tr>

<td>&nbsp;</td>
<td align="center">
<select id="availableBox" multiple="multiple" size="30"  style="width:100px" ondblclick="addOne('availableBox')">
  <logic:iterate id="element" name="userList" >
  <option value="<bean:write name="element" property="id" />"><bean:write name="element" property="realName" /></option>
  </logic:iterate>
</select>
</td>
<td align="center">
<table>
<tr><td align="center"><input type="button" value=">" onclick="addOne('availableBox')"></td></tr>
<tr><td align="center"><input type="button" value=">>" onclick="addAll('availableBox')"></td></tr>
<tr><td align="center"><input type="button" value="<" onclick="delOne('selectedBox')"></td></tr>
<tr><td align="center"><input type="button" value="<<" onclick="delAll('selectedBox')"></td></tr>
</table></td>
<td align="center"><select  id="selectedBox" name=selectedBox multiple="multiple"  style="width:100px" size="30" ondblclick="delOne('selectedBox')">
</select>
</td>
<td>&nbsp;</td>
</tr>
<tr>
<td height="10px">&nbsp;</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td align="center">
<input type="button" class="btn-02" value="下发问卷" onclick="doSubmit()"></td></tr>
</table>
</form>
</body>
</html>


<script>

function exists(id, optVal) {
var box=g(id);
  for(var j=0; j<box.length; j++) {
    if(box.options[j].value==optVal) {
      return true;
    }
  }
  return false;
}

function addOne(id) {
  var srcbox=g(id);
  for(var i=0; i<srcbox.length; i++) {
//alert('i=' + i);
    if(srcbox.options[i].selected==true) {
      insertOne('selectedBox',srcbox.options[i]);
    }
  }

}

function addAll(id) {
  var srcbox=g(id);
  for(var i=0; i<srcbox.length; i++) {
    insertOne('selectedBox',srcbox.options[i]);
  }

}

function insertOne(id, opt) {
  if(exists(id, opt.value)) {
    return false;
  }
  var destbox=g(id);
  destbox.add(new Option(opt.innerHTML, opt.value));
}


function delOne(id) {
  var box=g(id);
  for(var i=0; i<box.length; i++) {
    if(box.options[i].selected==true) {
        box.remove(i);
	i--;
    }
  }

}

function delAll(id) {
  var box=g(id);
  box.length=0;
}


function doSubmit() {
  
	if (document.getElementsByName('name1')[0].value == '') {
		alert('请选择问卷');
		return false;
	}

  

  var box=g('selectedBox');
  var msg='';
  for(i=0; i<box.length; i++) {
    msg+=box.options[i].value + ';';
  }
  //alert(msg);
  
  if (msg == '') {
		alert('请选择答卷用户');
		return false;
	}

  if (!confirm('确实要下发问卷吗？')) {
		return false;
  }


   document.form1.action = 'mail.do?method=sendMail&msg=' + msg;
   document.form1.submit();
   done()
}


function g(id) {
  return document.getElementById(id);
}

function done(){
		window.showModalDialog("../survey/jsp/survey/done.htm", 
		window, 'dialogWidth:240px;dialogHeight:180px;Resizable:0;help:no;scroll:yes;status:No;center:yes;edge:Raised;');

}
</script>