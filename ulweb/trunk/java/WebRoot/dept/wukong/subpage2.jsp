
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%><%

	UlColumn c = (UlColumn)request.getAttribute("column");
	DisplayOnPage d = new DisplayOnPage();
	d.setRequest(request);


%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物控部主页</title>
<link rel="stylesheet" href="style/ul.css" type="text/css" /> 
<link rel="stylesheet" href="wukong.css" type="text/css" />
<link rel="stylesheet" href="dept/wukong/wukong.css" type="text/css" />
<script type="text/javascript" src="dept/wukong/wukong.js"></script>
</head>

<body onresize="resizeNav();">
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="191" height="122"><a href="wukong.do?method=index"><img src="images/wukong/logo.jpg" width="191" height="122" border="0" /></a></td>
        <td><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/wukong/top.jpg" name="u" width="609" height="94" id="u" style="FILTER: alpha(opacity=0)" />
                    <script language="JavaScript" type="text/javascript">
var d=0
function JM_fade(ob){
if (d==0) {ob.filters.alpha.opacity+=1} else {ob.filters.alpha.opacity-=1}
if (ob.filters.alpha.opacity==100){d=1;} else if (ob.filters.alpha.opacity==0){d=0}
}
setInterval("JM_fade(u)",10)
              </script></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="28"><div id="navbox" style="position:fixed; left:;"><div id="nav" style="left: 417px; top: 95px; width: 610px; height:30px;">
              <ul>
                <li class="menu2" onmouseover="this.className='menu1'" onmouseout="this.className='menu2'">
				 <a href="show.do?c=19312" style="width:90px;" target="_blank">部门介绍 </a>                </li>
                <li class="menu2" onmouseover="this.className='menu1'" onmouseout="this.className='menu2'">管理政策
				    <div class="list"> 
						<a href="wukong.do?method=subPage2&columnId=1157">采购政策 </a><br /><br />
                        <a href="wukong.do?method=subPage2&columnId=1158">职场政策 </a>
                    </font> </div>
                </li>
                <li class="menu2" onmouseover="this.className='menu1'" onmouseout="this.className='menu2'">公告文件 
                    <div class="list"> 
						<a href="wukong.do?method=subPage2&columnId=1159">公告 </a><br /><br />
                        <a href="wukong.do?method=subPage2&columnId=1160">采购类文件 </a><br /><br />
						<a href="wukong.do?method=subPage2&columnId=1161">职场类文件 </a><br />
					</div>
                </li>
                <li class="menu2" onmouseover="this.className='menu1'" onmouseout="this.className='menu2'"> <font size="2">产品信息 </font>
                    <div class="list"> <a href="wukong.do?method=subPage2&columnId=1162"><font size="2">IT类产品</font></a><font size="2"><br /><br />
                          <a href="wukong.do?method=subPage2&columnId=1163">综合类产品</a><br />
                    </font> </div>
                </li>
                <li class="menu2" onmouseover="this.className='menu1'" onmouseout="this.className='menu2'">
				 <a href="show.do?c=31667" style="width:90px;" target="_blank"><font size="2">供应商通讯录 </font></a>                </li>
				 
				<li class="menu2" onmouseover="this.className='menu1'" onmouseout="this.className='menu2'"> <font size="2">下载专区 </font>
                    <div class="list"> 
						  <a href="wukong.do?method=subPage2&columnId=1164">采购类表格</a><br /><br />
                          <a href="wukong.do?method=subPage2&columnId=1165">职场类表格</a><br /><br />
						  <a href="wukong.do?method=subPage2&columnId=1267">共享资料</a><br />
                    </div>
                </li>
              </ul>
            </div><script type="text/javascript">
			function resizeNav() {
				document.getElementById("nav").style.left = document.body.clientWidth / 2 - 211 + 'px';
			}
			resizeNav();
			//document.getElementById("nav").style.left = document.getElementById("navbox").style.left + 'px';
			
			
			</script></div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="217" height="580" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="579" valign="top" background="images/wukong/leftnavsub.jpg">
				<div class="list" style="padding:50px 0px 0px 40px; height:20px;"><a href="wukong.do?method=index" class="list"><strong>返回首页&lt;&lt;&lt;</strong></a></div>
				<div class="listTitle" style="padding:25px 0px 0px 10px; height:20px; text-align:center;"><%=c.getParentName() == null ? "物控部" : c.getParentName()%></div>
				<div class="listContent" style="padding:5px 0px 0px 40px; height:45px;"><%=d.divColumn("columnList", "wukong.do?method=subPage2&", 0)%></div>
				</td>
          </tr>

        </table></td>
        <td valign="top"><table width="100%" height="579" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="424" valign="top" background="images/wukong/centerbgsub.jpg">
				<div><form method="post" action="wukong.do?method=check">
					<div style="padding:30px 0px 135px 376px; height:14px;">
					<input type="text" name="tName" value="" style="width:130px; height:12px;" />
					<input type="submit" value="查找" style="width:40px; height:20px;" /></div></form>
					<div class="listTitle" style="padding:10px 0px 2px 37px; height:20px;"><%=c.getColumnName()%></div>
					<div class="listContent" style="padding:5px 0px 13px 35px; height:270px;text-align:left;">
					
					<%=d.divContent("contentList",3)%>
					
					</div>
					<div class="listContent" style="padding: 10px 0px 0px 20px; height:30px;"><%=d.toPage(2)%></div>
					</div>			</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="45" background="images/wukong/bottombg.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="1" cellpadding="0">
          <tr>
            <td width="227" rowspan="2" bgcolor="#222942"><div class="copyright" style="padding:10px 0px 10px 20px;">合众人寿物控部 版权所有 2009</div></td>
            <td height="23" bgcolor="#98C00B"><div class="bottomnav" style="padding:10px 0px 10px 150px;"><a href="index.do" target="_blank" class="bottomnav">首页</a> | 关于合众 | 问题上报 | <a href="admin/index.jsp" target="_blank" class="bottomnav">系统管理</a></div></td>
          </tr>
          <tr>
            <td height="14" bgcolor="#FBBF01"></td>
          </tr>
          <tr>
            <td height="11" colspan="2" bgcolor="#326495"></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>
