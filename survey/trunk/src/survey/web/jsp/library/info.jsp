<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<%@ taglib uri="struts-logic.tld" prefix="logic" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script type="text/javascript">
parent.document.getElementById("loading").style.display = 'none';
parent.document.getElementById("tips").style.display = 'none';
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #0D2A4C;
	margin: 0px;
	background-color:#f8f8f0;
}
</style>
</head>

<body>
<table>
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr><td width="35%"></td>
  <td>
			<table width="100%" height="60" border="0" cellpadding="0"
				cellspacing="0" background="">
				<tr valign="middle">
					<td class="bigtitlebg" valign="bottom">
                       <Strong><bean:write name="info" /></Strong>
					</td>
				</tr>
			</table>
	</td></tr>
</table>
</body>
</html>

