
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>合众人寿保险股份有限公司财务部主页</TITLE>
<meta http-equiv="refresh" content="1200">

<script language=javascript>
function openwin(url,winname)
{
    //window.open(url,winname,"width=600,height=500,scrollbars=yes,resizable=yes");    //共用一个窗口
    window.open(url,"","width=600,height=500,scrollbars=yes,resizable=yes,top=10,left=100");    //开多个窗口
}

</SCRIPT>

<SCRIPT language=JavaScript type=text/JavaScript>
<!--

function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);

function MM_displayStatusMsg(msgStr) { //v1.0
  status=msgStr;
  document.MM_returnValue = true;
}

function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</SCRIPT>

<LINK href="dept/caiwu/css.css" type="text/css" rel=stylesheet>
<LINK href="dept/caiwu/normal.css" type="text/css" rel=stylesheet>

<%
		UlTemplate t = (UlTemplate)request.getAttribute("template");
		List<UlColumn> l = (List<UlColumn>)request.getAttribute("columnList");		
		List<UlContent> listg = (List<UlContent>)request.getAttribute("listg");
		List<UlContent> list1 = (List<UlContent>)request.getAttribute("list1");
		List<UlContent> list2 = (List<UlContent>)request.getAttribute("list2");
		
		String titleColor[] = {"#000000","#ffffff","#000000","#0066ff","#009900","#00dddd","#ffccff","#9900cc","#ffcc00","#ff0000"};
			
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<%
		if(t.getCss() != null){
			out.print(t.getCss());
		}
	 %>
</HEAD>

<SCRIPT language=javascript src="dept/caiwu/menu.js"></SCRIPT>
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

