<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String enName = request.getParameter("eId");
	String keyWord = request.getParameter("keyWord");
	String strId = request.getParameter("id");
	String strPage = request.getParameter("pageNum");
	
	
	int columnId;
	try {
		columnId = Integer.parseInt(strId);
	} catch (Exception e) {
		columnId = 0;
	}
	
	int pageNum;
	try {
		pageNum = Integer.parseInt(strPage);
	} catch (Exception e) {
		pageNum = 1;
	}	

%>
<html><head>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<title></title>

<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="dept/peixun3/ycsf_css.css">
<script language="JavaScript" src="script/list.js"></script>
<script language="JavaScript" type="text/JavaScript">

</script>

<script type="text/javascript" language="JavaScript1.2" src="dept/peixun3/images/stm31.js"></script><style>
.st_tbcss,.st_tdcss,.st_divcss,.st_ftcss{border:none;padding:0px;margin:0px;}
.STYLE1 {
	color: #FF0000;
	font-weight: bold;
}
.STYLE2 {color: #FFFFFF}
.STYLE3 {color: #FFFFFF; font-weight: bold; }
</style></head><body bgcolor="#ffffff" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">


<table width="100%" background="dept/peixun3/images/main_01.gif" border="0" cellspacing="0" cellpadding="0">
	<tbody><tr>
		<td align="center">
<table width="990" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
        <td background="dept/peixun3/images/main_02.gif" width="255" height="84"></td>
        </tr>
    </tbody></table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tbody><tr>
		<td background="dept/peixun3/images/main_0.gif" width="25"></td>
		<td background="dept/peixun3/images/main_0.gif" width="84" align="center"><a href="" target="_self"><font color="#ffffff"><strong>培训部首页</strong></font></a></td>
		<td background="dept/peixun3/images/main_1.gif" width="7"></td>
		<td background="dept/peixun3/images/main_0.gif" width="86" align="center"><strong><a href="" target="_self"><font color="#ffffff">培训部风采</font></a></strong></td>
		<td background="dept/peixun3/images/main_1.gif" width="10" align="center">&nbsp;</td>
		<td background="dept/peixun3/images/main_0.gif" width="77" align="center"><a href="" target="_self"><font color="#ffffff"><strong>公文通知</strong></font></a></td>
		<td background="dept/peixun3/images/main_1.gif" width="9"></td>
		<td background="dept/peixun3/images/main_0.gif" width="82" align="center"><a href="" target="_self"><strong><font color="#ffffff">年度重点项目</font></strong></a></td>
		<td background="dept/peixun3/images/main_1.gif" width="1"></td>
		<td background="dept/peixun3/images/main_1.gif" width="10" align="center">&nbsp;</td>
		<td background="dept/peixun3/images/main_0.gif" width="86" align="center"><a href="" target="_self"><strong><font color="#ffffff">会议文件</font></strong></a></td>
		<td background="dept/peixun3/images/main_1.gif" width="8"></td>
		<td background="dept/peixun3/images/main_0.gif" width="90" align="center"><a href="" target="_self"><strong><font color="#ffffff">产品资料</font></strong></a></td>
		<td background="dept/peixun3/images/main_1.gif" width="6"></td>
		<td background="dept/peixun3/images/main_0.gif" width="90" align="center"><a href="" target="_self"><strong><font color="#ffffff">讲师园地</font></strong></a></td>
		<td background="dept/peixun3/images/main_1.gif" width="5"></td>
		<td background="dept/peixun3/images/main_0.gif" width="99" align="center"><a href="" target="_self"><font color="#ffffff"><strong>数据报表</strong></font></a><a href="http://www.qzxxpx.com/Soft_Index.asp" target="_blank"></a></td>
		<td background="dept/peixun3/images/main_0.gif" width="150" align="right"><script language="JavaScript" type="text/JavaScript">
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
		document.write("<font color=#ffffff>"+year+"年"+mymonth+"月"+myday+"日 "+weekday+"</font>");
		</script></td>
		<td>        </td><td>
      </td></tr>
    </tbody></table></td>
  </tr>
  <tr>
    <td background="dept/peixun3/images/main_15.gif" width="990" height="132"></td>
  </tr>
  <tr>
    <td width="100%">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody><tr>
				<td width="3%" align="right"><img src="dept/peixun3/images/arrow3.gif"></td>
				<td width="67%">&nbsp;您现在的位置：&nbsp;<a href="http://www.qzxxpx.com/">合众人寿培训部</a>&nbsp;&gt;&gt;&nbsp;产品资料</td>
				<td width="30%">
				<table width="100%" height="15" border="0" align="center" cellpadding="0" cellspacing="0">
				  <tbody><tr> 
					
							<td width="100%" align="right">
								<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tbody><tr> 
										<td width="100%" valign="middle" align="right">
											<table border="0" cellpadding="0" cellspacing="0"><form method="Get" name="SearchForm" action="http://www.qzxxpx.com/Article_Search.asp"></form><tbody><tr><td align="center" valign="middle"></td></tr></tbody></table>
										</td>
									</tr>
								</tbody></table>
							</td>
					
				  </tr>
				</tbody></table>
				</td>
			</tr>
		</tbody></table>
	</td><td>
  </td></tr>
</tbody></table>
<table width="990" border="0" cellspacing="0" cellpadding="0">
	<tbody><tr>
		<td width="240" valign="top" background="dept/peixun3/images/Article_class_18_1.gif">
		<!----------正文左栏---------------->
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tbody><tr>
					<td background="dept/peixun3/images/Article_class_16.gif" width="240" height="35">
					</td>
				</tr>
				<tr>
					<td background="dept/peixun3/images/Article_class_18.gif" width="240" valign="top" align="center">
					
					<ulweb:column beanName="sl" deptId="peixun3" enName="<%=enName %>" columnId="<%=columnId %>" withSub="1" />
					<div class="men"><strong id="g"><bean:write name="sl" property="columnName" /></strong></div>		
					<ul class="menli">
					<logic:iterate id="element" name="sl" property="subColumns">
					<li id="g">·<a href="list.jsp?id=<bean:write name="element" property="columnId" />"><bean:write name="element" property="columnName" /></a>
					</li>
					</logic:iterate>
					</ul>
				</td></tr>
				<tr>
					<td background="dept/peixun3/images/Article_class_18.gif" width="240" height="25">
					</td>
				</tr>
				<tr>
					<td  width="240" height="34">
						<table width="100%"><tbody><tr><td width="50"></td><td></td></tr></tbody></table>
					</td>
				</tr>
				<tr>
					<td background="dept/peixun3/images/Article_class_24.gif" width="240" height="275">
					</td>
				</tr>
			</tbody></table>
		</td>
		<td width="750" valign="top">
		<!----------正文右栏---------------->
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tbody><tr>
					<td width="750">
					
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody><tr>
								<td background="dept/peixun3/images/Article_class_20.gif" width="750" height="32">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tbody><tr>
											<td width="180" align="center"><font color="#ffffff"><strong><ulweb:navbar beanName="nb"  deptId="peixun3" enName="<%=enName%>" columnId="<%=columnId %>" /></strong></font></td>
											<td></td>
										</tr>
									</tbody></table>
								</td>
							</tr>
							<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tbody><tr>
										<td background="dept/peixun3/images/Article_class_22_10.gif" width="750" align="left" valign="top">
											<table width="98%" border="0" cellspacing="0" cellpadding="0">
												<tbody><tr>
													<td width="6"></td>
													<td>
													<div class="newlist">


<DIV class="con">
<ul>


<ulweb:content beanName="cl" deptId="peixun3"
												enName="<%=enName%>"
												columnId="<%=columnId %>"
												keyWord="<%=keyWord %>"
												conditions="isDelete=0:i;isProcessing=0:i;"
												pageNum="<%=pageNum %>" />

		<logic:iterate id="element" name="cl" property="objectList">
			<li><span class="fri">[<bean:write name="element" property="uploadTime" format="yyyy-MM-dd" />]</span>
			·<bean:write name="element" property="contentNameLink" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="new" filter="false" />&nbsp;&nbsp;
			<bean:write name="element" property="attachmentLink" filter="false" /></li>
		</logic:iterate>
<bean:define id="cid" name="element" property="columnId" />

<% if (enName == null && columnId == 0) { %>
<ulweb:column beanName="cc" deptId="0000" columnId="<%=Integer.parseInt(cid.toString()) %>" />
[&nbsp;<bean:write name="cc" property="columnName" />&nbsp;]	
<% } %>

</ul>

<!--next-->
<DIV class="next"><bean:write name="cl" property="pageTag" filter="false" />	</DIV>
<!--next-->

</DIV>


</div>
													</td>
												</tr>
											</tbody></table>
										</td>
									</tr>
									<tr><td background="dept/peixun3/images/Article_class_22_11.gif" width="750" height="14"></td></tr>
								</tbody></table>
							</td>
							</tr>
						</tbody></table>
					
					</td>
				</tr>
			</tbody></table>


		</td>
	</tr>
</tbody></table>

 
  <table width="990" border="0" cellspacing="0" cellpadding="0" align="center">
	  <tbody><tr>
		<td background="dept/peixun3/images/main_41.gif" width="990" height="39" align="center">&nbsp;</td>
	  </tr>
  </tbody></table>


</td></tr></tbody></table></body></html>