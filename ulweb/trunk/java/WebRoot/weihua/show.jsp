<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb2.entity.ContentEntity,com.ulic.ulweb.ulweb.entity.UlAttachment,com.ulic.ulweb.frame.constant.Constant" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>


<title>微话</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="weihua/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="weihua/js/ajax2.js"></script>

<style type="text/css">
body{font-family: "Microsoft YaHei",微软雅黑,"MicrosoftJhengHei",华文细黑,STHeiti,MingLiu;font-size: 15px;}
.mainDiv{margin: auto;width: 1000px;height: auto;border: 1px solid #fff;background-color: #fff;overflow: hidden;}
.mainTop{margin: 1px 1px;height: 49px;}
.mainTop .left{width: 800px;float: left;height: auto;overflow: hidden;}
.mainTop .right{width: 185px;float: left;height: auto;overflow: hidden;margin-left: 10px;}

.mainLeft{width: 660px;margin: 0px 0px;height:auto;background-color: #fff;float: left;overflow: hidden;}
.mainRight{width: 320px;margin-left: 10px;height:auto;background-color: #fff;float: left;overflow: hidden;}

.mainRight .mid{width: 100%;height: auto;overflow: hidden;}

.mainLeft .left a{color: #ff3400;;}
.mainLeft .left a:hover{color: purple;}
.mainLeft .right a:hover{color: purple;}
.zan1{width: 50px;height: 50px;background: url("weihua/images/zan1.png") yellow;float: left;margin-left: 10px;cursor: pointer;}
.zan2{width: 50px;height: 50px;background: url("weihua/images/zan2.png") yellow;float: left;margin-left: 10px;cursor: pointer;}
.zan3{width: 50px;height: 50px;background: url("weihua/images/zan3.png") yellow;float: left;margin-left: 10px;cursor: pointer;}
.zan4{width: 50px;height: 50px;background: url("weihua/images/zan4.png") yellow;float: left;margin-left: 10px;cursor: pointer;}
.zan5{width: 50px;height: 50px;background: url("weihua/images/zan5.png") yellow;float: left;margin-left: 10px;cursor: pointer;}
.zan6{width: 50px;height: 50px;background: url("weihua/images/zan6.png") yellow;float: left;margin-left: 10px;cursor: pointer;}
.zan1_num{width: 50px;height: 30px;background-color: #fff;float: left;margin-left: 10px;line-height: 30px;vertical-align: center;text-align: center;color: #ccc;font-weight: bolder;}
.zan2_num{width: 50px;height: 30px;background-color: #fff;float: left;margin-left: 10px;line-height: 30px;vertical-align: center;text-align: center;color: #ccc;font-weight: bolder;}
.zan3_num{width: 50px;height: 30px;background-color: #fff;float: left;margin-left: 10px;line-height: 30px;vertical-align: center;text-align: center;color: #ccc;font-weight: bolder;}
.zan4_num{width: 50px;height: 30px;background-color: #fff;float: left;margin-left: 10px;line-height: 30px;vertical-align: center;text-align: center;color: #ccc;font-weight: bolder;}
.zan5_num{width: 50px;height: 30px;background-color: #fff;float: left;margin-left: 10px;line-height: 30px;vertical-align: center;text-align: center;color: #ccc;font-weight: bolder;}
.zan6_num{width: 50px;height: 30px;background-color: #fff;float: left;margin-left: 10px;line-height: 30px;vertical-align: center;text-align: center;color: #ccc;font-weight: bolder;}

</style>
<%
  		ContentEntity c = (ContentEntity)request.getAttribute("c"); 
%>
<script>

</script>
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
		<div class="mainLeft" >
			<div style="font-size: 20px;padding: 25px 10px 0 10px;;font-weight: bolder;border-bottom: 2px solid #ddd;text-align: left">
				<%=(c.getContentName() == null ? "" : c.getContentName())%>
				<div style="font-size: 12px;color: #ddd;text-align: right;">
					<%
					 out.print((c.getSubTitle() == null ? "此项内容无正文，请点击下列附件查看" : "作者："+c.getSubTitle()));
					%>
				</div>
			</div>
			<div style="padding: 15px 10px;">
				<%
					out.print((c.getContentString() == null ? "此项内容无正文，请点击下列附件查看" : c.getContentString()));
				%>
			</div>
			<div id="showZanList" style="display: block;padding: 20px 0;border-top: 1px solid #ddd;border-bottom: 0px solid #ddd;overflow: hidden;">
				<div>
					<%int goodId2 = 1;%>
					<logic:iterate id="element" name="clicksGoodList">
						<div class="zan<%=goodId2%>"  onclick="addClicks('<bean:write name="element" property="contentId" />','<bean:write name="element" property="type" />',this)"></div>
						<%goodId2++;%>
					</logic:iterate>
					<div style="clear: both"></div>
				</div>
				<div>
					<%int goodId = 1;%>
					<logic:iterate id="element" name="clicksGoodList">
						<div class="zan<%=goodId%>_num"><bean:write name="element" property="clicksNums" /></div>
						<%goodId++;%>
					</logic:iterate>
					<div style="clear: both"></div>
				</div>
				
			</div>
			
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
		<div class="mainRight">
			<div style="text-align:right;color: #ccc;font-weight: bolder;font-size: 14px;padding: 0px 10px;cursor: pointer;background: url('weihua/images/hot.jpg') no-repeat left;height: 50px;line-height: 50px;vertical-align: center" onclick="window.open('weihua.do?method=list');"></div>
			<ulweb:content beanName="c2" deptId="0000" enName="weihua" pageNum="1" pageSize="10" columnId="5686" clickNum="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
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
	
	
	
	
</body>
<script type="text/javascript">
var clock = 0;//页面只允许点击一次
function addClicks(contentId,type,obj){
	if(clock==0){
		$(obj).css("background-color","#ddd");
		var cls = $(obj).attr("class");
		var num = parseInt($("."+cls+"_num").text());
		$("."+cls+"_num").text(num+1);
		clock++;
		
		
		
		$.ajax({
				type:"post",
				url:"weihua.do?method=clicksGood",
				async : false,
				data:"contentId="+contentId+"&type="+type,
				dataType: "text",      
				ContentType:'application/json; charset=utf-8',
				success:function(s){
					
				}
			});
	}
	

}

</script>
</html>