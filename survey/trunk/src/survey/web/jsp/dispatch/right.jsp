
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
    
    <title>My JSP 'left.jsp' starting page</title>
    
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
  <form name="form1" action="" method="post">
  	<input type="hidden" name="userMsg" id="userMsg"/>
  	<input type="hidden" name="mailTips" id="mailTips"/>
  	<input type="hidden" name="closeTips" id="closeTips"/>
    <table align="left">
     <tr><td style="font-size:12px;" align="center"><strong>已选人员及岗位</strong></td></tr>
    <tr><td>
    <select  id="selectedBox" name=selectedBox multiple="multiple"  style="width:200px" size="24" ondblclick="delOne('selectedBox')">
	  <logic:notEmpty name="userList">
	     <logic:iterate id="element" name="userList" >
 		 <option value="<bean:write name="element" property="id" />,<bean:write name="element" property="type" />"><bean:write name="element" property="realName" /></option>
  	    </logic:iterate>
  	  </logic:notEmpty>
  	  
  	  <logic:notEmpty name="organList">
	     <logic:iterate id="element" name="organList" >
 		 <option value="<bean:write name="element" property="umOrganId" />,<bean:write name="element" property="type" />"><bean:write name="element" property="abbrName" /></option>
  	    </logic:iterate>
  	  </logic:notEmpty>
  	  
  	  <logic:notEmpty name="umOrgan">
 		 <option value="<bean:write name="umOrgan" property="umOrganId" />,2"><bean:write name="umOrgan" property="abbrName" /></option>
  	  </logic:notEmpty>
	</select>
</td></tr></table>
	<script>
//点击按钮数
var clickNum = 0;

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

function g(id) {
  return document.getElementById(id);
}

function delAll(id) {
  var box=g(id);
  box.length=0;
}

//执行下发
function doSubmit(id,o,h,m,c) {
  
  document.getElementById("closeTips").value=c;
  document.getElementById("mailTips").value=m;
  if(clickNum>0){
  	return false;
  }
  clickNum++;
  var surveyId = id;
  var isOpen=o;
  var hurryTimes=h;
  var box=g('selectedBox');
  var msg='';
  for(i=0; i<box.length; i++) {
    msg+=box.options[i].value + ';';
  }
  
  if (!confirm('确实要向这些用户下发问卷吗？')) {
		clickNum = 0;
		return false;
	}
  //alert(msg);
  document.getElementById("userMsg").value=msg;
  window.form1.action="dispatch.do?method=dispatchSurvey&surveyId="+ surveyId+'&isOpen='+isOpen+'&hurryTimes='+hurryTimes;
  window.form1.submit();
  //location.href = 'dispatch.do?method=dispatchSurvey&msg=' + msg +'&surveyId='+ surveyId;
}

</script>
	</form>
  </body>
</html>
