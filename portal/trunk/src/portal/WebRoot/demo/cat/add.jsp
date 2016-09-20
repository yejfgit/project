<%@ page language="java" contentType="text/html; charset=utf-8" %>
<html>
  <head>
    <title>cat add</title>
    <%@ include file="/include/head.jsp"%>
    
  </head>
  <body>
  <form id="testForm" method="post" onsubmit="return false;">
 	<input type="hidden" name="ownerId" value="${ownerId }" />
    <input type="hidden" name="ownerType" value="dog_type" />
	<center>
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="tablebg">
	  <tr height="19">
		<td valign="top"><%-- <c:navigate menuId="${_menuId }" /> --%></td>
	  </tr>
	  <tr>
		<td align="center" valign="top">
		  <table width="95%" border="0" cellpadding="2" cellspacing="1">
            <tr align="left">
              <td>
	            <font class="title">新增猫猫</font>
        	  </td>
      	    </tr>
   	      </table>
		  <table width="95%" border="0" cellpadding="2" cellspacing="1" class="table1">
		    <tr>
			  <td width="20%" class="tabtd2">姓名</td>
			  <td class="tabtd1">
			  	<input type="text" name="cat.catName" class="inputred" />
			  </td>
		    </tr>
		  </table>
		  <br>
		  
		   <!-- 附件上传 -->
	   	  <div id="atts"></div>
	   	  
		  <br>
		  <table width="95%" border="0" cellpadding="5" cellspacing="0" class="tableopr">
      	    <tr align="center">
              <td>
                <html:button property="" onclick="save();" styleClass="button1">保存</html:button>&nbsp;
                <html:button property="" onclick="history.back();" styleClass="button2">取消</html:button>
              </td>
            </tr>
          </table>
	    </td>
	  </tr>
	</table>
	</center>
	
  </form>
  </body>
  
  <script type="text/javascript">
	  <!--
	  	var testForm = g('testForm');
	  
		function checkInput(){
		
			return true;
		}
		
		function save(){
			var isSubmit = checkInput();
			if(!isSubmit){
				return false;
			}
			testForm.action = "cat/save";
			testForm.submit();
		}
	  //-->
  </script>
</html>
