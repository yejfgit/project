<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>导入题库</title>
<link href="../survey/css/svcss.css" rel="stylesheet" type="text/css">
<script LANGUAGE="JavaScript">
<!--

function uploadFileChange() {
	if (document.getElementById('uploadFile').value == '') {
		document.getElementById('previewButton').disabled = true;
		document.getElementById('savdButton').disabled = true;
		return false;
	} else {
		document.getElementById('previewButton').disabled = false;
	}
}

function doPreview() {
	document.getElementById('saveButton').disabled = false;
	
	document.f1.action = 'import.do?method=preview';
	document.f1.target = '_blank';
	document.f1.submit();

}

function doSave() {
	
	document.f1.action = 'import.do?method=save';
	document.f1.target = '_self';
	document.f1.submit();

}

function doImport() {
	document.f1.action = 'import.do?method=batchImport';
	document.f1.target = '_self';
	document.f1.submit();

}
//按钮改变颜色
function overChangeBtn(btn){
	btn.style.backgroundColor="#9bcf00";
}

function outChangeBtn(btn){
	btn.style.backgroundColor="#0e9cdf";
}

//-->
</script>

<style type="text/css">
<!--

-->
</style>
</head>
<body>
<form id="f1" name="f1" method="post" enctype="multipart/form-data">
<input type="hidden" id="libraryId" name="libraryId" value="<bean:write name="libraryId" />" />
<table width="100%"  border="0" cellpadding="0" cellspacing="0" background="images/index_01.gif">
  <tr>
    <td><img src="images/_blank.gif" width="2" height="1"></td>
  </tr>
</table>
<table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td height="30px" style="color:#0e9cdf;font-size:14px;vertical-align:bottom;"><strong><strong><a href="library.do?method=list" style="color:#0e9cdf;" target="mainFrame">首页</a> >> 导入题库</strong>
  	</strong></br></br>
  	</td>
  </tr>
</table>

<table align="center" width="80%" border="0" cellpadding="5" cellspacing="0" >
  <tr>
    <td width="1%">&nbsp;</td>
    <td align="left" nowrap>下载excel模板：<a href="import.do?method=getTemplate" target="_self">下载</a>

</td>
<td align="left" nowrap>上传excel文件： 
<input type="file" name="uploadFile" id="uploadFile" onchange="uploadFileChange()" style="	height: 25px;border: 1px;border-color: #828282;"  /> &nbsp;&nbsp;
<input type="button" name="yl" id="previewButton" value="预览" onclick="doPreview()" disabled="disabled" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)">&nbsp;
<input type="button" name="yl" id="saveButton" value="导入" onclick="doSave()" disabled="disabled" class="btn" onmouseover="overChangeBtn(this)" onmouseout="outChangeBtn(this)">&nbsp;</td>
</tr>

  




  
  
</table>

	</form>
		
		
		
		
		

</body>
</html>
