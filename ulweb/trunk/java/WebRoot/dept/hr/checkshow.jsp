
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
<head>
<base href="<%=basePath%>">
<title>人力资源部</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<LINK href="style/ul.css" type="text/css" rel=stylesheet>
<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("columnList");		
		
		List<UlContent> list = (List<UlContent>)request.getAttribute("contentList");	
		List<UlContentWithAtt> listLeft = (List<UlContentWithAtt>)request.getAttribute("contentListLeft");		
		String titleColor[] = {"#000000","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
		
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK href="dept/caiwu/css.css" type="text/css" rel=stylesheet>

<style type="text/css">
<!--
.STYLE1 {
	font-family: "楷体";
	font-weight: bold;
	font-size: 16px;
}
-->
</style>
</head>
  	<script type="text/javascript" src="script/hr.js"></script>

<SCRIPT language=javascript src="dept/hr/menu.js"></SCRIPT>
<script language="javascript">
function getToday(color){
clientdate = new Date();
clientyear = clientdate.getYear();
if(clientyear < 300)clientyear = 1900 + clientyear;
clientmonth = clientdate.getMonth()+1;
clientday = clientdate.getDate();
weekday = clientdate.getDay();
if (weekday==0)
{
weekday="天"
}
if (weekday==1){
weekday="一"
}
if (weekday==2)
{
weekday="二"
}
if (weekday==3)
{
weekday="三"
}
if (weekday==4)
{
weekday="四"
}
if (weekday==5)
{
weekday="五"
}
if (weekday==6)
{
weekday="六"
}
document.write("<font color="+color+">"+clientyear+"年"+clientmonth+"月"+clientday+"日"+" 星期"+weekday+"</font>");
}

</script>
  <body   background="<%=t.getPic1()%>" >
<table width="760"  cellpadding="0" cellspacing="0" border="0" align="center" bgcolor="#ffffff" >
		<tr>
			<td width="100%" align="center">
				<img src="<%=t.getPic2()%>"  border="0" />
			</td>
		</tr>
		
		<tr><td >
				<table class=boxgray height=26   width="100%" border="0" cellspacing="0">
				<tr vAlign=center align=middle bgColor=#ffffff>
		<!--			
					<td onmouseover=changeBackColor(this); align="center" width="94"   onmouseout=recoverBackColor(this); class="menuNormal2">
					<a href="hr.do?method=index&dept=hr" target="_parent" >首页</a></td>
					<td onmouseover=changeBackColor(this); align="center" width="94"  onmouseout=recoverBackColor(this); class="menuNormal2">
					<a href="dept/hr/deptinfo.htm" target="framecenter" >部门简介</a></td>
		-->
					<%
						for(int i = 0; i < (l == null ? 0 : l.size()); i++){
					%>
					<td onmouseover=changeBackColor(this);  onmouseout=recoverBackColor(this); class="menuNormal2" align="center"   >
						<a href="hr.do?method=subPage1&dept=hr&l1c=<%=(request.getParameter("l1c") == null ? "99" : request.getParameter("l1c"))%>&columnId=<%=l.get(i).getColumnId()%>"  ><%=l.get(i).getColumnName()%></a>
					</td>
					<%
						}
					%>
				
				</tr>
			</table>
		</td></tr>
		<tr><td>
		<table cellpadding="0" cellspacing="0" border="0" width="750" align="center">
						<TR>
							<TD width=184 height=20 align="left">								
								<SCRIPT language=javascript>getToday("#003399");</SCRIPT>								
							</TD>
							<TD width=556 class=p9>						
								
							</TD>
						</TR>
				</table>
		</td></tr>		
	<tr><td>
		<table cellspacing="0"  background="<%=t.getPic3()%>" >
			<tr><td valign="top">
				<table width="220" cellspacing="0">
					
					<tr>
						<td >
							   <table width="100%"  cellspacing="0">
						   <form action="hr.do?method=check" id="idform1" name="form1" method="post" >
						   <input type="hidden" value="hr" name="dept" />
						   <input type="hidden" name="ptype" value="<%=(request.getParameter("ptype") == null ? "" : request.getParameter("ptype"))%>" />
						   <input type="hidden" value="/dept/hr/checkshow" name="forward" />
                          <tr>
                          <td height="25"  colspan="2"  align="left">
						  &nbsp;文件查询						  </td>
						  <td colspan="2" align="right">
						  	<a href="javascript:document.form1.submit();" style="color:black;">搜索&gt;&gt;</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>	
                          </tr>                      
                          <tr>
                          <td width="50" height="25"  align="left">
                          &nbsp;标题：</td>
                          <td height="25" colspan="3" align="left">
                          <input type="text" name="tName" size="22"></td>
                          </tr>
						  <tr>
                          <td height="25"  align="left">
                          &nbsp;类别：</td>
                          <td height="25"  colspan="3" align="left"><select  name="type" id="idtype" style="width:143px">
                            <option value="0" selected>全部</option>
                            <%
									for(int i = 0; i < (l == null ? 0 : l.size()); i++){
										out.println("<option value='" + l.get(i).getColumnId() + "'>" + l.get(i).getColumnName() + "</option>");
									}
								%>
                          </select></td>
                          </tr>
                       	<tr><td colspan="4" height="15"></td></tr>
						   </form>
                          </table>
                          
                       
						</td>
					</tr>
					<!------登录人事系统-
					<tr>
						<td >
							
                           <table width="100%"  cellspacing="0">
						   <form action="http://10.18.1.115:8088/hr/system/dologin.do" id="idform2" name="form2" method="post" >
						 
                          <tr>
                          <td height="25"  colspan="2"  align="left">
						  &nbsp;人事系统						  </td>
						  <td colspan="2" align="right">
						  <a href="javascript:document.form2.submit();" style="color:black;">登录&gt;&gt;</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:alert('人事系统还没有正式上线\n\n请等待正式上线后再登录');" style="color:black;">登录&gt;&gt;</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>	
                          </tr>                      
                          <tr>
                          <td width="50" height="25"  align="left">
                          &nbsp;用户：</td>
                          <td height="25" colspan="3" align="left">
                          <input type="text" name="userName" size="22" /></td>
                          </tr>
						  <tr>
                          <td height="25"  align="left">
                          &nbsp;密码：</td>
                          <td height="25"  colspan="3" align="left"><input type="password" size="24" name="password" />
						  
						  </td>
                          </tr>
                       	<tr><td colspan="4" height="15"></td></tr>
						   </form>
                          </table>
                          
                          
						</td>
					</tr>	
					--->	
						<%
							for(int i = 0; i < (listLeft == null ? 0 : listLeft.size()); i++){					
								out.println("<tr>");
								out.println("<td valign='top'  height='20' ><br><br>");								
									out.print("<a target='_blank' href='show.do?c=" + listLeft.get(i).getContentId() 
										+ "&ptype=hr' style='color:" + titleColor[listLeft.get(i).getDisplayType()] + "'>");
									out.println(listLeft.get(i).getContentName() + "&nbsp;&nbsp;" + listLeft.get(i).getDay() );	
									out.println("<br>" + listLeft.get(i).getAtt(1).getImg(220) + "</a>");				
									out.println("</td></tr>");									
										
							}
						%>
				</table>				
			</td>
			<td>	
		
				<table width="540" cellpadding="0" cellspacing="0" border="0" align="center"  >	
					<tr><td height="10"></td></tr>
					<tr><td height="450" valign="top">	
						<table cellspacing="2" width="100%" class="contentList"  align="center" border=0 >
							 <%
							
								if(list != null){
									for(int i = 0; i < list.size(); i++){					
										out.println("<tr>");
										out.println("<td valign='middle'  height='20' >&nbsp;&nbsp;&gt;&gt; ");
										if(list.get(i).getHaveContent() == 0 && list.get(i).getAttachmentSum() != 0){
											out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() 
												+ "&a=1' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
											out.println(list.get(i).getContentName() + "&nbsp;&nbsp;" + list.get(i).getDay() + "</a>");					
											out.println("</td></tr>");	
										}else{
											out.print("<a target='_blank' href='show.do?c=" + list.get(i).getContentId() 
												+ "' style='color:" + titleColor[list.get(i).getDisplayType()] + "'>");
											out.println(list.get(i).getContentName() + "&nbsp;&nbsp;" + list.get(i).getDay() + "</a>");					
											out.println("</td></tr>");			
											
										}
												
									}
								}
								
							%>
							</table>
						</td></tr>
						<tr><td>
			
					
						<table border="0" width="100%">
															
														<tr>
						<form  method="post" name="forms" id="idforms">
						<input type="hidden" name="condition" id="idcondition" value="<%=request.getAttribute("condition")%>" />
						<input type="hidden" name="columnId" value="<%=request.getAttribute("columnId")%>" />
						<input type="hidden" name="ptype" value="<%=(request.getAttribute("ptype") == null ? "" : request.getAttribute("ptype"))%>" />
							<td colspan="5">
								<%
									int pageSum = 1;
									int pageNow = 1;					
									if(request.getAttribute("totlePage") != null){
				
										pageSum = (Integer)request.getAttribute("totlePage");
									}
									if(request.getAttribute("page") != null){
										pageNow = (Integer)request.getAttribute("page");
									}
									if(pageSum > 1){
										out.print("现在是第" + pageNow + "页&nbsp;&nbsp;&nbsp;");
										out.print("共" + pageSum + "页 &nbsp;&nbsp;");
										if(pageNow != 1){
											out.print("<a href='javascript:gotocP(" + (pageNow - 1) + ");'>上一页</a>&nbsp;&nbsp;");
										}						
										out.print("<a href='javascript:gotocPage();' >转到</a>&nbsp;第");
										out.print("<input id='idpage' name='page' size='3' maxlength='3' type='text'></input>页");
										if(pageNow != pageSum){
											out.print("<a href='javascript:gotocP(" + (pageNow + 1) + ");'>下一页</a>&nbsp;&nbsp;");
										}
									}
								%>
							</td>
							</form>
							</tr><tr><td height="30"></td></tr>								
						</table>
													
							</td>
						</tr>
					</table>
					</td>
				</tr>				
			</table>
		</td></tr>
		<tr>
			<td  width="100%" height="20">
				<iframe src="dept/hr/indexbottom.jsp" height="100" width="100%" frameborder="0" scrolling="no" ></iframe>
			</td>
		</tr>
	</table>
  </body>
</html>
