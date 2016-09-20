<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<%@ page language="java" import="java.util.*,com.ulic.ulweb.ulweb.entity.UlTemplate,com.ulic.ulweb.ulweb.entity.UlColumn,com.ulic.ulweb.ulweb.entity.UlContent,com.ulic.ulweb.ulweb.entity.UlContentWithAtt,com.ulic.ulweb.ulweb.util.DisplayOnPage" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>微话</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/boxover.js"></script>
<script type="text/javascript" src="weihua/js/jquery-1.7.1.js"></script>
<style type="text/css">
body{font-family: "Microsoft YaHei",微软雅黑,"MicrosoftJhengHei",华文细黑,STHeiti,MingLiu;font-size: 15px;}
.mainDiv{margin: auto;width: 1000px;height: auto;border: 1px solid #fff;background-color: #fff;overflow: hidden;}
.mainTop{margin: 1px 1px;height: 49px;}
.mainTop .left{width: 800px;float: left;height: auto;overflow: hidden;}
.mainTop .right{width: 185px;float: left;height: auto;overflow: hidden;margin-left: 10px;}


.mainRight{width: 188px;margin-left: 10px;height:auto;background-color: #fff;float: left;overflow: hidden;}

/*.mainLeft{width: 800px;margin: 0px 0px;height:auto;background-color: #fff;float: left;overflow: hidden;}
.mainLeft .left{width: 470px;background-color: #fff;float: left;height: auto;overflow: hidden;}
.mainLeft .right{width: 320px;background-color: #fff;float: left;height: auto;overflow: hidden;margin-left: 10px;}*/
.mainLeft{width: 1000px;margin: 0px 0px;height:auto;background-color: #fff;float: left;overflow: hidden;}
.mainLeft .left{width: 660px;background-color: #fff;float: left;height: auto;overflow: hidden;}
.mainLeft .right{width: 320px;background-color: #fff;float: left;height: auto;overflow: hidden;margin-left: 10px;}
.mainRight .mid{width: 100%;height: auto;overflow: hidden;}

.mainLeft .left a{color: #ff3400;;}
.mainLeft .left a:hover{color: purple;}
.mainLeft .right a:hover{color: purple;}
</style>

<script type="text/javascript">
	function openInfo(contentId){
		window.open("weihua.do?method=show&c="+contentId)
	}
    $(document).ready(function(){  
        var loaded = false;  
        var index = 2; 
        
        
        $("#bottom2").click(function(){
        	$("#bottom2").css("display","none");
        	$("#bottom").css("display","block");
        	show();
        });
        
        function show(){  
       		var top = $("#bottom2").offset().top;  
         	//if(!loaded && $(window).scrollTop() + $(window).height() > top ){  
	           	$.ajax({
					url : "weihua.do?method=jiazai",
					type : "post",
					data : {
						"clickNum" : 10,
						"columnId" : 5686,
						"pageSize" : 10,
						"pageNum" : index,
						"enName" : "weihua",
						"deptId" : "0000"
					},
					dataType : "html",
					success : function(showResult) {
						//$("#comment").val(showResult)
						$("#comments").append(showResult);
						$("#bottom2").css("display","block");
        				$("#bottom").css("display","none");
					},
					error: function(XMLHttpRequest,textStatus,errorThrown){},
					complete:function(msg){}
				});
				index++;

           //	}
        
		}
        //$(window).scroll(show);  
    });  
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
			<div class="left">
				<script language="javascript">
				var imgUrl=new Array();
				var imgLink=new Array();
				var text=new Array();
				var adNum=0;
				var buttonShow=1;
				var buttonPos=2; //RU:1，RD:2，LU:3，LD:4
				
				
				
				<ulweb:content beanName="cl" deptId="0000" enName="zjtp" pageNum="1" pageSize="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<% int index=1; %>
				<logic:iterate id="element" name="cl" property="objectList">
				
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
				imgUrl[<%=index%>]="<bean:write name="e" property="displayPath" filter="false" />";
				imgLink[<%=index%>]="<bean:write name="element" property="subTitle" filter="false" />";
				text[<%=index%>]="<bean:write name="element" property="keyWord" filter="false" />";			
				<% index++; %>
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
			</script>
			<script language="javascript" src="weihua/newsAd.js"></script>
			<table id=newsTable border="0" cellspacing="0" cellpadding="0" style="border: solid 2px #C8E8F0; ">
				<script language="javascript">dakularButtons();</script>
				<tr>
					<td>
						<a onMouseOver="displayStatusMsg();return document.returnValue" onMouseOut="status='';" class=px14-lh24 href="javascript:jump2url()">
							<img style="FILTER: revealTrans(duration=1,transition=23); border:0px solid #000000;width: 800px;height: 300px" src="#"  border=0 name=imgUrlrotator alt=""> 
						</a>
						<script>nextAd();</script>
					</td>
				</tr>
			</table>
			</div>
			<div class="right">
				<div style="margin: 15px 0;">
					<img src="weihua/images/erw.jpg" style="width: 185px;">
				</div>
				<div >
					<input title="header=[设置默认打开FOXMAIL] body=[执行Foxmail“工具”菜单的“系统设置”命令，打开“设置”对话框，然后复选“常规”选项卡中的“检查Foxmail是否是系统默认邮件软件”选项。这样，启动Foxmail时，如果Foxmail不是系统默认邮件软件，将会弹出一个对话框，问是否将Foxmail设为默认邮件软件，只需从中选择“是”按钮即可]" type="button" 
					onclick="window.location.href='mailto:ligd@ulic.com.cn';" value="" 
					style="background: url('weihua/images/btbg.jpg');border-width: 0px;width: 173px;height: 41px;margin: 0 0 0 10px;color: #fff;font-size: 20px;font-weight: bolder;text-align: center;cursor: pointer;" />
				</div>
			</div>
		</div>
		<div class="mainLeft">
			<div class="left">
				<!--<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="1" pageSize="10" columnId="2671"  conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" /> -->
				<ulweb:content beanName="cl" deptId="0000" enName="weihua" pageNum="1" pageSize="10" columnId="5686" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="cl" property="objectList">
					<% int imgIndexF = 1; %>
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<% if(imgIndexF==1){%>
							<div style="width: 100%;height: 116px;border-bottom: 1px solid #ddd;margin-top: 8px;">
								<div style="height: 100%;width: 150px;background-color: #fff;float: left;cursor: pointer;" onclick="window.open('weihua.do?method=show&c=<bean:write name="element" property="contentId" />');">
									<!--  <a href="show.do?c=<bean:write name="element" property="contentId" />" target="_blank"><img src="<bean:write name="e" property="displayPath" />" style="width: 135px;height: 100px" class="bor"/></a>-->
									<img src="<bean:write name="e" property="displayPath" />" style="width: 135px;height: 100px" class="bor"/>
								</div>
								<div style="height: 100%;width: 510px;background-color: #fff;float: left;text-align: left;">
									<div style="font-size: 19px;padding: 5px 5px;font-weight:bolder;cursor: pointer;">
										<a target="_blank" style="text-decoration: none" href="weihua.do?method=show&c=<bean:write name="element" property="contentId" />">
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
				<div id="comments"></div>  
				<div id="bottom" style="text-align: center;line-height: 50px;color: #ccc;vertical-align: center;height: 50px;display: none">
					<div style="width: 50;height: 50px;margin: auto;">
						<img src="weihua/images/jiazai.jpg" style="width: 50px;height: 50px">
					</div>	
				</div> 
				<div id="bottom2" style="text-align: center;cursor: pointer;line-height: 50px;color: #888;font-weight: bolder;vertical-align: center;height: 50px;background-color: #CBEDEE;border: 1px solid #ddd">
					查看更多
				</div>  
			</div>
			<div class="right">
				<div style="text-align:right;color: #ccc;font-weight: bolder;font-size: 14px;padding: 0px 10px;cursor: pointer;background: url('weihua/images/hot.jpg') no-repeat left;height: 50px;line-height: 50px;vertical-align: center" onclick="window.open('weihua.do?method=list');">更多</div>
				
				<!-- <ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="1" pageSize="10"   conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" /> -->
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
		<!-- <div class="mainRight">
			<div class="mid">
				<ulweb:content beanName="cl" deptId="0000" enName="tupian" pageNum="1" pageSize="10" clickNum="10" conditions="isDelete=0:i;isProcessing=0:i;" withAtt="1" />
				<logic:iterate id="element" name="cl" property="objectList">
					<logic:notEmpty name="element" property="attachmentList">
						<logic:iterate id="e" name="element" property="attachmentList">
							<div id="<bean:write name="element" property="contentId" filter="false" />" class="dispShow" style="height: auto;width: 100%;overflow: hidden;position: relative" onclick="window.location.href='weihua.do?method=show&c=<bean:write name="element" property="contentId" />'">
								<div style="height: auto;width: 100%;background-color:#fff;overflow: hidden;margin-bottom: 5px;">
									<img src="<bean:write name="e" property="displayPath" />" style="width: 184px;height: 70px" class="bor"/>
								</div>
								<div id="<bean:write name="element" property="contentId" filter="false" />_show" style="display:none;height: 70px;width: 184px;background-color: #eee;text-align: left;overflow: hidden;position: absolute;left: 0px;top: 0px;filter:alpha(opacity=50);-moz-opacity:0.5;-khtml-opacity: 0.5;opacity: 0.5;z-index: 1;font-size: 12px;cursor: pointer;">
									<div style="padding: 2px 5px;"><bean:write name="element" property="contentName" filter="false" /></div>
									<div style="text-align: right;padding: 2px 5px;"><bean:write name="e" property="clickNum" filter="false" />&nbsp;&nbsp;点击</div>
								</div>
							</div> 
						</logic:iterate>
					</logic:notEmpty>
				</logic:iterate>
			</div>
		</div> -->
	</div>
</body>
</html>