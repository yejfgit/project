
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
<title><ulweb:navbar beanName="nb"  deptId="it" enName="<%=enName%>" columnId="<%=columnId %>" />
<bean:write name="nb" /></title>
<script type="text/javascript" src="js/top.js"></script>
<script language="JavaScript" src="script/list.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script>
function page(no) {
	var url = location.href;
	url = url.replace(/\?pageNum=\d+/g, "") + "?pageNum=" + no;
	location.href = url;
}
</script>
</head>

<body>
<DIV class=BOX>

<DIV class=PageBody>


<!--main-->

<DIV class="con">
<ul>


<ulweb:content beanName="cl" deptId="it"
												enName="zhidu"
												columnId="4845"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>"
												pageSize="24" />

		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri"><bean:write name="element" property="uploadTime" format="yyyy-MM-dd" /></span>
			·<bean:write name="element" property="contentNameLink" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" /></li>
		</logic:iterate>
<bean:define id="cid" name="element" property="columnId" />

</ul>

<!--next-->
<DIV class="next"><bean:write name="cl" property="pageTag" filter="false" />	</DIV>
<!--next-->

</DIV>



<!--main-->

</DIV>
</body>
</html>
