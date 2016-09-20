
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
    <base href="<%=basePath%>">
    
    <title>My JSP 'middle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style=" margin:0px; overflow:none;border-collapse:collapse;cellspacing:0;">
    <table align="center">
    <tr>
    <td style="font-size:12px;" align="center">
    <strong>待选人员及岗位</strong>
    </td>
    </tr>
    <tr>
    <td align="left">
    <select id="availableBox" multiple="multiple" style="border:5;width:200px" size="24" ondblclick="addOne('availableBox')">
	  
	  <!--<logic:notEmpty name="umOrgan">
 		 <option value="<bean:write name="umOrgan" property="umOrganId" />,2"><bean:write name="umOrgan" property="abbrName" /></option>
  	  </logic:notEmpty>
	  -->
	  <logic:notEmpty name="userList">
	    <logic:iterate id="element" name="userList" >
 		 <option value="<bean:write name="element" property="empId" />,1"><bean:write name="element" property="empName" />（<bean:write name="element" property="positionName" />）</option>
  	    </logic:iterate>
  	  </logic:notEmpty>
  	  
  	  <logic:notEmpty name="userPosList">
  	  	<logic:iterate id="element" name="userPosList" >
 		 <option value="<bean:write name="element" property="empId" />,1"><bean:write name="element" property="empName" />（<bean:write name="element" property="positionName" />）</option>
  	    </logic:iterate>
  	  </logic:notEmpty>

	</select>
	</td>
	<td width="20px">
	&nbsp;
	</td>
	<td align="right">
	<table align="right">
	<tr><td align="center"><input style="background-color:#9bcf00;height: 25px;color: white;border: 1px;"  type="button" value=" > " onclick="addOne('availableBox')"></td></tr>
	<tr><td align="center"><input style="background-color:#9bcf00;height: 25px;color: white;border: 1px;"  type="button" value=" >> " onclick="addAll('availableBox')"></td></tr>
	<tr><td align="center"><input style="background-color:#9bcf00;height: 25px;color: white;border: 1px;"  type="button" value=" < " onclick="delOne('selectedBox')"></td></tr>
	<tr><td align="center"><input style="background-color:#9bcf00;height: 25px;color: white;border: 1px;"  type="button" value=" << " onclick="delAll('selectedBox')"></td></tr>
	</table>
	</td>
	</tr>
	</table>
	
	<script>

function exists(id, optVal) {
var box=window.parent.frames[2].g(id);
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

  var destbox=window.parent.frames[2].g(id);
  destbox.add(new Option(opt.innerHTML, opt.value));
}


function delOne(id) {
  var box=window.parent.frames[2].g(id);
  for(var i=0; i<box.length; i++) {
    if(box.options[i].selected==true) {
        box.remove(i);
	i--;
    }
  }

}

function delAll(id) {
  var box=window.parent.frames[2].g(id);
  box.length=0;
}

function g(id) {
  return document.getElementById(id);
}

</script>	
  </body>
</html>
