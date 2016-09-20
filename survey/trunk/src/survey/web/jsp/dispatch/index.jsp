<%@ page language="java" contentType="text/html; charset=UTF-8" 
 pageEncoding="UTF-8"%>  
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
    
    <title>问卷下发</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="../survey/css/css.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
	<script language="javascript" src="js/jquery-1.7.1.min.js"></script>
   <script type="text/javascript">
		function addUser(){

		window.showModalDialog("user.do?method=dispatchUserDialog" , window, 'dialogWidth:500px;dialogHeight:500px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
//		window.open("user.do?method=userDialog");
		intoUser();
		}
		
		function intoUser(){
		
		var id = document.getElementById("uid").value;
		var userName = document.getElementById("uname").value;
		   var optValue =id+',1';
		   if(window.frames[2].exists('selectedBox', optValue)) {
			    return false;
  			}
		  var destbox=window.frames[2].g('selectedBox');
 		  if(id!=""){
 			 destbox.add(new Option(userName, optValue));
 		}

	}
	
	function dispatchOut(){
		
		var id = document.getElementById("surveyId").value;
		window.showModalDialog("mail.do?method=toSendMailOutside&surveyId="+id , window, 'dialogWidth:600px;dialogHeight:470px;Resizable:0;help:no;status:No;center:yes;edge:Raised;');
		//window.open("mail.do?method=toSendMailOutside&surveyId="+id);
	}
	
	function doCloseAndRefresh(){
		window.close();
	}
	
	function queryPos(){
		var posName = document.getElementById("posName").value;
		var organId = document.getElementById("organ.umOrganId").value;
		
		window.frames[1].location.href="dispatch.do?method=addUsersByPosition&posName="+encodeURI(encodeURI(posName))+"&organId="+organId;
	}
	function doEdit(){
		
		var id=document.getElementById("surveyId").value;
		
		if (!confirm('修改此问卷需关闭已下发的任务，确实要修改吗？')) {
			return false;
		}
		window.frames[1].location.href='survey.do?method=edit&surveyId='+id;
   }
	
</script>
  </head>
  <body>
  <form name="">
  <input type="hidden" name="uid" id="iduid">
  <input type="hidden" name="surveyId" id="surveyId" value="<bean:write name="surveyId" />">
  <input type="hidden" value="增加" onclick="intoUser()" />
  <table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0"  class="titBar2">
  	<tr >
    <td height="30px" colspan="1" class="titBar3">&nbsp;&nbsp;
    <a href="survey.do?method=WJList&type=2" style="color:#828282;" target="mainFrame">返回首页</a>
    </td>
    <td colspan="2" class="titBar">
    <a href="survey.do?method=edit&surveyId=<bean:write name="surveyId" />"  target="mainFrame">问卷设计</a>
      >><Strong><a href="dispatch.do?method=index&surveyId=<bean:write name="surveyId" />"  target="mainFrame">问卷下发</a></Strong> 
      >><a href="mission.do?method=monitor&surveyId=<bean:write name="surveyId" />"  target="mainFrame">结果分析</a></td>
   </table>
   <table align="center" width="80%" height="24"  border="0" cellpadding="0" cellspacing="0" style="background-color: white;">
  <tr style="font-size: 16px">
    <td align="center" height="25px" width="15%"></td>
    <td align="center" width="65%">&nbsp;
    	<strong><logic:notEmpty name="surveyName"><bean:write name="surveyName" /></logic:notEmpty></strong>
    </td>
	<td align="center" height="30px" width="20%"> </td>
  </tr>
 </table>
  <table align="center"  width="80%" style="background-color: white;margin-top: 15px;border: 1px solid #DDDEE3;">
  	<tr>
  		<td class="tdTitle" colspan="3">人员选择</td>
  	</tr>
  	<tr>
  		<td width="35%" >
  			<table width="100%">
  				<tr>
  					<td align="center" style="font-size:12px;"><strong>快捷搜索</strong></td>
  				</tr>
  				<tr>
  					<td align="center"><input type="text" name="uname" id="iduname" value="点击选择用户" onmouseover="this.style.cursor='hand'"
		onclick="addUser()" readonly="true" style="width:240px"/></td>
  				</tr>
  				<tr>
  					<td align="center" style="font-size:12px;"><strong>组合搜索</strong></td>
  				</tr>
  				<tr>
  					<td align="center" style="font-size:12px;">
  						机构名称：<html:select name="userForm" property="organ.umOrganId" onchange="queryPos()" style="width:195px">
			<option value="21" >合众人寿</option>
			<html:optionsCollection name="organLabelList"/>
		</html:select> 
  					</td>
  				</tr>
  					<td align="center" style="font-size:12px;">
						岗位名称：<input type="text" id="posName" value="请输入岗位名称" onclick="this.value='';" width="3000px">&nbsp;
						<input type="button" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;" name="sub" value="查询" onclick="queryPos()">
					</td>
  				</tr>
  				<tr>
  					<td align="center" style="font-size:12px;"><strong>机构搜索</strong></td>
  				</tr>
  				<tr>
  					<td align="center">
  						<iframe marginwidth="0" marginheight="0" width="240px" height="250px" src="dispatch.do?method=left" name="left"> </iframe>
  					</td>
  				</tr>
  			</table>
  		</td>
  		<td width="40%" align="right" >
  			<iframe scrolling="no" marginwidth="0" marginheight="0" frameborder="0" height="420px" src="dispatch.do?method=middle" name="middle" ></iframe>
  		</td>
  		<td align="left" >
  			<iframe width="100%"  scrolling="no" marginwidth="0" marginheight="0" frameborder="0" height="420px" src="dispatch.do?method=right" name="right" ></iframe>
  		</td>
  	</tr>
  	</table>
  	<table align="center"  width="80%" style="background-color: white;margin-top: 15px">
  	<tr>
  		<td class="tdTitle" colspan="3">问卷下发设置</td>
  	</tr>
  	<tr>
  		<td colspan="3" width="80%" align="left">
  		<strong>·</strong>&nbsp;&nbsp;&nbsp;&nbsp;自动关闭逾期未完成问卷：<input type="text" id="hurryTimes" name="survey.hurryTimes" size="5" value="<bean:write name="userForm" property="survey.hurryTimes" />">天&nbsp;&nbsp;(在指定天数内，系统将每天对未完成问卷用户进行邮件提示。逾期将自动关闭未完成问卷)<br>
  		</td>
  	</tr>
  	<logic:equal value="2" name="userForm" property="survey.type">
  	<tr>
  		<td colspan="3" width="100%" align="left">
  		<strong>·</strong>&nbsp;&nbsp;&nbsp;&nbsp;是否对考生保密调查结果：<input type="checkbox" id="isOpen" name="survey.isOpen" value="<bean:write name="userForm" property="survey.isOpen"/>" /> 
  		</td>
  	</tr>
  	</logic:equal>
  	<tr><td colspan="3" width="80%" align="left">邮件提示信息：
			<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'mailTips' ) ;
			oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
			oFCKeditor.Height	= 200 ;
			oFCKeditor.Value	= '<bean:write name="userForm" property="survey.mailTips" filter="false"/>';
			oFCKeditor.Create() ;
		</script>
