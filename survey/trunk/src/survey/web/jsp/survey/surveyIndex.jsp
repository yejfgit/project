<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow-y:auto">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>回答问卷</title>
		<link href="../survey/css/css.css" rel="stylesheet" type="text/css"/>
		<script language="javascript" src="js/ajax.js"></script>
		<script language="javascript" src="js/jquery-1.7.1.min.js"></script>
		<style type="text/css">
.bt1{
width:70px;

}

#q{
	backgroud-color:#E2F4DC;
	top:200px;
	left:200px;
	display:none;
	height:500px;
    width:600px;
    position: absolute;
}

.tips{
	display:none;
	width:860px;
	font-size:14px;
	font-family: Arial, Helvetica, sans-serif;
	color: #0D2A4C;
}
table{ margin:0px;border-collapse:collapse;border:0px;margin:0px;padding:0px; }
div{margin:0px;border-collapse:collapse;border:0px;margin:0px;padding:0px;}

</style>
		<script type="text/javascript">

//问卷提示信息显示
$(document).ready(function(){
$(".cdiv").click(function(){
    $(".tips").slideToggle("slow");
  });
});

$(document).ready(function(){
    $(".main").slideToggle("slow");
});

window.onbeforeunload=function() {return "刷新或关闭本窗口，您的答案将全部清空，如果您尚未提交问卷建议您在离开页面前保存此次问卷草稿，以备下次作答！";}; 

function doit (){

	window.frames[0].doSubmit(leftTime);
}

function doDraft (){
	window.frames[0].saveDraft(leftTime);
	
}

function submit(l){
	var id = l.value;
	var list = document.getElementsByName("bt1");
	for(i=0;i<list.length;i++){
		if(list[i].value==id){
			list[i].style.fontWeight="bold";
			list[i].style.fontSize="16px";
			list[i].style.textDecoration="underline";
		}else{
			list[i].style.fontWeight="";
			list[i].style.fontSize="";
			list[i].style.textDecoration="";
		}
	}
	var lk = "index"+id+".html";
//	l.style.backgroundColor="red";
	window.frames[0].location=lk;
}

function slip(l){
	l.style.height="35px";
	l.style.color="#0099cc";
	l.style.fontSize="14px";
	l.style.fontWeight="bold";
}

function slip1(l){
	l.style.height="";
	l.style.color="#555555";
	l.style.fontSize="";
	l.style.fontWeight="";
}

function slipTd1(t){
	t.style.fontSize="12px";
	t.style.fontWeight="";
}

/**
window.onresize = function(){
	window.frames[0].location=document.getElementById("if1").src;
}
*/
function loadAttachmentList() {
	tableId = 'attachmentList';
	var surveyId = document.getElementById('surveyId').value;
	send_request('attachment.do?method=list&surveyId=' + surveyId);
}

//收起查看问卷信息
 function changeIt(obj){
 	if(obj.innerHTML=='<STRONG>点击查看问卷信息及未答问卷列表▼</STRONG>'){
 		obj.innerHTML='<STRONG>点击收起问卷信息及未答问卷列表▲</STRONG>'
 	}else if(obj.innerHTML=='<STRONG>点击收起问卷信息及未答问卷列表▲</STRONG>'){
 		obj.innerHTML='<STRONG>点击查看问卷信息及未答问卷列表▼</STRONG>'
 	}
 }
 

/**
DIV展示题目
   function searchIt(id){	
    	var d = window.frames[0].document.getElementById(id);
    	var qt1 = document.getElementById("q");
    	
    	var qt = d.innerHTML;
    	
    	qt1.innerHTML = qt
    	
    	qt1.style.display="block";
   }


 function checkIt(id){	
	document.getElementById(id).style.backgroundColor="#E2F4DC"	
}
  
 function drag(o){
	o=document.getElementById(o);
 	o.onmousedown=function(e){
 	 e=e||window.event;
 	 var x=e.layerX||e.offsetX;
 	 var y=e.layerY||e.offsetY;
  	document.onmousemove=function(e){
  	 e=e||window.event;
   	o.style.left=(e.clientX-x)+"px";
   	o.style.top=(e.clientY-y)+"px";};
  	document.onmouseup=function(){document.onmousemove=null;o.onmousedown=null;};};}
  */ 
