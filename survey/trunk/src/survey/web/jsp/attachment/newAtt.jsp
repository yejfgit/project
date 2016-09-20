<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp" %>


<%
      response.setHeader("Pragma","No-Cache");
      response.setHeader("Cache-Control","No-Cache");
      response.setDateHeader("Expires", 0);
%>

<html>  
<head>
<base target="_self" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>文件上传</title>
<style type="text/css">
<!--
.tt {
	font-family: "Times New Roman", Times, serif;
	font-size: 14px;
	color: #336699;
	text-decoration: none;
}
--> 
</style>
<link type="text/css"  href="<%=request.getContextPath()%>/css/css.css"  rel="stylesheet">	
 
</head>
<script Language="JavaScript" src="<%=request.getContextPath()%>/js/common.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Attachment.js.jsp"></script>

<script>

function doSubmit() {

	if (!checkFileType()) {
		return false;
	}

	document.getElementById("uploadBtn").disabled = true;
	document.f1.submit();
}

function checkFileType() {
	var f = document.f1;
	for (var i = 0; i < f.length; i++) {
		if (f[i].type != 'file' || f[i].value == null || f[i].value == '') {
			continue;
		}
		
		filePath = f[i].value;
		dot = filePath.lastIndexOf('.');
		fileType = filePath.substring(dot + 1, filePath.length);
		
		if (dot == -1 || fileType.length > 5
		 || fileType == 'exe' || fileType == 'bat') {
			alert('对不起，您无法上传这个扩展名的附件。');
			return false;
		}
		
	}
	return true;
	
}


var fileNum = 5;
function addFileBox(){

	for(var i = 0; i < 5; i++) {
		fileNum++;
		var inputFile = document.createElement("input");
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		//inputFile.id = "file" + fileNum;
		inputFile.name = "uploadFile" + fileNum;
		//alert(inputFile.name);
		
		inputFile.type = "file";
		inputFile.size = "90";
		inputFile.className = "input1";
		td.appendChild(inputFile);
		tr.appendChild(td);
		document.getElementById("fileBoxTable").appendChild(tr);
	}
	
	var tr = document.createElement("tr");
	var td = document.createElement("td");
	td.innerHTML = '&nbsp;';
	tr.appendChild(td);
	document.getElementById("fileBoxTable").appendChild(tr);

	
}


</script>

<body>



<form name="f1" method="post" action="attachment.do?method=save" enctype="multipart/form-data">
	<input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="surveyId" />">


<table cellpadding="0" cellspacing="0" border="0">

<tbody id="fileBoxTable">
<tr><td><input type="file" name="uploadFile1" class="input1" size="90" /></td></tr>
<tr><td><input type="file" name="uploadFile2" class="input1" size="90" /></td></tr>
<tr><td><input type="file" name="uploadFile3" class="input1" size="90" /></td></tr>
<tr><td><input type="file" name="uploadFile4" class="input1" size="90" /></td></tr>
<tr><td><input type="file" name="uploadFile5" class="input1" size="90" /></td></tr>
<tr><td>&nbsp;</td></tr>
</tbody>
<tr><td align="right"><input type="button" onClick="addFileBox();" class="btn-01" value="更多..." /></td></tr>
</table>

<br />
<center>
<input id="uploadBtn" type="button" class="btn-02" value="上传" onclick="doSubmit();" />
<br /><br /><span style="color:blue">请保证文件大小在10MB以内；文件名称长度在100个汉字以内</span>

</center>
</form>   



<script >

</script>
</body>
</html>