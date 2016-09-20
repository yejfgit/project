
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String enName = request.getParameter("eId");
	String keyWord = request.getParameter("keyWord");
	String strId = request.getParameter("id");
	String strPage = request.getParameter("pageNum");
	
	int columnId;
	try {
		columnId = Integer.parseInt(strId);
	} catch (Exception e) {
		columnId = 0;
	}
	
	int pageNum;
	try {
		pageNum = Integer.parseInt(strPage);
	} catch (Exception e) {
		pageNum = 1;
	}	

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合众党旗红</title>
<link href="dept/dangjian/main.css" rel="stylesheet" type="text/css" />
<script src="dept/dangjian/main.js"></script>

<script>

function page(no) {
	var url = location.href;
	url = url.replace(/\?pageNum=\d+/g, "") + "?pageNum=" + no;
	location.href = url;
}

</script>



</head>


<body>
<div id="main">
   <jsp:include flush="true" page="head.jsp"></jsp:include>			

   <div id="collist">
   <div id="collist_head" class="col_title"><a href="dangjian.do?method=index">党建网</a>>>合众党旗红
   </div>
  <div id="box1">
<ul>


<ulweb:content beanName="cl" deptId="dangjian"
												enName="dangqihong"
												withAtt="1" 
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>"
												pageSize="12" />
<style>
td{ border: 1px dashed pink ;BORDER-COLLAPSE:COLLAPSE}
</style>
<table width="200" heigh="150" border="1" cellspacing="2" align="center">
<tr>
<td>
  <%int i = 0; %>
		<logic:iterate id="element" name="cl" property="objectList">
		   <logic:notEmpty name="element" property="attachmentList">
			<logic:iterate id="e" name="element" property="attachmentList">
			
			<%i++; %>
			 <p align="center"><a href="<bean:write name="element" property="subTitle" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" width="200" height="150" class="bor"/></a></p>
		     <p class="w115" align="center" ><bean:write name="element" property="uploadDeptStr" filter="false"/>&nbsp;<bean:write name="element" property="contentNameLink" filter="false" />
            <% if (i % 4 == 0) {  %>
			</td></tr><tr><td>
			<% 
			i = 0;
			} else {
			%></td><td>
			<% } %>
            </logic:iterate>		    
		   </logic:notEmpty>
		</logic:iterate>
</table>

</ul>

<!--next-->
<DIV class="next" style="text-align: center"><bean:write name="cl" property="pageTag" filter="false" />	</DIV>
<!--next-->


</div>
</div>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>
