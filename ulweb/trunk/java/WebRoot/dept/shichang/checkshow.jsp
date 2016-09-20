<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<HTML>

<HEAD>
<TITLE>市场部</TITLE>
<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="dept/shichang/shichang.css" type="text/css" />
<script type="text/javascript" src="script/shichang.js"></script>
<%
		UlColumn c = (UlColumn)request.getAttribute("column");
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		
		List<UlContent> intro = (List<UlContent>)request.getAttribute("intro");
		List<UlContent> address = (List<UlContent>)request.getAttribute("address");		

%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<style>
.withyou {
	font-family: "华文行楷";
	font-size: 24px;
	color: #1661F6;
}
</style>
<script type="text/javascript">

if(<%=request.getParameter("columnId")%> == 509) {
	document.location.href='shichang.do?method=subPage2&columnId=509';
}

</script>
</HEAD>


<body>
<center>
<div style=" width:800;border-width:1px; border-color:#0066FF; border-style:solid; margin:10px 10px 10px 10px">
<table width="800" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><div><img src="images/shichang/head_sc.jpg" alt="" width="800" height="100"></div></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="5%" height="20" class="navtop_text">				</td>
            <td width="35%" class="navtop_text">&nbsp;<script language="JavaScript">
					<!--
					todayDate = new Date();
					date = todayDate.getDate();
					month= todayDate.getMonth()+1;
					year= todayDate.getYear();
					document.write("")
					document.write(" ")
					document.write(year);
					document.write("年");
					document.write(month);
					document.write("月");
					document.write(date);
					document.write("日");
					document.write(" ")
					if (todayDate.getDay() == 5) document.write("星期五")
					if (todayDate.getDay() == 6) document.write("星期六")
					if (todayDate.getDay() == 0) document.write("星期日")
					if (todayDate.getDay() == 1) document.write("星期一")
					if (todayDate.getDay() == 2) document.write("星期二")
					if (todayDate.getDay() == 3) document.write("星期三")
					if (todayDate.getDay() == 4) document.write("星期四")
					//--> 
				</script></td>
				
									  <%
	  String intropath = "#";
	  String addresspath = "#";
	  for(int i = 0; i < intro.size(); i++){
	  	intropath = "show.do?c=" + intro.get(0).getContentId();
	  }
	  for(int i = 0; i < address.size(); i++){
	  	addresspath = "show.do?c=" + address.get(0).getContentId();
	  }
	  
	  %>
            <td class="navtop_text">&nbsp;&nbsp;<a href="<%=intropath%>" target="_blank" class="navtop_text">部门介绍</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=addresspath%>" target="_blank" class="navtop_text">市场部通讯录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="admin/index.jsp" target="_blank" class="navtop_text">系统管理</a>&nbsp;&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="100%" height="25" valign="middle"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="images/shichang/head_bg2.jpg">
          <tr>
            <td width="20%">&nbsp;</td>
            <td width="30%"><div class="navtop_text2">创新 进取 效率 协作</div></td>
            <td width="30%"><div class="navtop_text2">更好的产品     更好的服务</div></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table>	</td>
  </tr>
  <tr>
  	<td height="10">&nbsp;</td>
  </tr>
  
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="20%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="200" align="center" valign="top">
			<div style="width:100%; text-align:center">
			<div style=" width:70%; border-style:solid; border-width:1px; border-color:#6699FF"><table width="100%" border="0" cellpadding="0" cellspacing="3">
              <tr>
                <td height="15" align="center"></td>
              </tr>
			  <tr>
                <td height="25" align="center" bgcolor="#6699FF"><span class="navleft_text"><a href="shichang.do?method=index" class="navleft_text">首&nbsp;&nbsp;页</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#1661F6"><span class="navleft_text"><a href="shichang.do?method=index&colName=gxcp" class="navleft_text">个险产品</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#6699FF"><span class="navleft_text"><a href="shichang.do?method=subPage1&columnId=410" class="navleft_text">银代产品</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#1661F6"><span class="navleft_text"><a href="shichang.do?method=index&colName=schd" class="navleft_text">市场活动</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#6699FF"><span class="navleft_text"><a href="shichang.do?method=subPage1&columnId=412" class="navleft_text">机构分享</a></span></td>
              </tr>
              <tr>
                <td height="25" align="center" bgcolor="#1661F6"><span class="navleft_text"><a href="shichang.do?method=index&colName=tydt" class="navleft_text">同业动态</a></span></td>
              </tr>
              <tr>
                <td height="15" align="center"></td>
              </tr>
            </table></div></div>
			
			
			</td>
          </tr>
          <tr>
            <td height="100" align="center" valign="middle"><form method="post" action="shichang.do?method=check" name="form1" id="form1"><table width="80%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="25"><span class="navleft_find">查找
                    <label>
                    <input name="tName" type="text" id="keyword" size="10">
                    </label>
                </span></td>
              </tr>
              <tr>
                <td height="25"><span class="navleft_find">范围                  
                    <label>
                    <select name="type"><!-- 不限\个险产品\市场活动\机构分享\同业动态 -->
						<option value="0" selected >不限</option>
						<option value="409">个险产品</option>
						<option value="411">市场活动</option>
						<option value="412">机构分享</option>
						<option value="413">同业动态</option>
                      </select>
                    </label>
                </span></td>
              </tr>
              <tr>
                <td height="25" align="center"><input type="submit" name="s1" value="查找"></td>
              </tr> 
            </table>
            </form></td>
          </tr>
          <tr>
            <td height="50" align="center" valign="middle"><div class="withyou">和你在一起</div></td>
          </tr>
        </table></td>
        <td width="60%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td valign="top">
			<!-- body center div -->
				<div class="body_nav">
					<div class="body_nav_text">首页&nbsp;&gt;&gt;&nbsp;搜索结果&nbsp;&gt;&gt;&nbsp;<%=request.getParameter("keyWord")==null?"":"&gt;&gt;" + request.getParameter("keyWord")%></div>
				</div>
				
				<div class="bodycontent_list">
					<%=d.divContent("contentList",3)%>
				</div>
				
				<div class="bodycontent_page">
					<%=d.toCheckPage()%>
				</div>
				
				
				</td>
          </tr>
        </table></td>
        <td width="20%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><div></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="60"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="images/shichang/foot_sc.jpg">
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</div>

</center>

</body>
</HTML>
