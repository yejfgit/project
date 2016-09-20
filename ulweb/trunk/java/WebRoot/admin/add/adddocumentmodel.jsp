
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>add documentModel</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
      <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  <script language="JavaScript" src="script/documentModel.js"></script>
  <body>
    <table width="750" border="0" cellspacing="0" cellpadding="0" align="center">
  <form action="admin/document.do?method=addModel"  method="post" name="form1" id="idform1" >
 
  <tr>
    <td>
		<table border="1" cellpadding="0" cellspacing="0" width="100%">
			
			<tr>
				<td align="right">
					id:
				</td>
				<td>
					<input name="modelId"  id="idmodelId" value="1" ></input>
				</td>
			</tr>
			<tr>
				
            <td align="right"> 头head: </td>
				<td>
					<textarea cols="70" name="hhead" rows="5"></textarea>
				</td>
			</tr>
			
			
			<tr>
				
            <td  align="right"> 红色横线hr1: </td>
				<td>
					<textarea cols="70" name="hhr1" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					标题title:
				</td>
				<td>
					<textarea cols="70" name="htitle" rows="5"></textarea>
					
				</td>
			</tr>
			<tr>
				<td align="right">
					印章位置seal:
				</td>
				<td>
					<textarea cols="70" name="hseal" rows="5"></textarea>
				</td>
			</tr>
			
			<tr>
				<td align="right">
					空行位置2pageblank:
				</td>
				<td>
					<textarea cols="70" name="h2pageblank" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					主题词zhutici:
				</td>
				<td>
					<textarea cols="70" name="hzhutici" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					抄送:
				</td>
				<td>
					<textarea cols="70" name="hchaosong" rows="5"></textarea>
					
				</td>
			</tr>
			<tr>
				<td align="right">
					打印:
				</td>
				<td>
					<textarea cols="70" name="hdayin" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					共打印:
				</td>
				<td>
					<textarea cols="70" name="hgongdayin" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					承办:
				</td>
				<td>
					<textarea cols="70" name="hchengban" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					电话:
				</td>
				<td>
					<textarea cols="70" name="hdianhua" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					公司:
				</td>
				<td>
					<textarea cols="70" name="hgongsi" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					时间:
				</td>
				<td>
					<textarea cols="70" name="hshijian" rows="5"></textarea>
					
				</td>
			</tr>
			<tr>
				<td align="right">
					最下边:
				</td>
				<td>
					<textarea cols="70" name="hbottom" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					附加1 add1:
				</td>
				<td>
					<textarea cols="70" name="hadd1" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					附加2 add2:
				</td>
				<td>
					<textarea cols="70" name="hadd2" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td align="right">
					附加3 add3:
				</td>
				<td>
					<textarea cols="70"  name="hadd3" rows="5"></textarea>
				</td>
			</tr>
			
				
			<tr>
				<td colspan="2" align="center" >
					<input type="button" onClick="javascript:submitForm1();"  value="确定" />
					&nbsp;&nbsp;
					<input type="reset" value="重置" />
					&nbsp;&nbsp;
					<a href="javascript:viewModel();" >预览</a>
				</td>
			</tr>
		</table>
	</td>
  </tr>
  </form>
</table>
  </body>
</html>
