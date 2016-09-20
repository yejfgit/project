
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" pageEncoding="UTF-8"%>

<div class="bank5"></div>



<!--footer--->
<DIV class=bank10></DIV>
<div class="foot" style="margin-right: 26px;">
 <p style="font-size:14px; color:#000; padding-top:10px;"><a href="index.do">首页</a>  |  <a href="http://www.unionlife.com.cn/" target="_blank">关于合众</a>  |  <a href="admin/login.jsp" target="_blank">系统管理</a>
<!-- 
<ulweb:content beanName="cl" deptId="0000" enName="mail_address" pageNum="1" pageSize="1" conditions="isDelete=0:i;" />
		<logic:iterate id="element" name="cl" property="objectList">
			  |  <a href="show.do?c=<bean:write name="element" property="contentId" />">邮箱地址簿更新</a>[<bean:write name="element" property="updateTime" format="yyyy-MM-dd" />]
		</logic:iterate>
  -->
 </p>
</div>

<!--footer结束--->
<div>
 <p style="font-size:14px; color:#000; padding-top:10px;">合众人寿保险有限公司&nbsp;&nbsp;信息管理中心&nbsp;&nbsp; 版权所有
 </p>
</div>