</script>
	</head>

	<body
		style=" margin:0px; overflow:none;background-color:#303030;border-collapse:collapse;cellspacing:0;scroll:no;">
		<form name="f1" method="post" action="" type="redirect">
			<input type="hidden" name="userId" value="<bean:write name="userId"/>"/>

			<table width="1000px" align="center">
				<tr>
					<td width="10px">
						&nbsp;
					</td>
					<td>

						<div class="main" style="display:none;background-color:#D7D7D5;color:#555555">

							<input type="hidden" name="surveyId" id="surveyId"
								value="<bean:write name="survey" property="id" />" />
							<table width="100%" bgcolor="#9bcf00">
								<tr>
									<td height="5px"></td>
								</tr>
								<tr>
						
									<td width="20px"></td>

									<td align="left" width="150">
										<img src="../survey/images/logo3.png"></img>
									</td>
									<td align="center" height="30" colspan="2">
										<table>
											<tr>
												<td align="center" height="32" colspan="2"
													style="font-size:25px;">
													<strong><bean:write name="survey" property="name" />
													</strong>
												</td>
											</tr>
											<tr>
												<td colspan="2" align="center">
													部门：
													<bean:write name="fullName" />
													&nbsp;&nbsp; 姓名：
													<bean:write name="userName" />
												</td>
											</tr>
										</table>
									</td>
									<td width="150"></td>
								</tr>
							</table>
							<table width="100%" style="height:8px" bgcolor="7bb803">
								<tr>
									<td style="height:1px">
							
									</td>
								</tr>
							</table>
							<table width="100%" bgcolor="#555555">
								<tr>
									<td height="10px" >
									&nbsp;
									</td>
								</tr>
							</table>
							<table align="center">
								<tr>
									<td colspan="2" height="20px" width="100%" valign="top"
										align="left">
										<table>
											<tr>
												<td width="40"></td>
												<td valign="middle">
													<div class="cdiv"
														style="font-size:14px;font-family:Arial, Helvetica, sans-serif;color:#0099cc;"
														onclick="changeIt(this)"
														onmouseover="this.style.cursor='hand'">
														<strong>点击查看问卷信息及未答问卷列表▼</strong>
													</div>
													<div id="tips" class="tips">
														<table style="font-size:14px">
															<tr>
																<td height="10px"></td>
															</tr>
															<tr>
																<td>
																	<bean:write name="survey" property="tips"
																		filter="false" />
																</td>
															</tr>
															<tr>
																<td height="10px">****************************************************************************************************************************************************</td>
															</tr>
															<tr>
																<td>
																	<table width="90%">
																		<caption><span style="font-size: 14pt;color:red;">未答问卷列表</span></caption>
																		<tr>
																			<th width="20%" align="left">问卷名称</th>
																			<th width="12%" align="left">剩余时间（天）</th>
																			<th width="10%" align="left">问卷发起人</th>
																			<th width="20%" align="left">发起人邮箱</th>
																			<th width="20%" align="left">发起人分机号</th>
																		</tr>
																		<logic:iterate id="u" name="unfinishedList">
																        <tr>
																		    <td width="20%" align="left"><a href="mission.do?method=jump&userId=<bean:write  name="u" property="userId"/>&missionId=<bean:write  name="u" property="missionId"/>" target="_self" ><bean:write  name="u" property="surveyName"/></a></td>
																			<td width="12%" align="left"><logic:equal name="u" property="limitTime" value="0">不限</logic:equal>
																										 <logic:greaterEqual name="u" property="limitTime" value="1"><bean:write  name="u" property="limitTime"/></logic:greaterEqual>	</td>
																			<td width="10%" align="left"><bean:write  name="u" property="realName"/></td>
																			<td width="20%" align="left"><bean:write  name="u" property="mail"/></td>
																			<td width="20%" align="left"><bean:write  name="u" property="telePhone"/></td>
																		</tr>
															</logic:iterate>
																	</table>
																</td>
															
														</table>
														<div id="attachmentList"></div>
														<script>
loadAttachmentList();
</script>
													</div>
												</td>
												<td width="40"></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td width="80%">
										<iframe name="frame1"
											style="margin:0;" id="if1"
											src="mission.do?method=answer&userId=<bean:write name="userId"/>&missionId=<bean:write name="missionId"/>"
											align="center" frameborder="0" scrolling="yes" width="100%"
											onload="this.style.height = parseInt(screen.height-370);">
										</iframe>
									</td>
									
									<td valign="top" width="20%">
								
