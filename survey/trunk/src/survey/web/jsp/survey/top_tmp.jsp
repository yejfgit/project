<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main_Top</title>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
 function SelectTab(n,s,p){
    var e = null;
	
    for(var i=1;i<=n; i++){
      //e = eval("Tab" + i);
      e = document.getElementById("Tab" + i);
     if (e == n){
         
		 e.className=s;
		
      }else{
        e.className  = 'menu-color';
		
      } 
    }

    e = event.srcElement;
    while (e.tagName != "TD")
    {
      e = e.parentElement;
    }
    e.className = s;
	top.mainFrame.location.href= p;
  }

</script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" background="images/top_bg1.gif">
  <tr>
    <td width="1%"><img src="images/top_01.gif" width="398" height="56"></td>
    <td width="98%"><table width="100%" height="56"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="right"><img src="images/icon_04.gif" width="14" height="14" align="absmiddle"><a href="um_logout" class="link2" target="_parent">退出</a></td>
      </tr>
      <tr>
        <td><img src="images/icon_01.gif" width="19" height="21" align="absbottom"><strong>&nbsp;欢迎!&nbsp; <span class="font-yellow">
        <logic:notEmpty name="userName"><bean:write name="userName" /></logic:notEmpty>
        <logic:notEmpty name="branchName"><bean:write name="branchName" /></logic:notEmpty>
        </span></strong></td>
      </tr>
    </table></td>
    <td width="1%" align="right"><img src="images/top_02.gif" width="131" height="56"></td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" background="images/top_bg2.gif">
  <tr>
    <td width="1%"><img src="images/top_03.gif" width="81" height="38"></td>
    <td width="98%" valign="top"><table height="32" border="0" cellpadding="0" cellspacing="0">
      <tr>
                 <td width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle" style=""></td>        
        <td width="100" valign="top" nowrap class="menu-color" id="Tab1" onClick="SelectTab(6,'menu-04hover','desktop.do?method=index')">我的首页</td>
                <td width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle" style=""></td>        
        <td width="100" valign="top" nowrap class="menu-color" id="Tab2" onClick="SelectTab(6,'menu-04hover','search.do?method=index')">档案查询</td>
                <td width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle" style=""></td>        

        <td<logic:notEqual value="1" name="transfer"> style="display:none"</logic:notEqual> width="100" valign="top" nowrap class="menu-color" id="Tab4" onClick="SelectTab(6,'menu-04hover','transfer.do?method=index')">文件移交</td>

                <td<logic:notEqual value="1" name="transfer"> style="display:none"</logic:notEqual> width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle" style=""></td>        
        <td<logic:notEqual value="1" name="arrange"> style="display:none"</logic:notEqual> width="100" valign="top" nowrap class="menu-color" id="Tab5" onClick="SelectTab(6,'menu-04hover','arrange.do?method=index')">整理归档</td>
                <td<logic:notEqual value="1" name="arrange"> style="display:none"</logic:notEqual> width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle" style=""></td>        

        <td width="100" valign="top" nowrap class="menu-color" id="Tab3" onClick="SelectTab(6,'menu-04hover','task.do?method=index')">任务处理</td>
                <td width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle" style=""></td>  

        <td<logic:notEqual value="1" name="admin"> style="display:none"</logic:notEqual> width="100" valign="top" nowrap class="menu-color" id="Tab6" onClick="SelectTab(6,'menu-04hover','admin.do?method=index')">系统管理</td>
                <td<logic:notEqual value="1" name="admin"> style="display:none"</logic:notEqual> width="2"><img src="images/top_05.gif" width="2" height="32" align="absmiddle"></td>
      </tr>
    </table></td>
    <td width="1%" align="right"><img src="images/top_04.gif" width="131" height="38"></td>
  </tr>
</table>
</body>
</html>