</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td colspan="3" width="80%" align="left">邮件关闭信息：
				<script type="text/javascript">
				var oFCKeditor = new FCKeditor( 'closeTips' ) ;
				oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
				oFCKeditor.Height	= 200 ;
				oFCKeditor.Value	= '<bean:write name="userForm" property="survey.closeTips" filter="false"/>';
				oFCKeditor.Create() ;
			</script>
	</td></tr>
<tr>
  	<tr>

  	  	<td colspan="3" width="100%" align="center">
  	  		&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="button" style="background-color:#0e9cdf;height: 25px;color: white;border: 1px;"  value="下发问卷" onclick="dispatchSurvey()">
  		</td>

  	</tr>

  </table>
  </form>
  	<script>
  		//调用frame中right页面，执行权限限制。
  		function dispatchSurvey(){
	  		if(document.getElementById('hurryTimes').value>30||document.getElementById('hurryTimes').value==0){
				alert("未完成提醒天数不能等于0，并且不能大于30天");
				
				return false;
		    }
		   var limit = /^\+?[1-9][0-9]*$/;
		    if(!limit.test(document.getElementById('hurryTimes').value)){
				  alert("天数只能为正整数！");
				   return false;
			 }
			
			 var isOpen = 0;
			 if(document.getElementById("isOpen")!=null)
			 {
				if(document.getElementById("isOpen").checked==true){
					isOpen=1;
				}else{
					isOpen=0;
				}
			}
			var hurryTimes=document.getElementById("hurryTimes").value;
			var mailTips=document.getElementsByName("mailTips")[0].value;
			var closeTips=document.getElementsByName("closeTips")[0].value;
			var surveyId=document.getElementById("surveyId").value;
  		   window.frames[2].doSubmit(surveyId,isOpen,hurryTimes,mailTips,closeTips);
  		  window.parent.document.getElementById("mainFrame").src="mission.do?method=monitor&surveyId="+surveyId;
  		}
  		 
  	</script>
  	
  </body>
</html>
