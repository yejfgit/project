
<%@ page language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.entity.UlReport" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editreport.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  <script src="script/filter.js" language="JavaScript"></script>
  <body>
    <table  align="center" border="0" width="450">
		<form action="admin/report.do?method=save" method="post" name="form1">
		<tr> 
			<td >&nbsp;&nbsp;
				个险：现在为&nbsp;&nbsp; <%=Constant.gexianbaofei%>
			</td>
		</tr>
		<tr>
			<td style="border:gray 1px solid; ">&nbsp;&nbsp;
				改为：<input type="text" name="gexian" maxlength="10" id="idgexian" size="10"  onKeyUp="onlyNumber('idgexian');"></input>
			</td>
		</tr>
		<tr>
			<td >&nbsp;&nbsp;
				团险：现在为&nbsp;&nbsp; <%=Constant.tuanxianbaofei%>
			</td>
		</tr>
		<tr>
			<td style="border:gray 1px solid;">&nbsp;&nbsp;
				改为：<input type="text" name="tuanxian" maxlength="10" id="idtuanxian" size="10" onKeyUp="onlyNumber('idtuanxian');"></input>
			</td>
		</tr>
		<tr>
			<td >&nbsp;&nbsp;
				银代：现在为&nbsp;&nbsp; <%=Constant.yindaibaofei%>
			</td>
		</tr>
		<tr>
			<td style="border:gray 1px solid;">&nbsp;&nbsp;
				改为：<input type="text" name="yindai" maxlength="10" id="idyindai" size="10" onKeyUp="onlyNumber('idyindai');"></input>
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="确定" />
			</td>
		</tr>
		<tr>
			<td>
				<table align="center" width="100%" border="1" cellspacing="0">
					<tr><td>日期</td><td>个险</td><td>团险</td><td>银代</td></tr>
					<%
						if(request.getAttribute("list") != null){
							List<UlReport> list = (List)request.getAttribute("list");
							for(int i = 0 ; i < list.size(); i++ ){
								%>
						<tr>
							<td>
								<%=list.get(i).getSaveTime().toString().substring(0,list.get(i).getSaveTime().toString().indexOf(" "))%>
							</td>
							<td>
								<%=list.get(i).getPersonal()%>
							</td>
							<td>
								<%=list.get(i).getGroup()%>
							</td>
							<td>
								<%=list.get(i).getBank()%>
							</td>
						</tr>
								<%
							}
						}
					%>
				</table>
			</td>
		</tr>
		</form>
	</table>
  </body>
</html>
