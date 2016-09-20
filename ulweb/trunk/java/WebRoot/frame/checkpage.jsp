
<%@ page language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkpage.jsp' starting page</title>
    
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
  <script language="JavaScript" src="script/date.js"></script>
  <script language="JavaScript" src="script/check.js"></script>
  <body>
    <table cellpadding="0" cellspacing="0" border="0" width="200" align="center">
		<form action="check.do?method=zongbu" id="idform1" name="form1" method="post">
		<tr>
			<td>
				<table width="100%" cellspacing="0" border="1">
					<tr>
						<td align="center">
							关键字
						</td>
						<td>
							<input type="text" name="tName" size="15" maxlength="15"></input>
						</td>
					</tr>
					<tr>
						<td align="right">
							从
						</td>
						<td>
							<input type="text" name="ts" size="10" maxlength="10" onKeyUp="value=value.replace(/[^\w- ]/g,'')" id="demo" ></input>
							<IMG onclick="Calendar.display('demo', event)" src="images/index/calendar.gif" align=absMiddle> 
						</td>
					</tr>
					<tr>
						<td align="right">
							至
						</td>
						<td>
							<input type="text" name="te" size="10" maxlength="10" id="demo1" onKeyUp="value=value.replace(/[^\w- ]/g,'')" ></input>
							<IMG onclick="Calendar.display('demo1', event)" src="images/index/calendar.gif" align=absMiddle>
						</td>
					</tr>
					<tr>
						<td align="center">
							类别
						</td>
						<td>
							<select name="type" id="idtype">
                <option value='<%=Constant.gongwen%>'>公文</option>
                <option value='<%=Constant.gonggao%>'>公告</option>
                <option value='<%=Constant.hezhongjianbao%>'>合众简报</option>
                <option value='<%=Constant.jigoufazhankuaixun%>'>机构发展快讯</option>
                <option value='<%=Constant.hangyezixun%>'>行业资讯</option>
                <option value='<%=Constant.yejibobao%>'>业绩播报</option>
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
						<td colspan="2" align="center">
							<input type="submit"  value="查找" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
	</table>
  </body>
</html>
