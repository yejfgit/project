
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page   language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name=request.getParameter("tName");
String tName=new String(name.getBytes("ISO-8859-1"),"UTF-8") ;
String ts=request.getParameter("ts");
String te=request.getParameter("te");

String name2=request.getParameter("typeName");
String typeName=new String(name2.getBytes("ISO-8859-1"),"UTF-8") ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查找结果</title>
    <style type="text/css">
  	.xtt{ background: no-repeat center bottom; border:0px solid #ccc; border-top:0px ; border-bottom:0px; padding:0 0px;}

.xtt li{ no-repeat center bottom;  line-height:25px; font-size:12px;}
           Input
				{
				BORDER-BOTTOM: ##FF00FF 0px solid;
				BORDER-LEFT: ##FF00FF 0px solid;
				BORDER-RIGHT: ##FF00FF 1px solid;
				BORDER-TOP: ##FF00FF 1px solid;
				COLOR: #000000;
				HEIGHT: 18px;
				border-color: #F5FFFA; 
				font-size: 12px
				}
  	</style>
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
window.onload = function(){
	document.form1.action = "cacCheck.do?method=zongbu";
	document.form1.submit();
	 
	
}
</script>
 <script language="JavaScript" src="script/date.js"></script>
  <script language="JavaScript" src="script/check.js"></script>
  <script language="JavaScript" src="script/CheckData.js"></script>
<body style="background-color: #eee">

	<table cellpadding="0" width="980px" cellspacing="0" border="0" align="center" style="background-color: #fff">
		<tr>
			<td width="100%" >
				<table width="980" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
					<tr>
						<td width="300" height="142" background="dept/cac/images/newBg_2Picture.png">
						</td>
						<td width="680" height="142" background="dept/cac/images/newBgpicture2.png">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		
		<tr><!--   title    -->
			<td>
				<table width="980px" border="0" cellspacing="0" cellpadding="0" style="background:url(dept/cac/images/newHead.png);margin-top:-2px">
				<tbody>
					<tr>
				        <td width="112px" height="33px" align="center"><a href="cacCheck.do?method=index" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>首页</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5664" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>部门介绍</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5484" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>中心汇</strong></font></a></td>
				        <td width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5485" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>集中云</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5486" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>风采秀</strong></font></a></td>
				        <td  width="112px" height="33px" align="center"><a href="dept/cac/kjlist.jsp?id=5504" target="_self"><font color="#ffffff"style="font-size:16px;font-family:宋体"><strong>知识窗</strong></font></a></td>
				        <td  width="112px" align="center"><a href="dept/cac/kjlist.jsp?id=5506" target="_self"><font color="#ffffff" style="font-size:16px;font-family:宋体"><strong>数据库</strong></font></a></td>
					    <td  width="170px" height="33px" align="right">
						<script language="JavaScript" type="text/JavaScript">
							var day="";
							var month="";
							var ampm="";
							var ampmhour="";
							var myweekday="";
							var year="";
							mydate=new Date();
							myweekday=mydate.getDay();
							mymonth=mydate.getMonth()+1;
							myday= mydate.getDate();
							myyear= mydate.getYear();
							year=(myyear > 200) ? myyear : 1900 + myyear;
							if(myweekday == 0)
							weekday=" 星期日 ";
							else if(myweekday == 1)
							weekday=" 星期一 ";
							else if(myweekday == 2)
							weekday=" 星期二 ";
							else if(myweekday == 3)
							weekday=" 星期三 ";
							else if(myweekday == 4)
							weekday=" 星期四 ";
							else if(myweekday == 5)
							weekday=" 星期五 ";
							else if(myweekday == 6)
							weekday=" 星期六 ";
							document.write("<font color= #ffffff style= font-size:12px;font-family:宋体>"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</font>");
						</script></td>
						<td width="1"></td>
					</tr>
				   </tbody>
				</table>
			 </td>
		</tr>
		
		
		<tr >
			<!--			content			-->
			<td >
					<table width="100%" style="border-right: gray 0px solid;height:500px;margin-left:20px;">
						<tr height="30px"> <td></td></tr>
						<tr>
							<td width="230px" valign="top">
								<table width="230px" style="border-right: gray 0px solid; align:center;height:400px">
									
									<tr><td align="left" valign="top">
									 <form action="cacCheck.do?method=zongbu" id="idform1" name="form1" method="post" target="ttt" onSubmit="return checkIsValidDate();">
										<table cellpadding="0" cellspacing="0" border="0" width="230px" height="150" align="left" style="border: 0px solid;background:url(dept/cac/images/newBorderg_1.png);">
											<tr><td height="35" align="center"  >
												<span style="width: 100px; padding: 1px 1px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>资&nbsp;料&nbsp;检&nbsp;索</strong></span>
												</td></tr>
											<tr>
												<td>
													<table width="230px" cellspacing="0" border="0" >
														<tr>
															<td align="center" height="40px">
																&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:10pt;font-family:宋体"><strong>检索词:</strong></span>
															</td>
															<td>
																<input type="text" name="tName" size="15" maxlength="30" value="<%=tName%>" height="25px"></input>
															</td>
														</tr>
														<tr>
															<td>
																<input type="hidden" name="ts" size="10" maxlength="10" onKeyUp="if(event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 8)value=value.replace(/[^\d-]/g,'')" id="demo" value="<%=ts%>"></input>
															</td>
														</tr>
														<tr>
															<td>
																<input type="hidden" name="te" size="10" maxlength="10" id="demo1" onKeyUp="if(event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 8)value=value.replace(/[^\d-]/g,'')" value="<%=te%>"></input>
																<script type="text/javascript">dt=new Date();document.getElementById("demo1").value=dt.getYear()+"-"+(dt.getMonth()+1)+"-"+dt.getDate();</script>
															</td>
														</tr>
														<tr>
															<td align="center" height="40px">
															  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="font-size:10pt;font-family:宋体"><strong>类别:</strong></span>
															</td>
																	<td>
																	
																	<select name="type" id="select" style="border-color:#F5FFFA;width:100px;height:25px">
																			
																			<option value="5224" <% if(typeName.equals("5224")) out.print(" selected=\"selected\""); %> >中心汇</option>
																			<option value="5226" <% if(typeName.equals("5226")) out.print(" selected=\"selected\""); %>>集中云</option>
																			<option value="5227" <% if(typeName.equals("5227")) out.print(" selected=\"selected\""); %>>风采秀</option>
																			<option value="5228" <% if(typeName.equals("5228")) out.print(" selected=\"selected\""); %>>知识窗</option>
																			<option value="5229" <% if(typeName.equals("5229")) out.print(" selected=\"selected\""); %>>数据库</option>
																			<option value="0" <% if(typeName.equals("0")) out.print(" selected=\"selected\""); %>>不限</option>
																			</select>
																										
																	</td>
																</tr>
														<tr>
						             						<td colspan="2" align="center"> &nbsp;&nbsp;&nbsp;&nbsp;<input name="button"  type="submit"  value="开始检索" style="border-color:#F5FFFA;width:60px;height:22;padding: 2px 2px;"/></td>
					                                    </tr>
				</table>
			</td>
		</tr>
	</table>
	</form>								
									</td></tr>
									<tr>
									<td>
									<table height="160" style="background:url(dept/cac/images/newBorderg_2.png) no-repeat;">
									<tr>
				    <td width="230px" height="40" align="center" valign="middle" ><span style="width: 100px; padding: 0px 0px; color: #FF6600;font-size:14pt;font-family:宋体"><strong>网&nbsp;站&nbsp;导&nbsp;航</strong></span></td>
				</tr>
									<tr>
					         <td valign="top">
								<DIV >
          <div id="linkbox" style="position:relative; ">
                <div style="height: 165px;">
                      <div id="link1" class="xtt" style="height: 100px;display: block;">
                      
  <ul>
<ulweb:content beanName="cl" deptId="cac" enName="daohang" pageNum="1" pageSize="7" conditions="isDelete=0:i;isProcessing=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			<li>·<a style="font-size:10pt;font-family:宋体" href="<bean:write name="element" property="subTitle" />" target="_blank"><span style="font-size:14px;font-family:宋体"><bean:write name="element" property="contentName" /></span></a></li>
		</logic:iterate>

</ul>
                       </div>
                     <div  style="display:inline;top:340px; left:91px;">
<table style="position:relative;">
 <script>
	var lastlbt = 'lbt1';
	
	function changelbtColor(lbt){
		var last = document.getElementById(lastlbt);
		last.style.backgroundColor='#EFEFEF';
		last.style.color='#000000';
		
		lbt.style.backgroundColor='#4DAC26';
		lbt.style.color='#FFFFFF';
		lbt.style.cursor='hand'
		
		lastlbt = lbt.id;
	}
</script>
</td>
</tr>
</table>

</table>
                    </div>

                      <div class=bank5></div>
          </div>
</DIV>
			 </td>
			 
			 	</tr>
						
											</table>
							</td>
							  <td width="70%" valign="top">
							  	<iframe frameborder="0" name="ttt" id="resultList" scrolling="no" width="100%" height="550px" src="dept/cac/checkshowindex.jsp" ></iframe>
							   </td>
						</tr>
						
					</table>
			</td>
		</tr>
		
		<tr><td background="dept/cac/images/main_41.gif" width="980px" height="40px" align="center">Copyright2014 版权所有 合众人寿保险股份有限公司 会计集中作业中心</td>
		</tr>
	</table>
  </body>
</html>
