
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlColumn" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公文添加</title>
    
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
  <script language="JavaScript" src="script/gongwen.js"></script>
   <script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
  <body>
    <table width="740" border="0" cellspacing="0" cellpadding="0" align="center">
  <form action="admin/document.do?method=add" method="post" name="form1" id="idform1" >
  <input type="hidden" name="content" id="idcontent" /> 
	<input type="hidden" name="isQuickLink" value="0" />			
	<input type="hidden"  name="showToOther" value="0"></input>
	<input type="hidden" name="showToOrgan" value="0"></input>		
	
	<tr>
		<td>
			
			<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
          <tr> 
            <td height="50"></td>
          </tr>
          <tr> 
            <td width="100%"> <table width="100%">
                <tr> 
                  <td align="center" style="color:#ff0000;font-size:40px"> 合众人寿保险股份有限公司文件 
                  </td>
                </tr>
              </table></td>
          </tr>
          <tr> 
            <td height="50"></td>
          </tr>
          <tr> 
            <td> <table width="100%" border="0" align="center">
                <tr> 
                  <td align="center" style="font-size:18px;">
				
					 公文文号: 
					<input name="documentNum" maxlength="20" size="20" type="text"> </input> 
                    &nbsp; 例：
					
					<input  value="合保发[2007]333号"></input>
										
					
					</td>
                </tr>
              </table></td>
          </tr>
          <tr> 
            <td width="100%"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr> 
                  <td width="10%"></td>
                  <td height="2" ><hr color="#FF0000" size="1"  noshade></td>
                  <td width="10%"></td>
                </tr>
              </table></td>
          </tr>
          <tr> 
            <td> <table border="0" cellspacing="0" align="center" width="100%">
                <tr> 
                  <td height="20"></td>
                </tr>
                <tr> 
                  <td align="center" style="font-size:24px"> 题目: <input type="text" name="contentName" id="idcontentName" maxlength="150" size="35"></input> 
                  </td>
                </tr>
                <tr> 
                  <td height="10"></td>
                </tr>
                <tr> 
                  <td width="100%"> 
				  	  <table border="0" cellspacing="0" width="100%">
				  	
					<tr><td width="10%"></td>
						<td width="80%">
								  <script type="text/javascript">
									var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
									oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
									oFCKeditor.Height	= 600 ;
									oFCKeditor.Value	= "";
									oFCKeditor.Create() ;
								</script> 
								
						</td><td width="10%"></td>
					</tr></table>
				   </td>
                </tr>
              </table></td>
          </tr>
		   <tr> 
            <td height="20"> 
			关键字(用以确定类型):
			<select name="columnId" id="idcolumnId">
				<option value="0" >请选择</option>
				<%
					List<UlColumn> l = (List<UlColumn>)request.getAttribute("listColumn");
					for(int i = 0 ; i < (l == null ? 0 : l.size()); i++){
				%>
						<option value="<%=l.get(i).getColumnId()%>"><%=l.get(i).getColumnName()%></option>
				<%
					}
				%>
			</select>			
			
			</td>
          </tr>
          <tr> 
            <td height="20"> 
			以便查询的主题词<input type="text" name="documentWord" size="50" ></input>
			此主题词在查找公文时使用
			</td>
          </tr>
          <tr> 
            <td> 是否有附件: 
              <input type="radio" name="att" value="1"  >
              有</input> <input type="radio" value="0" name="att" checked>
              无</input> </td>
          </tr>
          <tr> 
            <td align="center"> <input type="button" onClick="subFrm();" value="确定" /> 
              &nbsp;&nbsp; <input type="reset" value="重置" /> &nbsp;&nbsp; <a href="javascript:viewPage();" >预览</a> 
            </td>
          </tr>
        </table>
			
		</td>
	</tr>
  
  </form>
</table>
<script>
	document.getElementById("idcolumnId").value = <%=request.getParameter("columnId")%>;
</script>
  </body>
</html>
