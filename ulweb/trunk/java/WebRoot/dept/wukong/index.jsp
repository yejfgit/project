
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%><%

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
<style type="text/css">
<!--


-->
</style></head>

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
                
                <td><img src="images/wukong/top.jpg" width="609" height="94" name="u" style="FILTER: alpha(opacity=0)" /><SCRIPT language=JavaScript>
var d=0
function JM_fade(ob){
if (d==0) {ob.filters.alpha.opacity+=1} else {ob.filters.alpha.opacity-=1}
if (ob.filters.alpha.opacity==100){d=1;} else if (ob.filters.alpha.opacity==0){d=0}
}
setInterval("JM_fade(u)",10)
</SCRIPT></td>
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
            <td height="579" valign="top" background="images/wukong/leftnav.jpg">
			
				<div class="listTitle" style="padding:95px 0px 0px 70px; height:20px;">采购园地</div>
				<div class="listContent" style="padding:5px 0px 0px 40px; height:45px;"><a href="wukong.do?method=subPage2&amp;columnId=1168">培训资料</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="wukong.do?method=subPage2&amp;columnId=1169">视频下载</a><br />
				  <a href="wukong.do?method=subPage2&amp;columnId=1170">文档资料</a></div>
				<div class="readmore" style="padding:11px 0px 8px 40px; height:16px;"><a href="wukong.do?method=subPage2&amp;columnId=1168" class="readmore">更多...</a></div>
				
				<div class="listTitle" style="padding:15px 0px 0px 70px; height:20px;">职场园地</div>
				<div class="listContent" style="padding:5px 0px 0px 40px; height:51px;"><a href="wukong.do?method=subPage2&amp;columnId=1171">培训资料</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="wukong.do?method=subPage2&amp;columnId=1172">职场租赁流程</a><br />
                  <a href="wukong.do?method=subPage2&amp;columnId=1173">文档资料</a></div>
				<div class="readmore" style="padding:13px 0px 8px 38px; height:16px;"><a href="wukong.do?method=subPage2&amp;columnId=1172" class="readmore">更多...</a></div>
				
				<div style="padding:15px 0px 0px 23px;"><a href="wukong.do?method=subPage2&amp;columnId=1176"><img src="images/wukong/link1.jpg" width="180" height="80" border="0" /></a></div>
				<div style="padding:14px 0px 0px 23px;"><a href="wukong.do?method=subPage2&amp;columnId=1167"><img src="images/wukong/link2.jpg" width="180" height="80" border="0" /></a></div>			
			    <div class="bottomnav" style="padding:10px 15px 00px 23px; text-align:center;">如果您有意见或建议，请发至<a href="mailto:D_wukong@ulic.com.cn">D_wukong@ulic.com.cn</a></div></td>
          </tr>

        </table></td>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="424" valign="top" background="images/wukong/centerbg.jpg"><form method="post" action="wukong.do?method=check">
				<div>
					<div style="padding:30px 0px 137px 376px; height:14px;">
					<input type="text" name="tName" value="" style="width:130px; height:12px;" />
					<input type="submit" value="查找" style="width:40px; height:20px;" /></div>
					<div class="listTitle" style="padding:2px 0px 0px 162px; height:20px;"><div style="margin:5px 0px 0px 4px; float:left;">公告文件</div><div style="padding:5px 0px 0px 240px; float:left; width:60px;"><a href="wukong.do?method=subPage2&amp;columnId=1159" class="readmore">更多...</a></div></div>
					<div class="listContent" style="margin:3px 20px 5px 169px; height:140px;overflow:hidden; text-align:left;" id="marquees" onMouseOver="setMouse(1);" onmouseout="setMouse(0)">
					
					<%=d.divContent("gonggao1",0)%>
					<%=d.divContent("gonggao2",0)%>
					<%=d.divContent("gonggao3",0)%>
					
					</div>
						<div style="padding:20px 0px 0px 32px;"><a href="wukong.do?method=subPage2&amp;columnId=1159" class="readmore"></a></div>
					</div>
            </form>
			</td>
          </tr>
          <tr>
            <td background="images/wukong/centerbg2.jpg"><div style="padding:0px 49px 0px 16px;">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="51%" height="155" valign="top">
				  	<div class="listTitle" style="padding:10px 0px 0px 30px; height:20px;">管理政策</div>
					<div class="listContent" style="padding:3px 0px 0px 30px; height:77px;">
					
					<%=d.divContent("zhengce1",0)%>
					<%=d.divContent("zhengce2",0)%>
					
					</div>
					<div class="readmore" style="padding:10px 0px 0px 44px; height:16px;"><a href="wukong.do?method=subPage2&amp;columnId=1157" class="readmore">更多...</a></div>
				  
				  </td>
                  <td width="49%" valign="top">
				  	<div class="listTitle" style="padding:10px 0px 0px 30px; height:20px;">产品信息</div>
					<div class="listContent" style="padding:3px 0px 0px 30px; height:77px;">
					
					<%=d.divContent("chanpin1",0)%>
					<%=d.divContent("chanpin2",0)%>
					
					</div>
					<div class="readmore" style="padding:10px 0px 0px 40px; height:16px;"><a href="wukong.do?method=subPage2&amp;columnId=1162" class="readmore">更多...</a></div>
				  
				  
				  </td>
                </tr>
              </table>
            </div></td>
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

<SCRIPT language=JavaScript>
<!--
var mousein=0;
var old=document.all.marquees.innerHTML;
var oldpos=document.all.marquees.scrollTop;
function mup(){
	theTimer2=setTimeout("mup()", 100);
	if(mousein==0){
		var pos=document.all.marquees.scrollTop;
		document.all.marquees.scrollTop+=1;
	}
	if(pos!=document.all.marquees.scrollTop){
		pos++;
	}else{
		document.all.marquees.innerHTML+=old;
	}
	if(document.all.marquees.innerHTML.length>10000){
		document.all.marquees.innerHTML=old;
		document.all.marquees.scrollTop=oldpos;
	}
}
function setMouse(value){
	mousein=value;
}
mup();
//-->
</SCRIPT>





</body>
</html>
