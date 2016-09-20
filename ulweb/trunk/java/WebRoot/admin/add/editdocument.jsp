
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.frame.util.HtmlUtil" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公文更改</title>
    
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
  
   <%
  	UlContent c = (UlContent)request.getAttribute("c");
	
  %>
   <script language="JavaScript">
	 	var attSum = <%=c.getAttachmentSum()%>;
	 </script>
  <script language="JavaScript" src="script/gongwen.js"></script>
   <script type="text/javascript" src="editor/fckeditor/fckeditor.js"></script>
  
  <body>
    <table width="740" border="0" cellspacing="0" cellpadding="0" align="center">
  <form action="admin/document.do?method=edit" method="post" name="form1" id="idform1" >
    <input type="hidden" name="contentId" id="idcontentId" value='<%=c.getContentId()%>' />
	 <input type="hidden" name="attSum" value="<%=c.getAttachmentSum()%>" id="idattSum" />
	<input type="hidden" name="attDel" value="" id="idattDel" />
  <input type="hidden" name="content" id="idcontent" /> 
	<input type="hidden" name="isQuickLink" value="0" />			
	<input type="hidden"  name="showToOther" value="<%=c.getShowOthersClass()%>"></input>
	<input type="hidden" name="showToOrgan" value="<%=c.getShowOrganClass()%>"></input>		
	
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
                  <td align="center" style="font-size:18px;"> 公文文号: 
                    <input name="documentNum" maxlength="20" size="20" type="text" value="<%=c.getDocumentNum()%>"> </input> 
                    &nbsp; 例：合保发[2007]333号 </td>
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
                  <td align="center" style="font-size:24px"> 题目: <input type="text" name="contentName" id="idcontentName" maxlength="150" size="35" value="<%=c.getContentName()%>"></input> 
                  </td>
                </tr>
                <tr> 
                  <td height="10"></td>
                </tr>
                <tr> 
                  <td > 
				  <table border="0" cellspacing="0" width="100%">
				  	
					<tr><td width="10%"></td>
						<td width="80%">
								  <script type="text/javascript">
									var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
									oFCKeditor.BasePath	= "<%=basePath%>editor/fckeditor/" ;
									oFCKeditor.Height	= 600 ;
									oFCKeditor.Value	= "<%=HtmlUtil.getHtmlFilterValue(c.getContent())%>";
									oFCKeditor.Create() ;
								</script> 
								
						</td><td width="10%"></td>
					</tr></table>
					</td>
                </tr>
              </table></td>
          </tr>
		  <tr>
		  	<td>
				关键字:<%=c.getKeyWord()%>
			</td>
		  </tr>
          <tr> 
            <td height="20"> 
			以便查询的主题词<input type="text" name="documentWord" size="50" value="<%=(c.getDocumentWord() == null ? "" : c.getDocumentWord())%>" ></input>
			此主题词在查找公文时使用
			</td>
          </tr>
         
          <tr> 
            <td> 现有附件(点击删除): 
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
            <td> 是否有附件: 
              <input type="radio" name="att" value="1"  >
              有</input> <input type="radio" value="0" name="att" checked>
              无</input> </td>
          </tr>
          <tr> 
            <td align="center"> <input type="button" onClick="subEditFrm();" value="确定" /> 
              &nbsp;&nbsp; <input type="reset" value="重置" /> &nbsp;&nbsp; <a href="javascript:viewPage();" >预览</a> 
            </td>
          </tr>
        </table>
			
		</td>
	</tr>
  
  </form>
</table>

  </body>
</html>
