<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>问卷得分</title>




<script>


</script>




</head>

<body>
 <table>
  <tr> 
    <td height="" length="100"></td>
    <td colspan="5" valign="top"><img src="../survey/images/logos.jpg"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr></table>
<form name="f1" method="post" action="">


			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" background="">
				<tr>
					<td class="bigtitlebg">
                       <strong> 您此次问卷的总分：<bean:write name="totalScore" />分</strong>
					</td>
				
				</tr>
				<tr><td class="bigtitlebg">
                       <strong> 谢谢您对于我们工作的支持，欢迎您再次使用！再见！</strong>
				</td></tr>
			</table>

</form>

</body>
</html>

