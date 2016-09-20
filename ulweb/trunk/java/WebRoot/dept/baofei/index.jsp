<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>

<%
		DisplayOnPage d = new DisplayOnPage();
		d.setRequest(request);
		List<UlContentWithAtt> paihang = (List<UlContentWithAtt>)request.getAttribute("paihang");
		List<UlContentWithAtt> hello = (List<UlContentWithAtt>)request.getAttribute("hello");
		List<UlContentWithAtt> zhanshi = (List<UlContentWithAtt>)request.getAttribute("zhanshi");
		List<UlColumn> jigou = (List<UlColumn>)request.getAttribute("jigou");
		
		List<UlContent> intro = (List<UlContent>)request.getAttribute("intro");
		List<UlContent> address = (List<UlContent>)request.getAttribute("address");

		
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="style/ul.css" type="text/css"> 
<link rel="stylesheet" href="dept/baofei/baofei.css" type="text/css">
<link rel="stylesheet" href="baofei.css" type="text/css">
<title>保费部</title>

</head>

<body bgcolor="#EDEDED">

<center>

<div style="width:1000px; margin:0px;">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr height="200">
      <td><%@include file="subhead.jsp"%>
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
	  <script type="text/javascript">
	  intro.href = "<%=intropath%>";
	  address.href = "<%=addresspath%>";
	  
	  </script>
	  </td>
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
              <td width="500" height="310"><div style=" width:500px; height:310px;">
                <div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">文件通知</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
                  <div class="col_content col_content_text"><%=d.divColumn("wenjian", "baofei.do?method=subPage1&", 0)%></div>
                </div>
                <div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">续期业绩速报</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
				  <div class="col_content col_content_text"><%=d.divColumn("xuqi", "baofei.do?method=subPage1&", 0)%></div>
				  </div>
				<div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">经营管理</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
				  <div class="col_content col_content_text"><%=d.divColumn("jingying", "baofei.do?method=subPage1&", 0)%></div>
				  </div>
				<div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">竞赛激励</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
				  <div class="col_content col_content_text"><%=d.divColumn("jingsai", "baofei.do?method=subPage1&", 0)%></div>
				  </div>
              </div></td>
              <td>
			  <%
			  String hellopath = "images/baofei/welcome.jpg"; 
			  for(int i = 0; i < hello.size(); i++){
			  	if(hello.get(0).getAttachmentSum() <= 0) break;
			  	hellopath = hello.get(0).getAtt(1).getAttachmentPath();
			  } %>
			  <img src="<%=hellopath%>" width="500" height="310" border="0">
			  </td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="500" height="310"><div style=" width:500px; height:310px;">
                <div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">教育训练</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
                  <div class="col_content col_content_text"><%=d.divColumn("jiaoyu", "baofei.do?method=subPage1&", 0)%></div>
                </div>
                <div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">督导园地</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
                  <div class="col_content col_content_text"><%=d.divColumn("dudao", "baofei.do?method=subPage1&", 0)%></div>
                </div>
                <div class="col">
                  <div class="col_title">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                        <td width="130" bgcolor="#00A208" class="col_title">人员管理</td>
                        <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                        <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                      </tr>
                    </table>
                  </div>
                  <div class="col_content col_content_text"><%=d.divColumn("renyuan", "baofei.do?method=subPage1&", 0)%></div>
                </div>
                <div class="col">
                    <div class="col_title">
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                          <td width="130" bgcolor="#00A208" class="col_title">业管信息</td>
                          <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                          <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                        </tr>
                      </table>
                    </div>
                    <div class="col_content col_content_text"><%=d.divColumn("yeguan", "baofei.do?method=subPage1&", 0)%></div>
                  </div>
              </div></td>
              <td valign="top"><div class="col2">
                <div>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                      <td width="380" bgcolor="#00A208" class="col_title">部门快讯</td>
                      <td bgcolor="#00A208" class="col_title">&nbsp;</td>
                      <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                    </tr>
                  </table>
                </div>
                <div class="col_content2"><marquee behavior="scroll" direction="up" scrollamount="2" scrolldelay="100" width="475" height="60" onMouseOver="this.stop();" onMouseOut="this.start();"><%=d.divContent("bumen", 0)%></marquee></div>
								
		   <%
			  String zhanshipath = "images/baofei/photo.jpg"; 
			  if(zhanshi.size() > 0){
					if(zhanshi.get(0).getAttachmentSum() > 0){
			  			zhanshipath = zhanshi.get(0).getAtt(1).getAttachmentPath();
			   			%><a href="<%=zhanshipath%>" target="_blank"><img src="<%=zhanshipath%>" width="495" height="203" border="0"></a>
			   		<%  
			   		}
			   }else{    %>
			   <img src="<%=zhanshipath%>" width="495" height="203" border="0">
			   <% }
		   %>
				
              </div></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="245" height="221" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td><div class="col">
                <div class="col_title">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="26" height="32"><img src="images/baofei/tl.jpg" width="26" height="32"></td>
                      <td width="130" bgcolor="#00A208" class="col_title">行业信息</td>
                      <td bgcolor="#00A208" class="col_title"><%
					  		if(request.getAttribute("hangyeId") != null){
					  %><a href="<%="baofei.do?method=subPage1&columnId=" + request.getAttribute("hangyeId").toString()%>">more&gt;&gt;</a><% } %>&nbsp;</td>
                      <td width="26" height="32"><img src="images/baofei/tr.jpg" width="26" height="32"></td>
                    </tr>
                  </table>
                </div>
                <div class="col_content col_content_text"><%=d.divContent("hangye", 0)%></div>
              </div></td>
                </tr>
                <tr>
                  <td><div style="float:left; width:245px; height:70px"><img src="images/baofei/rank.jpg" width="254" height="47"></div></td>
                </tr>
              </table>
			  
			  
			  	</td>
              <td><div><% 
			    String paihangpath1 = "images/baofei/pic.jpg";  
			  	if(paihang.size() > 0){
					if(paihang.get(0).getAttachmentSum() > 0){
						paihangpath1 = paihang.get(0).getAtt(1).getAttachmentPath();
						
						%><a href="<%=paihangpath1%>" target="_blank"><img src="<%=paihangpath1%>" width="370" height="221" border="0"></a><%
					}
				}else{ %><img src="<%=paihangpath1%>" width="370" height="221" border="0"><% } 
			%><% 
			    String paihangpath2 = "images/baofei/pic.jpg";  
			  	if(paihang.size() > 1){
					if(paihang.get(1).getAttachmentSum() > 0){
						paihangpath2 = paihang.get(1).getAtt(1).getAttachmentPath();
						
						%><a href="<%=paihangpath2%>" target="_blank"><img src="<%=paihangpath2%>" width="370" height="221" border="0"></a><%
					}
				}else{ %><img src="<%=paihangpath2%>" width="370" height="221" border="0"><% } 
			%></div></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
	<tr><td align="center"><table width="1000" height="240" border="0" cellpadding="0" cellspacing="0" background="images/baofei/foot.jpg">
      <tr>
        <td>
		<div class="jigou" style=" height:40px;padding:10px 0px 10px 30px;">机构之声</div>
		
		<div style=" height:200px;padding:20px 0px 50px 50px;" class="col_content_text">
		<%
		
		//机构之声的代码
		for(int i = 0; i < jigou.size(); i++){

		%>
		[<a href="baofei.do?method=subPage1&columnId=<%=jigou.get(i).getColumnId()%>"><%=jigou.get(i).getColumnName()%></a>]&nbsp;&nbsp;
		
		<%	}  %>
		</div></td>
      </tr>
    </table></td>
	</tr>
	
  </table>
</div>
</center>
</body>
</html>