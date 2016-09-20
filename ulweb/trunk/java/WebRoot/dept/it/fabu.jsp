
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//if(request.getAttribute("from") == null) response.sendRedirect(basePath + "index.do");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>IT发布</title>
    <script type="text/javascript" src="js/top.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<link href="css/main1zhn.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="script/list.js"></script>

	<script>
	
	</script>

  </head>
  
  <body>
  </br>
  </br>
<table cellpadding="0" cellspacing="0" border="0">
<tr>
	<td><img id="tag_mgzz1" src="images/bobao.jpg" class="tagSel" onmouseover="tagSelect('mgzz', 1, 2)" /></td>
	<td>&nbsp;&nbsp;</td>
	<td><img id="tag_mgzz2" src="images/meiti.jpg" class="tag" onmouseover="tagSelect('mgzz', 2, 2)" /></td>
</tr>
</table>
</p>
</div>
<div class="za" style="height: 260px">
<div id="mgzz1" style="display: block">
<ul>
<iframe style="height:500px;width:1200px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" 
allowtransparency="yes" src="dept/it/itZhiDulist.jsp"></iframe>

</ul>
</div>

<div id="mgzz2" style="display: none">
<ul>
<iframe style="height:500px;width:1200px;" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" 
allowtransparency="yes" src="dept/it/itBoBaolist.jsp"></iframe>
</ul>
</div>
</div>
  </body>
</html>