<table height="100%">				
									<tr><td height="20">
							
								<table valign="buttom" align="center">
								<tr align="center">
									<td height="35" valign="bottom">
										<logic:notEqual value="2" name="mission" property="isClosed">
										<logic:notEqual value="3" name="mission" property="isClosed">
										<div id="btns">
										<input type="button" name="bt1" value="提交问卷" onclick="doit()"
											style="background-color:#f8f8f0;color:#555555;"
											onmouseout="slip1(this)" onmouseover="slip(this)" />
										&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" name="bt2" value="保存草稿"
										style="background-color:#f8f8f0;color:#555555;"
											onclick="doDraft()" onmouseout="slip1(this)"
											onmouseover="slip(this)" />
										</div>
										</logic:notEqual>
										</logic:notEqual>
									</td>
								</tr>
							</table>
							
							</td></tr>
									<tr><td>
										<table style="color:#0099cc;">
											<tr>
												<td width="190">
													<div align="center" id="timeLimit">
														&nbsp;
													</div>
													<div align="center" id="leftTime" style="color: red">
														&nbsp;
													</div>
												</td>
											</tr>
											<tr>
												<td height="5px"></td>
											</tr>
											<tr>
												<td>
													已完成题目:(点击可定位到题目哦！)
												</td>
											</tr>
											<tr>
												<td height="5px"></td>
											</tr>
										</table>

										<table align="center" cellpadding="0"  bordercolor="#cccccc" border="1"
											style="font-size:12px;background-color:#f7f4eb;">
											<tr height="20">
												<%
													int i = 0;
													int j = 0;
												%>
												<logic:iterate id="e" name="questionList">
													<logic:notEqual value="0" name="e" property="questionSeq">
													<%
															i++;
															j++;
													%>

													<a
														href="mission.do?method=answer&userId=<bean:write name="userId"/>&missionId=<bean:write name="missionId"/>#<%=j%>"
														target="frame1">
													<td id="<%=j%>" align="center" height="20" width="25" cellpadding="0"  bordercolor="#4b3d34" border="1"
														style="color:#0000FF;backgroud-color:#55A0FF;border-left:hidden;cellpadding:0;border-color:#cccccc;border:0;"
														onmouseover="this.style.cursor='hand';this.style.fontSize='17px';this.style.fontWeight='bold'" onmouseout="slipTd1(this)">
														<bean:write name="e" property="questionSeq" />
													
													</td>
													</a>
														<%
														if (i % 5 == 0) {
														%>
													
											     </tr>
											      <tr>
												<%
														i = 0;
														} else {
												%>
												<td></td>
												<%
												}
												%>
												</logic:notEqual>
												</logic:iterate>
											</tr>
											
										</table>

</td></tr><tr><td height="100%">&nbsp;</td></tr></table>
							
									</td>
								</tr>
							</table>
							<table align="center">
								<tr align="center">
									<td height="15px">
									&nbsp;
									</td>
									</tr>
							</table>
							<div id="q" onmousedown="drag(this.id)">
								<table style="backgroumd-color:red">
								</table>
							</div>
							<div id="loading"
								style="position:absolute; left: 450px; top: 250px">
								<img src="../survey/images/loading2.gif" width="100px" />
							</div>
							<script>  
    
    var timeLimit = <bean:write name="mission" property="timeLimit" />;
    var isTiming = <bean:write name="mission" property="isTiming" />
    var type = <bean:write name="mission" property="isClosed"/>;
    var timer
    if (isTiming == 1) {
		if(type==2||type==3){
			document.getElementById('timeLimit').innerHTML = '此次问卷的答题时间是：' + timeLimit + '分钟，请您及时作答，到时后系统将自动提交。';  
    		document.getElementById('leftTime').innerHTML = '此次问卷已完成';   
    	}
    	else{
	    document.getElementById('timeLimit').innerHTML = '此次问卷的答题时间是：' + timeLimit + '分钟，请您及时作答，到时后系统将自动提交。';   
	    var leftTime = timeLimit * 60;
	    function showLeftTime(){  
	        var leftMinutes = parseInt(leftTime/60);  
	        var leftSeconds = parseInt(leftTime%60);  
	          
	        if(leftTime < 0){  
	            //document.getElementById('leftTime').innerHTML = '您的问卷已超时，请您尽快提交';
	            alert('您的答卷时间已到，系统将自动提交。');
	            window.frames[0].execSubmit();
	        }else{  
	            document.getElementById('leftTime').innerHTML = '剩余时间：'+leftMinutes+'分'+leftSeconds+'秒';  
	        }  
	        leftTime--;  
	    }  
	    timer = setInterval('showLeftTime()',1000);  
   		}
    }
    
    
    
    

    


</script>
						</div>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td height="20px" width="97%" bgcolor="#9bcf00" align="center" style="color:#555555;font-size:12px;">
						Copyright Reserved,Union Life Insurance Company,Ltd.
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>

		</form>
	</body>
</html>
