<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested"
	prefix="nested"%>
<%@page import="com.ulic.ulweb.ulweb2.service.impl.task.PolicyService"%>
<%@page import="com.adobe.edc.sdk.infomodel.Policy"%>
<%@page import="java.util.List"%>
<%@page import="com.adobe.edc.sdk.infomodel.Policy"%>
<%

    List attachmentList =  (List)request.getAttribute("attachmentList");
    Policy[] policys = (Policy[])request.getAttribute("policyAry");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
	<html:base />

	<title>上传文件</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<script>

function checkForm(){

//获取组信息
var boxes = window.frames["groupFrame"].document.getElementsByName("group");
  var groupIds =null;
  var groupNames =null;
  for (var i = 0; i < boxes.length; i++){   
    if (boxes[i].checked){
        if(groupIds == null){
         	groupIds = boxes[i].value;
        }else{
        	groupIds +="%";
        	groupIds += boxes[i].value;
        } 
        
      var name = window.frames["groupFrame"].document.getElementById(boxes[i].value).innerHTML; 
      if(groupNames == null){
        groupNames =name;
      }else{
        groupNames += ",";
        groupNames += name;
      }
      
    } 
  }
if(groupIds != null){
  var newGroupIds = document.getElementById("newGroupIds");
  newGroupIds.value = groupIds;
}

if(groupNames != null){
  var newGroupNames = document.getElementById("newGroupNames");
  newGroupNames.value = groupNames;
}

var toPdf = document.getElementById("toPdf");
var isToPdf = document.getElementById("isToPdf");
if(toPdf.checked){
  isToPdf.value=1;
}else{
isToPdf.value=0;
}



  var apolicys = document.getElementsByName("apolicy");
  var apolicyFlag = false;//标记是否选择了加密策略
  for(var i= 0;i<apolicys.length;i++){
    if(apolicys[i].checked){
      if( apolicys[i].value != "noPolicy"){
        apolicyFlag = true;
      }
      
      if(apolicys[i].value !="newPolicy" && apolicys[i].value != "noPolicy"){
      	document.getElementById("policyName").value = document.getElementById(apolicys[i].value).innerHTML;
      }
    }
   }


  for (i = 0; i < fileNum; i++) {

  //alert('file' + i + ':' + document.getElementsByName("file" + i)[0]);
  	if (document.getElementsByName("file" + i)[0] == null) {
  		continue;
  	}

   var file = document.getElementsByName("file" + i)[0].value;

   if(file!="" && file.indexOf(".pdf")!=-1){
   	 if(toPdf.checked){
         alert("不能对pdf文件进行转换");
         return false;
      }
   }
   }
   

  
  if(apolicyFlag){
  
  //alert("fileNum" + fileNum);
  for (i = 0; i < fileNum; i++) {
  //alert(i);
  	if (document.getElementsByName("file" + i)[0] == null) {
  		continue;
  	}
   var file = document.getElementsByName("file" + i)[0].value;

   if(file!="" && file.indexOf(".pdf")==-1){
      
      if(!toPdf.checked){
         alert("不能对非pdf文件进行加密");
         return false;
      }
   }
   }
  }
  
  if(!checkOrder()){
   return false;
  }
  
  return true;
}
function checkOrder(){
  var boxex = document.getElementsByName("orderList");
  for(var i = 0;i<boxex.length;i++){
     if(!checkRate(boxex[i].value)){
       alert(boxex[i].value +" 不是2位正整数，请重新输入");
       return false;
     }
  }
  return true;
}
function next() {
	
	if (!checkForm()) {
		return false;
	}


	var f = document.getElementById("form");
	f.action ="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=next";
	f.target = '_self';
	f.submit();
}

function finish(){
	if (!checkForm()) {
		return false;
	}
	var f = document.getElementById("form");
	f.action ="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=finish";
	f.target = '_self';
	
	f.submit();
}

function newPolicy(){
    var div = document.getElementById("newPolicyDiv")
    div.style.display = "block"//显示
}

function viewGroups(){
 
    var div = document.getElementById("groupDiv")
    div.style.display = "block"//显示
}