<BODY background="<%=t.getPic1()%>" >
<table width="750" cellpadding="0" cellspacing="0" border="0" align="center" bgcolor="#ffffff" >
		<tr>
			<td width="100%" align="center">
				<img src="<%=t.getPic2()%>"  border="0" />
			</td>
		</tr>
		
		<tr><td >
				<table class=boxgray height=26  bgColor=#cccccc >
				<tr vAlign=center align=middle bgColor=#ffffff>
					
					<td onmouseover=changeBackColor(this); align="center" width="94"   onmouseout=recoverBackColor(this); class="menuNormal2">
					<a href="finacial.do?method=index&dept=caiwu&cg=60&c1=54" target="_parent" >首页</a></td>
					<td onmouseover=changeBackColor(this); align="center" width="94"  onmouseout=recoverBackColor(this); class="menuNormal2">
					<a href="dept/caiwu/deptinfo.htm" target="framecenter" >部门简介</a></td>
					<%
						for(int i = 0; i < (l == null ? 0 : l.size()); i++){
					%>
					<td onmouseover=changeBackColor(this); width="94" onmouseout=recoverBackColor(this); class="menuNormal2" align="center">
						<a href="finacial.do?method=subPage1&dept=caiwu&columnId=<%=l.get(i).getColumnId()%>&ptype=t" ><%=l.get(i).getColumnName()%></a>
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
							<TD width=184 height=20 align="center">
								<center>
								<SCRIPT language=javascript>getToday("#003399");</SCRIPT>
								</center>
							</TD>
							<TD width=556 class=p9>							
								<MARQUEE onmouseover=this.stop() scrollamount=2  onmouseout=this.start()>
								欢迎访问合众人寿保险股份有限公司财务部
								</MARQUEE>
							</TD>
						</TR>
				</table>
		</td></tr>		
	</table>

<TABLE cellSpacing=0 cellPadding=0 width=750 align=center bgColor=#ffffff 
border=0>
  <TBODY>
  <TR vAlign=top>
      <TD class=boxgray width=184 height=602> 
        <DIV align=left>
      <TABLE cellSpacing=0 cellPadding=0 width=184 align=center border=0>
        <TBODY>
        <TR>
                <TD class=bigger align=middle width=184 
          background=images/caiwu/top_.jpg height=36><FONT face=楷体_GB2312 
            color=#448d9f size=3><strong>最 新 公 告</strong></FONT></TD>
              </TR>
        <TR>
          <TD background=images/caiwu/column_.jpg>
            <TABLE height=130 cellSpacing=0 cellPadding=0 width=150 align=center 
            border=0>
              <TBODY>
              <TR>
                <TD vAlign=top class=p9>
				<div id="marquees" style="position:absolute; height:100%; z-index:1; overflow: hidden;" onMouseOver="setMouse(1)" onMouseOut="setMouse(0)">
					<%
						for(int i = 0; i < (listg == null ? 0 : listg.size() ); i++){
							out.print("<br>第" + (i + 1) + "条 (" + listg.get(i).getDay() + ")<br>" );
							out.print("<a target='_blank' href='show.do?c=" + listg.get(i).getContentId() + "'>");
							out.println( listg.get(i).getContentName() + "</a><br>***************");
						}
					%>
								</div>
        </TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD><FONT color=#d4d0c8>
			<IMG height=32 
            src="images/caiwu/botton_.jpg" 
      width=183></FONT></TD></TR></TBODY></TABLE>
      <TABLE height=389 cellSpacing=0 cellPadding=0 width=170 align=center 
      bgColor=#ffffff border=0>
        <TBODY>
        <TR>
          <TD class=bigger vAlign=top align=middle colSpan=2 height=35><FONT 
            color=#d4d0c8>
			<IMG height=30 src="images/caiwu/daohang.jpg" 
            width=140></FONT></TD></TR>
        <TR>
          <TD width=42 height=32 style="border-left:1px gray solid;">
			<IMG height=32 
            src="images/caiwu/anniu4.gif" align=left></TD>
          <TD class=bigger align=middle width=128 style="border-right:1px gray solid;">
            <DIV align=left><SELECT onChange="MM_jumpMenu('parent',this,0)" 
            size=1 name=menu2 style="width:130px">
                      <option selected>:::系统链接:::</option>
                     <option value="http://fmis.ulic.com.cn:8000/oa_servlets/AppsLogin">ORACLE-ERP系统</option>
				
                      </SELECT> 
</DIV></TD></TR>
        <TR>
          <TD height=32 style="border-left:1px gray solid;">
			<IMG height=32 src="images/caiwu/anniu3.gif" 
            width=32 align=left></TD>
                <TD style="border-right:1px gray solid;"><select onChange="MM_jumpMenu('parent',this,0)" 
            size=1 name=select style="width:130px">
                    <option selected>:::部门链接:::</option>
                    <option value="http://ulweb">总公司主页</option>
                    </select> </TD>
              </TR>
        <TR vAlign=top>
          <TD colSpan=2 height=263>
            <TABLE height=277 cellSpacing=0 cellPadding=0 width=176 border=0>
                    <TBODY>
              <TR>
                <TD width="176" height=12 vAlign=top></TD></TR>
              <TR>
                        <TD height="75" style="border-bottom:1px gray solid;border-top:1px gray solid;" align="center" valign="middle"> 
                          <DIV align=center><a href="<%=t.getPic6()%>" target="_blank">
							<img border="0" src="images/caiwu/TextEdit.png" width="120" height="50"></a></DIV></TD></TR>
              <TR>
                        <TD height="3" class=p9 ></TD></TR>
						 
              <TR>
                        <TD class=p9 style="border:1px gray solid;" align="center"> 
                         
                       
							
                          <table width="100%" >
						   <form action="finacial.do?method=check" id="idform1" name="form1" method="post" target="framecenter">
						   <input type="hidden" value="caiwu" name="dept" />
						   <input type="hidden" name="ptype" value="t" />
						   <input type="hidden" value="/dept/caiwu/checkshow" name="forward" />
                          <tr>
                          <td height="25"  colspan="2" style="font-size:16px;font-weight:bold;font-family: "楷体_GB2312";" align="center">
                          资料检索</td>
                          </tr>
                          <tr>
                          <td height="25" width="35%">
                          检索依据：</td>
                          <td height="25" width="55%">
                          标题</td>
                          </tr>
                          <tr>
                          <td height="25">
                          类别：</td>
                          <td height="25">
                         <select  name="type" id="idtype" style="width:100px">
								<option value="0" selected>全部</option>
								<%
									for(int i = 0; i < (l == null ? 0 : l.size()); i++){
										out.println("<option value='" + l.get(i).getColumnId() + "'>" + l.get(i).getColumnName() + "</option>");
									}
								%>
						</select></td>
                          </tr>
                          <tr>
                          <td height="25">
                          关键字：</td>
                          <td height="25">
                          <input type="text" name="tName" size="11"></td>
                          </tr>
                          <tr>
                          <td colspan="2" align="center" height="30" >
                          <input type="submit" name="submit" value="开始检索"></td>
                          </tr>
						   </form>
                          </table>
                          
                                                  </TD></TR>
												 
              <TR>
                        <TD align="center" height="77" valign="bottom"><a href="dept/caiwu/uliccas/ulic/index.htm" target=_blank><img border="0" src="<%=t.getPic3()%>" ></a></TD>
                      </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV></TD>
    <TD width=560>
      <TABLE class=boxgray cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR vAlign=top align=middle>
              <TD align=left height=598> 
                <TABLE height=200 cellSpacing=0 cellPadding=0 width="100%" 
            align=center border=0>
              <TBODY>
              <TR bgColor=#ffffff>
                <TD width=215 height=2></TD>
                <TD width=299></TD>
                <TD width=42></TD></TR>
              <TR bgColor=#ffffff>
                <TD vAlign=top width=215 background="images/caiwu/t1.gif" style="background-repeat:no-repeat;">
                  <TABLE cellSpacing=0 cellPadding=0 width="97%" border=0>
                    <TBODY>
                    <TR>
                      <TD width="13%" height=36>　</TD>
                      <TD width="76%">　</TD>
                      <TD width="11%">　</TD></TR>
                    <TR>
                      <TD height=99>　</TD>
                      <TD vAlign=top>
                        <DIV align=right>
							<IMG src="<%=t.getPic5()%>" border="0"  height="105"></DIV></TD>
                      <TD>　</TD></TR>
                    <TR>
                      <TD height=22></TD>
                      <TD height=22>　</TD>
                      <TD height=22>　</TD></TR>
                    <TR>
                      <TD height=1>&nbsp;</TD>
                      <TD align=middle height=1 style="FONT-SIZE: 13px; COLOR: #003399;">热点新闻</TD>
                      <TD>　</TD></TR></TBODY></TABLE></TD>
                <TD width=299 background="images/caiwu/t2.gif">
                  <TABLE height=188 cellPadding=0 width=290 
                  align=right border=0>
                          <TBODY>
                    <TR>
                      <TD width=10 height=30>　</TD>
                              <TD class=box6 colSpan=2>
								<font face="宋体" size="4" color="#008080"><blink>
								<em><strong>合众财苑</strong></em></blink></font></TD>
                            </TR>
							
							<tr>
								<td colspan="3" valign="top">
								<table cellpadding="0" cellspacing="0" border="0" width="100%" >
											 <%
											
												if(list1 != null){
													for(int i = 0; i < list1.size(); i++){					
														out.println("<tr><td height='20'  ></td>");
														out.println("<td colspan='3' valign='top'  ><img src='images/index/a6.gif' width='8' height='8'> ");
														
														if(list1.get(i).getHaveContent() == 0 && list1.get(i).getAttachmentSum() != 0){
															out.print("<a target='_blank' href='show.do?c=" + list1.get(i).getContentId() + "&a=1' style='color:" + titleColor[list1.get(i).getDisplayType()] + "'>");
															out.println(list1.get(i).getContentName() + "</a>&nbsp;" + "/" + list1.get(i).getDay() + list1.get(i).getNewPic(3));					
															out.println("</td><td></td></tr>");			
															if(list1.get(i).getAttachmentSum() > 1){
																out.print("<tr><td></td><td>");
																for(int j = 2; j <= list1.get(i).getAttachmentSum() ; j++){
																	out.print("<a target='_blank' href='show.do?c=" + list1.get(i).getContentId() + "&a=" + j + "'>");
																	out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}else{
															out.print("<a target='_blank' href='show.do?c=" + list1.get(i).getContentId() + "' style='color:" + titleColor[list1.get(i).getDisplayType()] + "'>");
															out.println(list1.get(i).getContentName() + "</a>&nbsp;" + "/" + list1.get(i).getDay() + list1.get(i).getNewPic(3));					
															out.println("</td><td></td></tr>");			
															if(list1.get(i).getAttachmentSum() > 0){
																out.print("<tr><td></td><td>");
																for(int j = 1; j <= list1.get(i).getAttachmentSum() ; j++){
																	out.print("<a target='_blank' href='show.do?c=" + list1.get(i).getContentId() + "&a=" + j + "'>");
																	out.print("附件" + j + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}
																
													}
												}
												
											%>
											</table>
								</td>
								
							</tr>
							
							
							
							<TR>
                              
                             
                            </TR>
                    <TR>
                              <TD height="16">&nbsp;</TD>
                      <TD width=213>　</TD>
                       <TD width=81></TD>
                            </TR></TBODY></TABLE></TD>
                      <TD vAlign=top width=42 background="images/caiwu/t4.gif" style="background-repeat:no-repeat;"> </TD>
                    </TR></TBODY></TABLE>
					<br>
		    <TABLE cellSpacing=0 cellPadding=0 width="100%" height="398" border=0 style="border:1px gray solid;">
			 <tr ><td height="40" width="200" style="color:#008080;font-size:24px;font-weight:bold;font-family:'宋体';font-style: oblique;" >部门格言-----</td>
			 	<td rowspan="2" style=" border-bottom:1px gray solid;" width="270">
			  <img border="0" src="<%=t.getPic4()%>" >   
			 </td>
			 </tr>
			 <tr><td height="40" style="font-family:'宋体';color:#663300;font-size:16pt;font-weight:bold; border-bottom:1px gray solid;" align="center" >              
								制度和服务并重
			            
			 </td></tr>
			<tr><td colspan="2" height="25" ></td></tr>
			   <tr><td colspan="2" valign="top">
			   		<table cellpadding="0"  cellspacing="0" border="0" width="90%" class="contentList" align="center">
											 <%
											
												if(list2 != null){
													for(int i = 0; i < list2.size(); i++){					
														out.println("<tr><td height='20'  ></td>");
														out.println("<td colspan='3' valign='middle'  ><img src='images/index/a6.gif' width='8' height='8'> ");
														if(list2.get(i).getHaveContent() == 0 && list2.get(i).getAttachmentSum() != 0){
															out.print("<a target='_blank' href='show.do?c=" + list2.get(i).getContentId() + "&a=1' style='color:" + titleColor[list2.get(i).getDisplayType()] + "'>");
															out.println(list2.get(i).getContentName() + "</a>&nbsp;" + "/" + list2.get(i).getDay() + list2.get(i).getNewPic(3));					
															out.println("</td><td></td></tr>");			
															if(list2.get(i).getAttachmentSum() > 1){
																out.print("<tr><td></td><td>");
																for(int j = 2; j <= list2.get(i).getAttachmentSum() ; j++){
																	out.print("<a target='_blank' href='show.do?c=" + list2.get(i).getContentId() + "&a=" + j + "'>");
																	out.print("附件" + (j - 1) + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}else{
															out.print("<a target='_blank' href='show.do?c=" + list2.get(i).getContentId() + "' style='color:" + titleColor[list2.get(i).getDisplayType()] + "'>");
															out.println(list2.get(i).getContentName() + "</a>&nbsp;"  + "/" + list2.get(i).getDay() + list2.get(i).getNewPic(3));					
															out.println("</td><td></td></tr>");			
															if(list2.get(i).getAttachmentSum() > 0){
																out.print("<tr><td></td><td>");
																for(int j = 1; j <= list2.get(i).getAttachmentSum() ; j++){
																	out.print("<a target='_blank' href='show.do?c=" + list2.get(i).getContentId() + "&a=" + j + "'>");
																	out.print("附件" + j + "</a> &nbsp;&nbsp;");
																}
																out.print("</td><td></td></tr>");
															}
														}
																
													}
												}
												
											%>
											</table>
			   </td></tr>
			   
             </TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
				<center><iframe src="dept/caiwu/indexbottom.jsp" height="100" width="750" frameborder="0" scrolling="no" ></iframe></center>
	  
	  <SCRIPT LANGUAGE="JavaScript">
<!--
var mousein=0;
var old=document.all.marquees.innerHTML;
var oldpos=document.all.marquees.scrollTop;
function mup(){
	theTimer2=setTimeout("mup()", 100);
	if(mousein==0){
		var pos=document.all.marquees.scrollTop;
		document.all.marquees.scrollTop+=1;
	}
	if(pos!=document.all.marquees.scrollTop){
		pos++;
	}else{
		document.all.marquees.innerHTML+=old;
	}
	if(document.all.marquees.innerHTML.length>10000){
		document.all.marquees.innerHTML=old;
		document.all.marquees.scrollTop=oldpos;
	}
}
function setMouse(value){
	mousein=value;
}
mup();
//-->
</SCRIPT>

	  
	  
	  </BODY></HTML>