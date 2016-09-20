<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="struts-bean.tld" prefix="bean"%>
<%@ taglib uri="struts-html.tld" prefix="html"%>
<%@ taglib uri="struts-logic.tld" prefix="logic"%>
<%@ taglib uri="ulweb-list.tld" prefix="ulweb"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>

			<tr>
				<td height="90" background="dept/baofei2/images/logo.jpg">
					<div class="logo_text">
						<div align="left" style="list-style: none; font-family: 隶书; font-size: 26px">
							<ulweb:content beanName="kh" deptId="baofei" enName="kouhao"
								conditions="isDelete=0:i;" pageSize="1" pageNum="1" />

							<logic:iterate id="element" name="kh" property="objectList">
								<li>
									<bean:write name="element" property="contentName" />
								</li>
							</logic:iterate>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td height="28">
					<table width="100%" height="22" border="0" cellpadding="0"
						cellspacing="0" background="dept/baofei2/images/nav_bar.jpg"
						 style="margin: 3px; border: solid 1px #CCCCCC">
						<tr>
							<td align="center">
								今天是
								<script type="text/javascript">
	var dt = new Date();
	var weekday;
	switch (dt.getDay()) {
		case 0: weekday = "日"; break;
		case 1: weekday = "一"; break;
		case 2: weekday = "二"; break;
		case 3: weekday = "三"; break;
		case 4: weekday = "四"; break;
		case 5: weekday = "五"; break;
		case 6: weekday = "六"; break;
	}	
	document.writeln(dt.getFullYear() + "年" + (dt.getMonth() + 1) + "月" + dt.getDate() + "日 星期" + weekday);
</script>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=jianjie" class="nav">部门简介</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=tongzhi" class="nav">文件通知</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=jingying" class="nav">经营管理</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=subao" class="nav">业绩速报</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=jingsai" class="nav">竞赛激励</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=jiaoyu" class="nav">教育训练</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=yeguan" class="nav">业管信息</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=renguan" class="nav">人员管理</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=dudao" class="nav">督导园地</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>