<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant,com.ulic.ulweb.ulweb.web.action.IndexAction" %>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String enName = request.getParameter("eId");
	String keyWord = request.getParameter("keyWord");
	//String strId = request.getParameter("id");
	String strId = "2671";
	String strPage = request.getParameter("pageNum");
	
	int columnId;
	try {
		columnId = Integer.parseInt(strId);
	} catch (Exception e) {
		columnId = 0;
	}
	
	int pageNum;
	try {
		pageNum = Integer.parseInt(strPage);
	} catch (Exception e) {
		pageNum = 1;
	}	

%>
<title>微话</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/boxover.js"></script>
<script language="JavaScript" src="script/list.js"></script>
<script type="text/javascript" src="weihua/js/jquery-1.7.1.js"></script>
<style type="text/css">
body{font-family: "Microsoft YaHei",微软雅黑,"MicrosoftJhengHei",华文细黑,STHeiti,MingLiu;font-size: 15px;}
.mainDiv{margin: auto;width: 1000px;height: auto;border: 1px solid #fff;background-color: #fff;overflow: hidden;}
.mainTop{margin: 1px 1px;height: 49px;}
.mainTop .left{width: 800px;float: left;height: auto;overflow: hidden;}
.mainTop .right{width: 185px;float: left;height: auto;overflow: hidden;margin-left: 10px;}

.mainLeft{width: 1000px;margin: 0px 0px;height:auto;background-color: #fff;float: left;overflow: hidden;}
.mainRight{width: 188px;margin-left: 10px;height:auto;background-color: #fff;float: left;overflow: hidden;}
.mainLeft .left{width: 660px;background-color: #fff;float: left;height: auto;overflow: hidden;}
.mainLeft .right{width: 320px;background-color: #fff;float: left;height: auto;overflow: hidden;margin-left: 10px;}
.mainRight .mid{width: 100%;height: auto;overflow: hidden;}

.mainLeft .left a{color: #ff3400;;}
.mainLeft .left a:hover{color: purple;}
.mainLeft .right a:hover{color: purple;}
</style>

<body style="background-color: #eee">
	<div class="mainDiv">
		<div class="mainTop">
			<div style="width: 100%;height: 49px;">
				<ulweb:content beanName="cl" deptId="0000" enName="dbtp" pageNum="1" pageSize="1" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="cl" property="objectList">
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<a  href="<bean:write name="element" property="subTitle" />" style="cursor: pointer;">
								<img src="<bean:write name="e" property="displayPath" />" style="width: 990px;height: 49px;"/>
							</a>
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
			</div>
		</div>
		<div class="mainLeft">
			<div class="left">
				<ulweb:content beanName="cl" deptId="0000" enName="weihua" 
												columnId="5686"
												pageNum="<%=pageNum %>"
				 								pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="cl" property="objectList">
					<% int imgIndexF = 1; %>
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<% if(imgIndexF==1){%>
							<div style="width: 100%;height: 116px;border-bottom: 1px solid #ddd;margin-top: 8px;">
								<div style="height: 100%;width: 150px;background-color: #fff;float: left;cursor: pointer;" onclick="window.location.href='weihua.do?method=show&c=<bean:write name="element" property="contentId" />';window.location.target='_self'">
									<!--  <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" style="width: 135px;height: 100px" class="bor"/></a>-->
									<img src="<bean:write name="e" property="displayPath" />" style="width: 135px;height: 100px" class="bor"/>
								</div>
								<div style="height: 100%;width: 510px;background-color: #fff;float: left;text-align: left;">
									<div style="font-size: 19px;padding: 5px 5px;font-weight:bolder;cursor: pointer;">
										<a target="_self" style="text-decoration: none" href="weihua.do?method=show&c=<bean:write name="element" property="contentId" />">
											<bean:write name="element" property="contentName" filter="false" />
										</a>
										<!--<bean:write name="element" property="contentNameLink" filter="false" />-->
									</div>
									<div style="padding: 5px 5px;"><bean:write name="element" property="keyWord" filter="false" /></div>
									<bean:define id="element" name="element" property="contentId"></bean:define>
									<div style="padding: 5px 5px;text-align: right;color: #aaa;font-size: 14px;"><c:clicks contentId="<%=element %>" />&nbsp;&nbsp;&nbsp;&nbsp;点击</div>
								</div>
							</div>
							<%};imgIndexF++;%>
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
				<DIV class="next"><bean:write name="cl" property="pageTag" filter="false" /></DIV>
			</div>
			<script>
			 $(function(){
			 	$(".dispShow").mouseover(function(){
			 		var id = $(this).attr("id");
			 		$("#"+id+"_show").css("display","block");
			 	});
			 	$(".dispShow").mouseout(function(){
			 		var id = $(this).attr("id");
			 		$("#"+id+"_show").css("display","none");
			 	});
			 });
			
			</script>
			<div class="right">
				<div style="text-align:right;color: #ccc;font-weight: bolder;font-size: 14px;padding: 0px 10px;cursor: pointer;background: url('weihua/images/hot.jpg') no-repeat left;height: 50px;line-height: 50px;vertical-align: center" onclick="window.open('weihua.do?method=list');"></div>
				<ulweb:content beanName="c2" deptId="0000" enName="tupian" pageNum="1" pageSize="10" columnId="5686"  clickNum="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="c2" property="objectList">
					<% int imgIndex = 1; %>
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<% if(imgIndex==2){%>
							<div id="<bean:write name="element" property="contentId" filter="false" />" class="dispShow" style="height: auto;width: 100%;overflow: hidden;position: relative" >
								<div style="height: auto;width: 100%;background-color:#fff;overflow: hidden;cursor: pointer;" >
									<img src="<bean:write name="e" property="displayPath" />" style="width: 316px;height: 100px" class="bor"/>
								</div>
								<div style="height: auto;width: 100%;background-color: #fff;text-align: left;overflow: hidden;padding-left: 5px;font-weight: bolder;color: #000;font-size: 16px;margin: 5px 0 ;cursor: pointer;">
									<a target="_blank" style="text-decoration: none" href="weihua.do?method=show&c=<bean:write name="element" property="contentId" />">
										<bean:write name="element" property="contentName" filter="false" />
									</a>
								</div>
								<div onclick="window.open('weihua.do?method=show&c=<bean:write name="element" property="contentId" />');" id="<bean:write name="element" property="contentId" filter="false" />_show" style="display:none;height: 102px;width: 318px;background-color: #eee;text-align: left;overflow: hidden;position: absolute;left: 0px;top: 0px;filter:alpha(opacity=80);-moz-opacity:0.8;-khtml-opacity: 0.8;opacity: 0.8;z-index: 1;font-size: 16px;cursor: pointer;font-weight: bolder">
									<div style="padding: 2px 5px;"><bean:write name="element" property="keyWord" filter="false" /></div>
									<div style="text-align: right;padding: 2px 5px;"><bean:write name="e" property="clickNum" filter="false" />&nbsp;&nbsp;点击</div>
								</div>
							</div>
							<%};imgIndex++;%>
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
			</div>
		</div>
		
	</div>
</body>
</html>