function getGroup(){

var left, top;
var width = 600;
var height = 400;
left = (window.screen.availWidth - width) / 2;
top = (window.screen.availHeight - height) / 2;
var per = 'width=' + width + ',height=' + height + ',left=' + left + ',top=' + top + ',screenX=' + left + ',screenY=' + top;
var theURL = "<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=getGroups";
window.open(theURL,'',per);

  //window.open (theURL, "newwindow", "height=800, width=600, top=0, left=0, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no")
}

function showGroup(){
 
 
 document.getElementById("groupFrame").src ="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=getGroups" ;
 var div = document.getElementById("groupDiv")
 div.style.display = "block"//显示
}

function changeOrder(id,obj){
  if(!checkRate(obj.value)){
    alert(obj.value +"不是2位正整数，请重新输入");
    obj.focus();
    return;
  }

  document.getElementById(id).value="Y"; //已经修改
}

function checkRate(input)
{
     var re = /^[0-9]*]*$/;   //判断字符串是否为数字     //判断正整数 /^[1-9]+[0-9]*]*$/   
     if (!re.test(input))
    {
        return false;
     }
     if (input > 99) {
     	return false;
     }
    return true;
}

function sortOrder(){
  if (!checkOrder()) {
  	return false;
  }
  var f = document.getElementById("form");
	f.action ='<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=sortOrder';
	f.target = '_self';
	
	f.submit();
  
}
var fileNum = 1;
	function addFile(){
		var inputFile = document.createElement("input");
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		inputFile.id = "file" + fileNum;
		inputFile.name = "file" + fileNum;
		//alert(inputFile.name);
		fileNum++;
		inputFile.type = "file";
		inputFile.size = "100";
		td.appendChild(inputFile);
		tr.appendChild(td);
		document.getElementById("idtbody").appendChild(tr);
		
	}
function  check(v){ 
  var ar=v.split(".");   
  if(/docx|et|dps|docx|pptx|xlsx|wps/.test(ar[ar.length-1])){
  document.all.file0.src='';
  alert('您选择的文件扩展名为   '+ar[ar.length-1]+'\n\n   不合要求，请重新选择！')
 
  }   
  else{    
   document.all.file0.src=v;
  }   
  }   
</script>
</head>
<logic:notEmpty name="message">
	<bean:write name="message" />
</logic:notEmpty>

