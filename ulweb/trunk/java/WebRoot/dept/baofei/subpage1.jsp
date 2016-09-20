<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		UlColumn c = (UlColumn)request.getAttribute("column");
		
		List<UlContent> intro = (List<UlContent>)request.getAttribute("intro");
		List<UlContent> address = (List<UlContent>)request.getAttribute("address");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="style/ul.css" type="text/css"> 
<link rel="stylesheet" href="dept/baofei/baofei.css" type="text/css">
<script type="text/javascript" src="script/baofei.js"></script>
<link rel="stylesheet" href="baofei.css" type="text/css">


<title>保费部</title></head>

<body>

<center>

<div style="width:1000px; margin:0px;">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><%@include file="subhead.jsp"%><%
	  String intropath = "#";
	  String addresspath = "#";
	  for(int i = 0; i < intro.size(); i++){
	  	intropath = "show.do?c=" + intro.get(0).getContentId();
	  }
	  for(int i = 0; i < address.size(); i++){
	  	addresspath = "show.do?c=" + address.get(0).getContentId();
	  }
	  
	  %>
	  <script type="text/javascript">
	  intro.href = "<%=intropath%>";
	  address.href = "<%=addresspath%>";
	  
	  </script></td>
    </tr>
    <tr>
      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>

		  </td>
        </tr>
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="290" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <!--DWLayoutTable-->
                <tr>
                  <td width="290" valign="top"><div class="leftnav_box">
                    <%
					if(c.getParentName() != null){
					%>
					<div class="col">
                      <div class="col_title">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                            <td width="130" bgcolor="#00A208" class="col_title"><%=c.getParentName()%></td>
                            <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                            <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                          </tr>
                        </table>
                      </div>
                      <div class="leftnav_list">
					  <%=d.divColumn("columnList", "baofei.do?method=subPage1&", 0)%>
					  </div>
                    </div>
					
					<%
					}
					%>
					
                  </div></td>
                </tr>
				<tr>
					<td align="center" class="btn_backtoindex">&lt;<a href="baofei.do?method=index" class="btn_backtoindex">返回首页</a>&gt;</td>
				</tr>
              </table></td>
              <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td><div class="listbox">
                    <div class="listtitle"><%=c.getColumnName()%></div>
					<div class="listcontent list_content_text">
					<%=d.divContent("contentList",3)%>
					
					</div>
					<div class="listcontent list_content_text">
					<%=d.toPage(1)%>
					
					</div>
                  </div></td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>

      </table></td>
    </tr>
	<tr><td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="49" bgcolor="#01A10B">&nbsp;</td>
      </tr>
    </table></td>
	</tr>
	
  </table>
</div>
</center>
</body>
</html>