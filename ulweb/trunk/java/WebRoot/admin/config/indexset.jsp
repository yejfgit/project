
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.web.action.IndexAction,com.ulic.ulweb.ulweb.web.action.admin.ContentAction,com.ulic.ulweb.ulweb.util.PorjectTask" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页设置</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
   
	<style>
	p{
		margin:0cm;
	}
	</style>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  	<script language="javascript">
		function leibiaogengxin(){
			if(document.form1.resetList.value == 0){
				document.form1.resetList.value =1;
				document.form1.burl.value = "已选择重置";
			}else{
				document.form1.resetList.value = 0;
				document.form1.burl.value = "不重置首页列表";
			}
		}
		
		function iplanjie(){
			if(document.form1.iprefuse.value == 0){
				document.form1.iprefuse.value =1;
				document.form1.buip.value = "拦截中";
			}else{
				document.form1.iprefuse.value = 0;
				document.form1.buip.value = "未拦截";
			}
		}	
	
		function chageIITF(){
			if(document.getElementById("taskRun").value == 0){
//				alert("0");
				document.getElementById("taskRun").value = 1;
				document.getElementById("IITF").innerHTML = "启动";
			}else{
//				alert("1");
				document.getElementById("taskRun").value = 0;
				document.getElementById("IITF").innerHTML = "停止";
			}
		}
	</script>
  <body>
  
  <table  align="center">
  	<tr>		
		<td width="100%" valign="top">
			
		
   <table width="100%" align="center">
   		<form action="admin/config.do?method=resetIndex" method="post" id="idform1" name="form1" >
		<input type="hidden" value="0" name="resetList">	
		<input type="hidden" value="<%=PorjectTask.initIndexTaskFlag%>" name="indexTask" id="taskRun">
		<tr>
			<td colspan="2" align="center">
				<input type="button" onClick="javascript:leibiaogengxin();" name="burl" value="不重置首页列表" >			
			</td>
		</tr>		
		<tr>
			<td>
				首页每小时更新目前状态：<%=(PorjectTask.initIndexTaskFlag == 0 ? "未启动" : "已启动")%>
			</td>
			<td>
				<input type="button" value="设置" onClick="chageIITF();">为：<span id="IITF"><%=(PorjectTask.initIndexTaskFlag == 0 ? "停止" : "启动")%></span>
			</td>
		</tr>
		<tr>
			<td>
				主页列表刷新时间：
			</td>
			<td>
				<input type="text" value="<%=PorjectTask.flashTime%>"  size="10" name="flashTime">分
			</td>
		</tr>
   		<tr>
			<td>
			上传附件大小限制：
			</td>
			<td>
				<input type="text" name="uploadSize"  size="10" value="<%=ContentAction.uploadSize%>" />
			</td>
		</tr>	
		<tr>
			<td align="center" colspan="2">
				<input  type="submit" value="确定"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
			</td>
		</tr>
		
		</form>
   </table>
   </td>
	</tr>
  </table>
  </body>
</html>
