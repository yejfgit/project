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

				<td height="28">

					<table width="100%" height="22" border="0" cellpadding="0"
						cellspacing="0" background="dept/baofei2/images/nav_bar.jpg"
 style="margin: 3px; border: solid 1px #CCCCCC">
						<tr>
							<td width="100" align="center"></td>
							<td align="center">
								<a href="dept/baofei2/list.jsp?eId=txl" class="nav">通讯录</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=xiazai" class="nav">常用下载</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="admin/index.jsp" target="_blank" class="nav">系统管理</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=jigou" class="nav">机构之声</a>
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								续期论坛
							</td>
							<td align="center" style="border-left: solid 1px #CCCCCC">
								<a href="dept/baofei2/list.jsp?eId=fuwuxingxiao" class="nav">明星会专栏</a>
							</td>
							<td width="200" align="center">
								<input id="input_search" type="text" name="keyword"
									style="width: 120px; height: 12px" onkeypress="pressEnter(doSearch)" />
								<a href="javascript:doSearch();">站内搜索</a>
							</td>
							<td width="50" align="center"></td>

						</tr>
					</table>

				</td>

			</tr>



			<tr>
				<td>
					<img src="dept/baofei2/images/foot2.jpg" width="800" height="75" />
				</td>
			</tr>
