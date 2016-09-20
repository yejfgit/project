
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page   language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查找结果</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
 
<script language="JavaScript">
function openwin(url,winname)
{
    //window.open(url,winname,"width=600,height=500,scrollbars=yes,resizable=yes");    //共用一个窗口
    window.open("../list/" + url,"","width=600,height=500,scrollbars=yes,resizable=yes");    //开多个窗口
}
function openwint(url,winname)
{
    window.open("../list/" + url,winname,"width=1024,height=768,scrollbars=yes,menubar=no,resizable=yes");    //共用一个窗口
 //   window.open(url,"","width=600,height=500,scrollbars=yes,resizable=yes");    //开多个窗口
}

function checkIsValidDate()
{
    if(DateObj2StandardFmt(document.all.form1.ts) && DateObj2StandardFmt(document.all.form1.te))
		return true;
	else
		return false;
}

</script>
 <script language="JavaScript" src="script/date.js"></script>
  <script language="JavaScript" src="script/check.js"></script>
  <script language="JavaScript" src="script/CheckData.js"></script>
<body>

	<table cellpadding="0" width="760" cellspacing="0" border="0" align="center" >
		<tr>
			<td>
				<table width=100% cellPadding=0 
                  cellSpacing=0 bgcolor="#FFFFFF"   >
						<!--DWLayoutTable tile-->
						<tr> 
						  <td width="4" height="4"></td>
						  <td width="106"></td>
						  <td width="1"></td>
						  <td width="637"></td>
						</tr>
						<tr> 
						  <td height="60" colspan="3" valign="top"><img src="images/index/logo.gif" width="117" height="60"></td>
						  <td rowspan="4" valign="top" width="639" background="images/index/shuye.jpg" style="background-repeat:no-repeat;"></td>
						</tr>
						<tr> 
						  <td height="1"></td>
						  <td></td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="9"></td>
						  <td rowspan="2" valign="top" align="center">和 你 在 一 起</td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="30"></td>
						  <td></td>
						  <td></td>
						</tr>
						<tr> 
						  <td height="2"></td>
						  <td></td>
						  <td></td>
						  <td></td>
						</tr>
					  </table>
			</td>
		</tr>
		<tr><!--   title    -->
			<td><iframe src="frame/indextitle.jsp" width="760" height="40" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
		<tr><!-- 		titlepic		-->
			<td align="center"></td>
		</tr>
		<tr>
			<!--			content			-->
			<td >
					<table width="100%" style="border-right: gray 1px solid;">
						<tr>
							<td></td>
							<td width="5%"></td>
							<td></td>
						</tr>
						<tr>
							<td width="30%" valign="top">
								<table width="100%" style="border: gray 1px solid;">
									<tr><td height="10"></td></tr>
									<tr><td align="center">
										<table cellpadding="0" cellspacing="0" border="0" width="200" align="center">
		<form action="check.do?method=zongbu" id="idform1" name="form1" method="post" target="resultList" onSubmit="return checkIsValidDate();">
		<tr>
			<td>
				<table width="100%" cellspacing="0" border="1">
					<tr>
						<td align="center">
							标题
						</td>
						<td>
							<input type="text" name="tName" size="15" maxlength="30"></input>
						</td>
					</tr>
					<tr>
						<td align="right">
							从
						</td>
						<td>
							<input type="text" name="ts" size="10" maxlength="10" onKeyUp="if(event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 8)value=value.replace(/[^\d-]/g,'')" id="demo" value="2005-2-3"></input>
							<IMG onClick="Calendar.display('demo', event)" src="images/index/calendar.gif" align=absMiddle> 
						</td>
					</tr>
					<tr>
						<td align="right">
							至
						</td>
						<td>
							<input type="text" name="te" size="10" maxlength="10" id="demo1" onKeyUp="if(event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 8)value=value.replace(/[^\d-]/g,'')" value="2008-12-31"></input><script type="text/javascript">dt=new Date();document.getElementById("demo1").value=dt.getYear()+"-"+(dt.getMonth()+1)+"-"+dt.getDate();</script>
							<IMG onClick="Calendar.display('demo1', event)" src="images/index/calendar.gif" align=absMiddle>
						</td>
					</tr>
					<tr>
						<td align="center">
							类别
						</td>
						<td>
							
<ulweb:column beanName="sl" deptId="0000" columnId="6" withSub="1" />
							
							
							<select name="type" id="idtype">
				<option value="0">不限</option>  
				<option value="8">合众播报</option>             
                <option value='1'>公告</option>
                
<logic:iterate id="element" name="sl" property="subColumns">
	<option value="<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></option>
</logic:iterate>
                
                
<!--               
				<option value="3">合保人</option>
				<option value="4">合保会纪</option>
				<option value="5">合保办</option>
				<option value="6">合保发</option>
				<option value="7">合保复</option>
				<option value="567">合保工会发</option>
				<option value="1287">合保董</option>
                <option value='10'>合众简报</option>
                <option value='11'>机构发展快讯</option>
                <option value='12'>行业资讯</option>
                <option value='14'>理赔案例</option>
				<option value='15'>理赔新闻</option>
 -->				
              </select>
						</td>
					</tr>
					<tr>
						<td align="center">
							文号
						</td>
						<td>
							<input type="text" name="dNum" size="15" maxlength="15"></input>
						</td>
					</tr>
					<tr>
						      <td colspan="2" align="center"> <input name="button"  type="submit"  value="查找"/></td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
	</table>								
									</td></tr>
									<tr><td height="15"></td></tr>
									
									<tr><td></td></tr>
									<tr valign="bottom"><td align="center">
										<img src="images/index/qianbi.jpg" border="0" width="220" /></td></tr>
									<tr><td height="10"></td></tr>
									<tr valign="bottom">
								<td align="center" >&nbsp; </td>
							  </tr>
								</table>
							</td>
							<td></td>
							  <td width="65%" valign="top">
							  	<iframe frameborder="0" name="resultList" scrolling="no" width="100%" height="600" src="frame/checkshowindex.jsp" ></iframe>
							   </td>
						</tr>
						
					</table>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="indexbottom.jsp" />
			</td>
		</tr>
		<tr><td height="30"></td></tr>
	</table>
  </body>
</html>
