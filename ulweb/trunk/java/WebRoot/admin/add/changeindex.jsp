
<%@ page language="java" import="java.util.*,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改主页图片</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
   <TABLE  cellSpacing=0 cellPadding=0 width=756 align=center 
bgColor=#ffffff border=0><!--DWLayoutTable-->
  <TBODY>
  <TR>
    <TD vAlign=top colSpan=9 height=83>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" bgColor=#ffffff><!--DWLayoutTable-->
        <TBODY>
        <TR>
          <TD width=4 height=4></TD>
          <TD width=106></TD>
          <TD width=1></TD>
          <TD width=637></TD></TR>
        <TR>
          <TD vAlign=top colSpan=3 height=60><IMG height=60 
            src="images/index/logo1.jpg" width=117></TD>
          <TD vAlign=top rowSpan=3><a href="admin/add/chosemainpagepic.jsp?ppath=<%=Constant.mainPaget%>&name=mainPaget" ><IMG height=70 
            src="<%=(Constant.mainPaget == null ? "" : Constant.mainPaget)%>" border="0" width=639></a></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=9></TD>
          <TD vAlign=top align=middle rowSpan=2>和 你 在 一 起</TD>
          <TD></TD></TR>
        <TR>
          <TD height=5></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=2></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD vAlign=top background="images/index/banner1.jpg" colSpan=9 height=36>
      <TABLE cellSpacing=0 cellPadding=0 width="100%"><!--DWLayoutTable-->
        <TBODY>
        <TR>
          <TD width=23 height=3></TD>
          <TD width=22></TD>
          <TD width=167></TD>
          <TD width=1></TD>
          <TD width=22></TD>
          <TD width=77></TD>
          <TD width=1></TD>
          <TD width=77></TD>
          <TD width=1></TD>
          <TD width=108></TD>
          <TD width=30></TD>
          <TD width=117></TD>
          <TD width=16></TD>
          <TD width=72></TD>
          <TD width=5></TD></TR>
        <TR>
          <TD height=2></TD>
          <TD></TD>
              <TD vAlign=center align=middle rowSpan=8>通讯录 | 邮件地址簿 01-19 </TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
              <TD vAlign=center align=middle rowSpan=9>修改邮箱密码</TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD vAlign=top rowSpan=5><IMG height=21 
            src="images/index/cont.jpg" width=24></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
              <TD vAlign=center align=middle rowSpan=6>合理化建议</TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
              <TD vAlign=center align=middle rowSpan=4>常用表格下载</TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
              <TD vAlign=center align=middle bgColor=#ffffff rowSpan=3>调查投票</TD>
          <TD></TD></TR>
        <TR>
          <TD height=2></TD>
          <TD></TD>
          <TD vAlign=center align=right rowSpan=4><IMG height=21 
            src="images/index/modifyPassword.gif" width=24></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=16></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
              <TD vAlign=center align=middle>部门主页</TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=2></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD height=1></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD>
          <TD></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD width=126 height=1></TD>
    <TD width=24></TD>
    <TD width=3></TD>
    <TD width=29></TD>
    <TD width=359></TD>
    <TD width=31></TD>
    <TD width=1></TD>
    <TD width=187></TD>
    <TD width=1></TD></TR>
  <TR>
    <TD colSpan=9>
      <TABLE cellSpacing=0 cellPadding=0 border=0>
        <TBODY>
        <TR>
          <TD width=140 height=1></TD>
          <TD width=19></TD>
          <TD width=390></TD>
          <TD width=19></TD>
          <TD width=188></TD></TR>
        <TR>
          <TD id=idleft vAlign=top align=middle width=140>
            <TABLE cellSpacing=0 cellPadding=0 align=center border=0>
              <TBODY>
              <TR>
                <TD>
                  <TABLE class=9green1 cellSpacing=0 cellPadding=0 width="100%" 
                  bgColor=#e5e5e5><!--DWLayoutTable-->
                    <TBODY>
                    <TR vAlign=center>
                      <TD width=1 height=26></TD>
                      <TD width=1></TD>
                      <TD width=3></TD>
                      <TD vAlign=center width=114>公文</TD>
                      <TD width=20></TD>
                      <TD width=1></TD></TR>
                    <TR vAlign=center>
                      <TD height=4></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD></TR>
                    <TR vAlign=center>
                      <TD height=20></TD>
                      <TD vAlign=top colSpan=5><FONT color=#ff0000>三天内新公文数：1 
                        </FONT></TD>
                    <TR vAlign=center>
                              <TD vAlign=top align=right colSpan=5 height=20><FONT 
                        face=System>&gt;&gt;</FONT></TD>

                      <TD>&nbsp;</TD></TR>
                    <TR vAlign=center>
                      <TD class=more height=16>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD></TR>
                    <TR vAlign=center>
                      <TD height=26>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD vAlign=center align=middle colSpan=3><FONT 
                        color=#000000>信息快递</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR vAlign=center>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>合众简报&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>机构发展快讯&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>行业资讯&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR vAlign=center>
                      <TD height=26>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD class=white vAlign=center align=middle 
                        colSpan=3><FONT color=#000000>理赔专栏</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR vAlign=center>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>理赔专刊&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>理赔案例&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>理赔新闻&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR vAlign=center>
                      <TD height=26>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD class=white vAlign=center align=middle 
                        colSpan=3><FONT color=#000000>合众人风采</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                      <TD height=25></TD>
                              <TD class=9green1 vAlign=center colSpan=3>合众人风采&nbsp;01-31 
                              <TD class=9green1 vAlign=center align=right><FONT 
                        face=System>&gt;&gt;</FONT></TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                              <TD align=middle colSpan=6>查询页</TD>
                            </TR>
                    <TR>
                              <TD align=middle colSpan=6>未改版前的文件</TD>
                            </TR>
                    <TR>
                      <TD height=2></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD></TR></TBODY></TABLE></TD></TR>
              <TR>
                <TD height=15></TD></TR>
              <TR>
                <TD>
                  <TABLE height=300 width="100%">
                    <TBODY>
                    <TR>
                      <TD height="10"></TD></TR>
					  <tr><td>
					  	<a href="admin/add/chosemainpagepic.jsp?ppath=<%=Constant.mainPagep1%>&name=mainPagep1" ><IMG height=70 
            src="<%=(Constant.mainPagep1 == null ? "" : Constant.mainPagep1)%>" border="0" width=140></a>
					  </td></tr>				  
					  <tr><td>
					  	<a href="admin/add/chosemainpagepic.jsp?ppath=<%=Constant.mainPagep2%>&name=mainPagep2" ><IMG height=70 
            src="<%=(Constant.mainPagep2 == null ? "" : Constant.mainPagep2)%>" border="0" width=140></a>
					  </td></tr>				  
					  <tr><td>
					  	<a href="admin/add/chosemainpagepic.jsp?ppath=<%=Constant.mainPagep3%>&name=mainPagep3" ><IMG height=70 
            src="<%=(Constant.mainPagep3 == null ? "" : Constant.mainPagep3)%>" border="0" width=140></a>
					  </td></tr>				  
					  <tr><td>
					  	<a href="admin/add/chosemainpagepic.jsp?ppath=<%=Constant.mainPagep4%>&name=mainPagep4" ><IMG height=70 
            src="<%=(Constant.mainPagep4 == null ? "" : Constant.mainPagep4)%>" border="0" width=140></a>
					  </td></tr>				  
					  
					  </TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
          <TD></TD><!--	中间			-->
          <TD id=idcenter vAlign=top>
            <TABLE cellSpacing=0 cellPadding=0 align=center border=0>
              <TBODY>
              <TR>
                <TD>
                  <TABLE class=9green1 
                  style="BORDER-RIGHT: gray 1px solid; BORDER-BOTTOM: gray 1px solid" 
                  cellSpacing=0 cellPadding=0 width="100%" bgColor=#ffffff><!--DWLayoutTable-->
                    <TBODY>
                    <TR>
                      <TD vAlign=center align=middle bgColor=#e5e5e5 colSpan=2 
                      height=24><FONT color=#006699>合 众 播 报 </FONT></TD>
                      <TD width=6>&nbsp;</TD>
                              <TD vAlign=center align=middle bgColor=#e5e5e5 
                        colSpan=2><FONT 
                        face=System>&gt;&gt;&gt;</FONT></TD>
                            </TR>
                    <TR>
                      <TD width=15 height=10></TD>
                      <TD width=331></TD>
                      <TD></TD>
                      <TD width=7></TD>
                      <TD width=22></TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130 
                              </TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130
                              </TD>
                      <TD></TD></TR>
                   <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130 
                              </TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130
                              </TD>
                      <TD></TD></TR><TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130 
                              </TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130
                              </TD>
                      <TD></TD></TR><TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130 
                              </TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130
                              </TD>
                      <TD></TD></TR><TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130 
                              </TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=3><IMG height=8 
                        src="images/index/a6.gif" width=8> 关于2007年元月份佣金聘才发放的通知   /070130
                              </TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=11></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD></TR></TBODY></TABLE></TD></TR>
              <TR>
                <TD height=10></TD></TR>
              <TR>
                <TD>
                  <TABLE 
                  style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; BORDER-BOTTOM: gray 1px solid" 
                  cellSpacing=0 cellPadding=0 width="100%" bgColor=#ffffff><!--DWLayoutTable-->
                    <TBODY>
                    <TR>
                      <TD vAlign=top>
					<a href="admin/add/chosemainpagepic.jsp?ppath=<%=Constant.mainPagea%>&name=mainPagea" ><IMG height=70 
            src="<%=(Constant.mainPagea == null ? "" : Constant.mainPagea)%>" border="0" width=390></a>
					   </TD></TR></TBODY></TABLE></TD></TR>
              <TR>
                <TD height=10></TD></TR>
              <TR>
                <TD>
                  <TABLE class=9green1 cellSpacing=0 cellPadding=0 width="100%" 
                  bgColor=#e5e5e5 border=0><!--DWLayoutTable-->
                    <TBODY>
                    <TR>
                      <TD width=11 height=7></TD>
                      <TD width=1></TD>
                      <TD width=14></TD>
                      <TD width=28></TD>
                      <TD width=293></TD>
                      <TD width=28></TD>
                      <TD width=6></TD>
                      <TD width=10></TD></TR>
                    <TR>
                      <TD height=11></TD>
                      <TD></TD>
                      <TD vAlign=center align=middle 
                      background="images/index/bg1.jpg" colSpan=2 
                      rowSpan=3>公告</TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=20></TD>
                      <TD></TD>
                      <TD></TD>
                              <TD vAlign=center align=right><FONT 
                        face=System>&gt;&gt;&gt;</FONT></TD>
                      <TD></TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=2></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD>
                      <TD></TD></TR>
                    <TR>
                      <TD height=19>&nbsp;</TD>
                      <TD vAlign=top colSpan=6>
                        <HR SIZE=1>
                      </TD>
                      <TD>&nbsp;</TD></TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                    <TR>
                      <TD height=20></TD>
                              <TD vAlign=center colSpan=6>关于成立产品训练功能组的通知   /070119 </TD>
                            </TR>
                   
							
                    <TR>
                      <TD height=18>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD>
                      <TD>&nbsp;</TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD>
          <TD></TD><!--				右边			-->
          <TD id=idright vAlign=top>
            <TABLE cellSpacing=0 cellPadding=0 align=center border=0>
              <TBODY>
              <TR>
                <TD>
                  <TABLE class=9green1 cellSpacing=2 cellPadding=5 width="100%" 
                  bgColor=#e7e7e7 border=0><!--DWLayoutTable-->
                    <TBODY>
                    <TR>
                      <TD vAlign=center align=middle bgColor=#d2edc0 
                        height=26>业绩播报(本周)</TD></TR>
                    <TR>
                      <TD vAlign=center bgColor=#ffffff height=20>个险保费: 33 万元 
                      </TD></TR>
                    <TR>
                      <TD vAlign=center bgColor=#ffffff height=20>团险保费: 333 万元 
                      </TD></TR>
                    <TR>
                      <TD vAlign=center bgColor=#ffffff height=20>银代保费: 333 万元 
                      </TD></TR>
                    <TR>
                      <TD vAlign=center align=middle bgColor=#fdecd0 
                        height=26>系统链接</TD></TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>核心业务系统</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>ORACLE-ERP系统</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>OA工作流系统</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>企业信息决策系统</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>营销速报系统</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>建议书系统</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>问题管理系统</TD>
                            </TR>
                    <TR>
                      <TD vAlign=center align=middle bgColor=#feffb1 
                        height=26>下载中心</TD></TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>内部培训资料下载</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>公司LOGO下载 </TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>分公司筹备品牌指导手册</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>CI下载(1) 
                                (2) </TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff >合众信息管理系统用户手册</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>保险代理人从业资格考试八月机考全真题考点分析</TD>
                            </TR>
                    <TR>
                      <TD vAlign=center align=middle bgColor=#fac7fa 
                        height=26>热门链接</TD></TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>IT资源下载</TD>
                            </TR>
                    <TR>
                              <TD vAlign=center bgColor=#ffffff height=20>ERP系统专栏 </TD>
                            </TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD vAlign=top colSpan=9 height=40>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0><!--DWLayoutTable-->
        <TBODY>
        <TR>
          <TD width=207 height=24>&nbsp;</TD>
              <TD vAlign=center width=359>首页&nbsp; |&nbsp; 关于合众 |&nbsp; 问题上报&nbsp; 
                |&nbsp; 分公司主页&nbsp; |&nbsp;系统管理&nbsp; </TD>
          <TD width=192>&nbsp;</TD></TR>
        <TR>
          <TD vAlign=top colSpan=3 height=16>
            <HR color=black SIZE=1>
          </TD></TR><!--DWLayoutTable--></TBODY></TABLE></TD></TR>
  <TR>
    <TD vAlign=top bgColor=#ffa034 colSpan=4 height=36><!--DWLayoutEmptyCell-->&nbsp;</TD>
    <TD class=9b vAlign=top align=middle colSpan=3>Copyright Reserved,Union 
      Life Insurance Company,Ltd. <BR>建议使用分辨率800*600浏览 <BR>2004年10月14日</TD>
    <TD vAlign=top bgColor=#ffa034 
  colSpan=2><!--DWLayoutEmptyCell-->&nbsp;</TD></TR>
  <TR>
    <TD height=33>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD>
    <TD>&nbsp;</TD></TR></TBODY></TABLE>
	<table><tr><td></td></tr></table>
  </body>
</html>
