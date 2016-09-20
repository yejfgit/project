
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addcontent.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
     <LINK href="style/ul.css" type="text/css" rel=stylesheet>
	   <LINK href="style/dtree.css" type="text/css" rel=stylesheet>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  <script language="JavaScript" src="script/content.js"></script>
   <script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
     <script language="JavaScript" src="script/dtree.js" type="text/javascript" ></script> 
  <body>
  <table width="750" border="0" cellspacing="0" cellpadding="0" align="center" style="border-left:gray 1px solid;">
  <form action="admin/content.do?method=add" method="post" name="form1" id="idform1" >
  <input type="hidden" name="content" id="idcontent" />
  <input type="hidden" name="deptId" id="iddeptId" value='<%=request.getAttribute("deptId")%>' />
  <input type="hidden"  name="showToOther" value="0"></input>
<input type="hidden"  name="showToOrgan" value="0"></input>
<input type="hidden" name="columnId" id="idcolumnId" value='<%=(request.getParameter("columnId") == null ? 0 : request.getParameter("columnId"))%>' />
<input type="hidden" name="columnName" id="idcolumnName" value='<%=request.getParameter("columnName")%>'></input>
  <tr>
  	<td width="20"></td>
  	<td width="180" align="left" valign="top"> 
		<%=request.getAttribute("columnList")%>
	</td>
  
    <td width="550">
		<table border="1" cellpadding="0" cellspacing="0" width="100%">
			
			<tr>
				<td width="35%">
					上级栏目:
				</td>
				<td id="idcolumnInfo">
					<%
						if(request.getParameter("columnName") != null && !request.getParameter("columnName").equals("")){
							out.print("<font color='#00ccff'>" + request.getParameter("columnName") + "</font>");
						}else{
							out.print("请在左侧选择栏目");
						}						
					%>
				</td>
			</tr>
			<tr>
				<td>
					标题(必添):
				</td>
				<td>
					<input type="text" name="contentName" id="idcontentName" maxlength="100" size="20" style="color:#004A1B;"></input>
				</td>
			</tr>
			<tr>
				
            <td> 副标题: </td>
				<td>
					<input  type="text" name="subTitle" id="idsubTitle" maxlength="100" size="20" value=""></input>
					(一般用于主页新闻发布)
				</td>
			</tr>
			<tr>
				<td>
					关键字:
				</td>
				<td>
					<input type="text" maxlength="20" size="20" name="keyWord" value=""></input>
				</td>
			</tr>
			<%
				if(!((String)request.getAttribute("deptId")).equals("0000")){				
			%>
			<tr>
				<td>
					显示在快捷位置:
				</td>
				<td>
					<input type="radio" name="isQuickLink" value="1" />是
					&nbsp;&nbsp;
					<input type="radio" name="isQuickLink" value="0" checked />否
					&nbsp;&nbsp;
					显示天数:
					<input type="text" name="quickTime" id="idquickTime"  value="3" size="5" maxlength="2"></input>
				</td>
			</tr>
			
			
			<%
				}else{
			%>
				<input type="hidden" name="isQuickLink" value="0"></input>				
				<input type="hidden" name="quickTime" id="idquickTime"  value="3"></input>
			
			<%
				}
			%>
			<tr>
				<td >
					重要程度(与主页设计有关):
				</td>
				<td>
					<select name="displayType" onChange="javascript:changeTitleColor();" id="iddisplaytype">
					<option value="0">一般(显示为默认暗绿色)</option>
					<option value="8">需要注意(显示为黄色)</option>
					<option value="9">重要(显示为红色)</option>
					<option value="2">黑色</option>
					<option value="3">蓝色</option>
					<option value="4">绿色</option>
					<option value="5">蓝绿</option>
					<option value="6">淡紫</option>
					<option value="7">紫色</option>
					
				      </select>
				</td>
			</tr>
			
			<tr>
				<td>
					新闻发布部门:
				</td>
				<td>
					<input type="text" name="uploadDeptStr" id="iduploadDeptStr" maxlength="20" value="" size="20"></input>
					(一般用于主页新闻发布)
				</td>
			</tr>
			<tr>
				<td colspan="2">
					内容:
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table cellpadding="0" border="0" cellspacing="0" width="100%">
						<tr>
							<td>
								<script type="text/javascript">
									var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
									oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
									oFCKeditor.Height	= 400 ;
									oFCKeditor.Value	= "";
									oFCKeditor.Create() ;
								</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					是否有附件
				</td>
				<td id="idfiles">
					<input type="radio" name="att" value="1" >有</input>
					<input type="radio" value="0"  id="idattNull" name="att" checked>无</input>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" onClick="subFrm();" value="确定" />
					&nbsp;&nbsp;
					<input type="button" onClick="javascript:window.location.href='../admin/content.do?method=list';" value="取消" />
				</td>
			</tr>
		</table>
	</td>
  </tr>
  </form>
</table>

  </body>
</html>
