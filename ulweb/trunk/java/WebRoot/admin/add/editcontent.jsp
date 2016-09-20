
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.frame.util.HtmlUtil" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改内容</title>
    
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
   <%
  	UlContent c = (UlContent)request.getAttribute("content");
  %>
  <script language="JavaScript" src="script/content.js"></script>
   <script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
     <script language="JavaScript" src="script/dtree.js" type="text/javascript" ></script> 
	 <script language="JavaScript">
	 	var attSum = <%=c.getAttachmentSum()%>;
	 </script>
  <body>
  <table width="750" border="0" cellspacing="0" cellpadding="0" align="center" style="border-left:gray 1px solid;">
  <form action="admin/content.do?method=edit" method="post" name="form1"  id="idform1">
  <input type="hidden" name="contentId" id="idcontentId" value='<%=c.getContentId()%>' />
 <input type="hidden" name="attSum" value="<%=c.getAttachmentSum()%>" id="idattSum" />
  <input type="hidden" name="content" id="idcontent" />
  <input type="hidden" name="deptId" id="iddeptId" value='<%=request.getAttribute("deptId")%>' />
  <input type="hidden"  name="showToOther" value="0"></input>
<input type="hidden"  name="showToOrgan" value="0"></input>
<input type="hidden" name="columnId" id="idcolumnId" value='<%=c.getColumnId()%>' />
<input type="hidden" name="attDel" value="" id="idattDel" />
<input type="hidden" name="columnName" id="idcolumnName" value='<%=c.getColumn_name()%>'></input>

  <tr>
  	<td width="20"></td>
  	<td width="180" align="left" valign="top"> 
		<%=request.getAttribute("columnList")%>
	</td>
  
    <td>
		<table border="1" cellpadding="0" cellspacing="0" width="100%">
			
			<tr>
				<td width="35%">
					上级栏目:
				</td>
				<td id="idcolumnInfo">
					<%=c.getColumn_name()%>
				</td>
			</tr>
			<tr>
				<td>
					标题(必添):
				</td>
				<td>
					<input type="text" name="contentName" id="idcontentName" maxlength="100" size="20" value='<%=c.getContentName()%>' ></input>
				</td>
			</tr>
			<tr>				
            <td> 副标题: </td>
				<td>
					<input  type="text" name="subTitle" id="idsubTitle" maxlength="100" size="20" value='<%=(c.getSubTitle() == null ? "" : c.getSubTitle())%>'></input>
				</td>
			</tr>
			<tr>
				<td>
					关键字:
				</td>
				<td>
					<input type="text" maxlength="20" size="20" name="keyWord" value="<%=(c.getKeyWord() == null ? "" : c.getKeyWord())%>" ></input>
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
					<input type="radio" name="isQuickLink" value="1"  <%if(c.getIsQuickLink() == 1) out.print("checked");%> />是
					&nbsp;&nbsp;
					<input type="radio" name="isQuickLink" value="0"   <%if(c.getIsQuickLink() == 0) out.print("checked");%> />否
					&nbsp;&nbsp;
					显示天数:
					<input type="text" name="quickTime" id="idquickTime" size="5" maxlength="2"  value="<%=c.getQuickTime()%>"></input>
				</td>
			</tr>
			
			<%
				}else{
			%>
				<input type="hidden" name="isQuickLink" value="0"></input>
				<input type="hidden" name="quickTime" value='<%=c.getQuickTime()%>'	></input>			
			
			<%
				}
			%>
			<tr>
				<td>
					特殊显示(与主页设计有关):
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
					上传部门:
				</td>
				<td>
					<input type="text" name="uploadDeptStr" id="iduploadDeptStr" maxlength="20" size="20" value="<%=(c.getUploadDeptStr() == null ? "" : c.getUploadDeptStr())%>"></input>
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
									oFCKeditor.Value	= "<%=HtmlUtil.getHtmlFilterValue((c.getContent() == null ? "" : c.getContent()))%>";
									oFCKeditor.Create() ;
								</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					现有附件(点击删除):
				</td>
				<td>
					<%
						if(c.getAttachmentSum() == 0){
							out.print("无");
						}else{
							for(int i = 1; i <= c.getAttachmentSum(); i++){
								out.print("&nbsp;&nbsp;<a href='javascript:deleteA(" + i + ");' id='ida" + i + "'>附件" + i + "</a>" );
							}
						}
					%>
				</td>
			</tr>
			<tr>
				<td>
					是否继续添加附件
				</td>
				<td id="idfiles">
					<input type="radio" name="att" value="1"   >有</input>
					<input type="radio" value="0" name="att"  id="idattNull"   checked >否</input>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" onClick="subEditFrm();" value="确定" />
					&nbsp;&nbsp;
					<input type="button" onClick="javascript:window.location.href='../admin/content.do?method=list';" value="取消" />
				</td>
			</tr>
		</table>
	</td>
  </tr>
  </form>
</table>
			<script language="JavaScript">
				document.getElementById("iddisplayType").value = <%=c.getDisplayType()%>;
				changeTitleColor();
			</script>
  </body>
</html>
