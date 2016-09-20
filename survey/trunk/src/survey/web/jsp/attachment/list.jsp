<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp" %>

<link href="css/css.css" rel="stylesheet" type="text/css">  
  
  
<logic:notEmpty name="attachmentList">
<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr bgcolor="#cccccc">
  <td width="75" height="27" align="center">序号</td>
    <td align="center">名称</td>
    <td width="95" align="center"><br></td>
  </tr>



<%int index=0; %>
<logic:iterate id="e" name="attachmentList">

    <tr onMouseOver="this.bgColor='#F8F1C5'" onMouseOut="this.bgColor='ffffff'">
  <td nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all" align="center"><%=++index %></td>
    <td height="25" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all"><a href="attachment.do?method=getAttachment&id=<bean:write name="e" property="id" />" target="_blank"><bean:write name="e" property="fileName" /></a></td>
    <td align="center" nowrap style="overflow: hidden; text-overflow:ellipsis;word-break:keep-all">
    <logic:equal value="1" name="edit">
    <input type="button" value="删除" onclick="doDelAtt(<bean:write name="e" property="id" />)" />
    </logic:equal>
    <logic:equal value="0" name="edit">
    &nbsp;
    </logic:equal>
    
    </td>
    </tr>

</logic:iterate>


</table>
</logic:notEmpty>

