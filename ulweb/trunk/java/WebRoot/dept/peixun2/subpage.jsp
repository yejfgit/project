<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
	DisplayOnPage d = new DisplayOnPage();
	d.setRequest(request);
	UlColumn c = (UlColumn)request.getAttribute("column");
		
	List<UlColumn> subColumnList = (List<UlColumn>)request.getAttribute("subColumnList");
	List<UlContent> intro = (List<UlContent>)request.getAttribute("intro");

	int i;
	String introPath = "";
	for(i = 0; i < intro.size(); i++){
		introPath = "show.do?c=" + intro.get(0).getContentId() + "&a=1";
	}
		

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>培训部主页 - <%=c.getColumnName()%></title>

<style type="text/css">
<!--
.topNav ,a {
	font-family: "隶书";
	font-size: 20px;
	text-decoration:none;
	color:#000000;
}
.topNav a:hover {
	font-family: "隶书";
	font-size: 20px;
	text-decoration:underline;
	color:#000000;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
td{
	font-size:14px;
	line-height:20px;
}
.topNav2 {color: #FF0000}
.centerTitle {
	font-family: "隶书";
	font-size: 24px;
	color: #FF0000;
}
.leftTitle {font-family: "隶书"; font-size: 24px; }
.leftCol a { 
	font-family:"宋体"; 
	font-size:14px;
	text-decoration:none;
	line-height:25px;
}
.leftCol a:hover { 
	text-decoration:underline;
}
.centerCol a { 
	font-family:"宋体"; 
	font-size:14px;
	text-decoration:none;
	line-height:25px;
}
.centerCol a:hover { 
	text-decoration:underline;
}
p {
	margin:8px;
}
img {
	border:0px;
}
-->
</style>

<script type="text/javascript">

function page(no) {
	var url = location.href;
	url = url.replace(/&?page=\d+/g, "") + "&page=" + no;
	location.href = url;
}

</script>


<script type="text/javascript" src="script/peixun2.js"></script>
<script language="JavaScript" src="script/ajax.js"></script>
<script language="JavaScript" src="script/dtree.js" type="text/javascript" ></script> 
<script language="JavaScript" src="script/column.js"></script>
</head>

<body>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#105631">
  <tr>
    <td>&nbsp;</td>
    <td width="800"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="800" height="200"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="800" height="200">
          <param name="movie" value="dept/peixun2/peixun3.swf" />
          <param name="quality" value="high" />
          <embed src="dept/peixun2/peixun3.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="800" height="200"></embed>
        </object></td>
      </tr>
      <tr>
        <td><div style="border-bottom:solid #111111 1px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="50" height="30">&nbsp;</td>
            <td width="300">&nbsp;</td>
            <td class="topNav"><a href="<%=introPath%>" target="_blank">培训部风采</a></td>
            <td class="topNav"><a href="http://ulweb/newapp/index.do" target="_blank">总公司主页</a></td>
            <td class="topNav"><a href="admin/index.jsp" target="_blank">系统管理</a></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="15"></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="250" valign="top">
			<div style="padding:0px 0px 0px 15px; border-right:solid #CCCCCC 1px;">
			  <div class="leftCol" style="padding:5px 0px 5px 0px;">
			  
			  	<%=request.getAttribute("columnList")%>
				
			  </div>
            </div>			</td>
            <td width="550" valign="top">
				<div class="centerCol" style="padding:0px 0px 0px 0px; margin:0px 0px 10px 10px; font-weight:bold; font-size:16px;"><%=c.getColumnName()%></div>
             	<div style="padding:10px 0px 10px 20px; border-top:solid #CCCCCC 1px;">
             	  
				  <% if (subColumnList.size() <= 0) { %>
				  <div class="centerCol"><%=d.divContent("contentList",3)%></div>
				  <% } else { %>
				  <div class="centerCol"><%=d.divColumn("subColumnList", "peixun2.do?method=subPage&", 0)%></div>
				  <% } %>
					
				</div>
				<div class="centerCol" style="padding:10px 0px 10px 20px;">
				<%=d.showPageBar() %>
					
				</div></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div style="padding:10px 5px 30px 5px; border-top:solid #111111 1px; color:#333333; text-align:center;">合众人寿保险股份有限公司 培训部</div></td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
