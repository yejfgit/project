<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>showGuide</title>
		<%@ include file="/include/head.jsp"%>
	</head>
<script type="text/javascript" src="guide/javascript/comment.js"></script>




	<body>

		<div
			style="width:100%; text-align:center;margin-right:auto;margin-left:auto">
			<div style="width:100%; height:100px; background:#BAC7DA">
				<!--上面-->
			</div>

			<div style="text-align:left;width:60%; height:400px; float:left;">
				<!--左边-->
				<div style="margin-top:10px">
					<s:property value="guide.name" />
				</div>
				<div style="margin-left:10px;margin-top:20px">
					<div
						style="float:left;width:80px;border:#000 solid 1px;width:100px">
						<a href="javascript:void(0);"><span style="">服务指引 》》</span> </a>
					</div>
					<div
						style="float:left;margin-left:5px;border:#000 solid 1px;width:100px">
						<a href="javascript:void(0);"><span style=""><s:property value="guideType.name"/> 》》</span> </a>
					</div>
					<div
						style="float:left;margin-left:5px;border:#000 solid 1px;width:100px">
						<a href="javascript:void(0);"><span style=""><s:property value="guide.name"/></span> </a>
					</div>
				</div>
				<div style="margin-top: 80px">
					标签：
					<input type="hidden" id="guideId" name="guideId" value="<s:property value='guide.id' />"/>
					<s:property value="guide.label" />
				</div>
				<div style="margin-top:30px;margin-left:50px">
					<s:property value="guide.description" />
				</div>

				<div>
				     <input type="textarea" value="" id="comment"/>&nbsp;&nbsp;&nbsp;
				     <input type="button" value="发布" onclick="comment()">
				     <div id="show">
				     <jsp:include page="commentList.jsp"/>
				     </div>
				    <div id="show1">
					<table>
						<tr>
							<td>
								序号
							</td>
							<td>
								内容
							</td>
							<td>
								用户
							</td>
							<td>
								时间
							</td>
						</tr>


						<s:iterator value="commentList">
							<tr>
								<td>
									<s:property value="id" />
								</td>
								<td>
									<s:property value="commentDesc" />
								</td>
								<td>
									<s:property value="userName" />
								</td>
								<td>
									<s:property value="commentDate" />
								</td>
							</tr>
						</s:iterator>
					</table>
					</div>
				</div>
			</div>

			<div
				style="height:400px;width:20%;float:right;overflow:Auto;  background:#BBC3D8">
				<div>
				<s:iterator value="guideRelationList">
				<ui>
				<li>
				<a href="javascript:void(0);">
				<span>
				</span>
				</a>
				<br></li>
				</ui>
				</s:iterator>
				</div>
			</div>
			<div
				style=" width:100%; height:150px; float:left; background:#FF0000;display:none">
				<!--底部-->
			</div>
		</div>
	</body>
</html>