<body>
	<form action="web/admin/attachment/attachmentAdmin.do" name="form"
		method="post" enctype="multipart/form-data">
		<logic:notEmpty name="pageId">
		<input type="hidden" id="pageId" name="pageId" value="<bean:write name="pageId" />"/>
		</logic:notEmpty>
		<logic:notEmpty name="contentId">
     		<input type="hidden" value="<bean:write name="contentId"/>" name="contentId">
		</logic:notEmpty>
		
		<table border="1" width="100%" align="center" style="border-collapse: collapse;">
			<tr>
				<td colspan="2">
					请注意：附件大小不能超过5M
				</td>

			</tr>
			<tr>
				<td colspan="2">


					<table>


						<logic:notEmpty name="attachmentList">
							<tr align="right">
								<td align="right" colspan="2">
										<input type="button" name="sort" value="排序" id="sort"
											onclick="sortOrder();">
								</td>

							</tr>
							<logic:iterate id="attachment" name="attachmentList">
								<tr>
									<td align="left">
										<img
											src="<%=request.getContextPath()%>/images/admin/attachment/attachment.jpg" />
										<bean:write name="attachment" property="showName" />
									</td>
									<td>
										<input type="hidden" name="idList"
											value="<bean:write name="attachment" property="attachmentId"/>">
										<input type="text" name="orderList"
											value="<bean:write name="attachment" property="attachmentOrder"/>"
											onchange="changeOrder('<bean:write name="attachment" property="attachmentId"/>',this);">
										<input type="hidden" name="flag"
											id="<bean:write name="attachment" property="attachmentId"/>">
									</td>

								</tr>
							</logic:iterate>
 						<input type="hidden" value="<%=attachmentList.size()%>" name="attachmentListSize"/>
						</logic:notEmpty>


					</table>
				</td>


			</tr>
			<tr>
				<td colspan="2">

					
		<input type="button" onClick="addFile();" value="增加附件个数"></input>
		<table cellpadding="0" cellspacing="0" border="0" width="100%">
			<tbody id="idtbody">
				<tr>
					<td>
						<input type="file" name="file0" size="100" onChange="check(this.value)";></input>
					</td>
				</tr>
			</tbody>
		</table>					
					
				</td>
			</tr>
			<tr>
				<td>
					加密方式
				</td>

				<td>
					<table>
						<tr align="left">
							<td>
								<input type="checkbox" id="toPdf">
								<input type="hidden" name="isToPdf" id="isToPdf"/>
								将文档转换成PDF文档
							</td>
						</tr>
						<tr>
							<td>
								<input type="radio" name="apolicy" value="noPolicy" checked>
								不加密
							</td>
						</tr>
						<logic:notEmpty name="policyAry">
							<logic:iterate id="policy" name="policyAry" indexId="index">
							  <logic:notEmpty name="policy">
								<tr align="left">
									<td>
										<input type="radio" name="apolicy"
											value="<bean:write name="policy"  property="id"/>">
										<label id="<bean:write name="policy"  property="id"/>">
											<bean:write name="policy" property="name" />
										</label>
									</td>
								</tr>

							
								
								</logic:notEmpty>
							</logic:iterate>
							
						<tr>
							<td>
								<input type="radio" name="apolicy" value="newPolicy"
									onclick="newPolicy()">
								新建策略
							</td>
						</tr>				
										
						</logic:notEmpty>
						

						
						
					</table>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<div style="display: none" id="newPolicyDiv">
						<table border="1" id="newPolicyTable">

							<!-- <tr>
								<td>
									策 略 名
								</td>
								<td>
									<input type="text" name="newPolicyName" value="我的自定义策略">
									

								</td>
							</tr> -->
							<tr>
								<td>
									策 略 描 述
								</td>
								<td>
									<input type="textarea" name="newPolicydesc" style="width: 400; height: 50" >
									<input type="hidden" name="newGroupIds" id="newGroupIds">
									<input type="hidden" name="newUserIds" id="newUserIds">
									<input type="hidden" name="newGroupNames" id="newGroupNames">
									<input type="hidden" name="newUserNames" id="newUserNames">
									<input type="hidden" name="policyName" id="policyName">
								</td>
							</tr>
							<tr>
								<td>
									密 级

								</td>
								<td>
									<input type="radio" name="newPolicySecure" value="2" checked>
									只读，不可打印
     								<input type="radio" name="newPolicySecure" value="1">
									可读，可打印
								    
									
								</td>
							</tr>
							<tr>
								<td>
									阅读范围
								</td>

								<td>
									<input type="radio" name="newReadRange" value="all" checked />
									全系统
									
									<input type="radio" name="newReadRange" value="parentCompany" />
									总公司各部门
									
			                        <input type="radio" name="newReadRange" value="subsidiary" />
									各分公司
									<input type="radio" name="newReadRange" value="userDefined"
										onclick="showGroup()" />
									详细
									
								</td>

							</tr>

						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="display: none" id="groupDiv">
						<iframe height="350" width="600" src="" name="iframe"
							id="groupFrame">

						</iframe>
					</div>
				</td>

			</tr>
			<tr>
				<td colspan="2">
					<html:button property="nextBtn" onclick="next()">上传保存</html:button>
					<html:button property="finishBtn" onclick="finish()">退出</html:button>
					&nbsp;&nbsp;<span style="color: red; font-size: 12px">点击“退出”此内容才可以显示出来</span>
				</td>
				<td>

				</td>
			</tr>
		</table>

	</form>
	<a
		href="<%=request.getContextPath()%>/web/admin/attachment/attachmentAdmin.do?method=list&contentId=<bean:write name="contentId"/>" target="_blank">进入监控页面</a>



</body>
