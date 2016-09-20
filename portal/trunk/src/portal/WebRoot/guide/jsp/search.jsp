<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>cat query</title>
		<%@ include file="/include/head.jsp"%>
<script type="text/javascript" src="guide/javascript/search.js"></script>
<link href="guide/css/left.css" rel="stylesheet" type="text/css" />
<link href="guide/css/top.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	
	<div class="navsort" style="display">

	<div class='allsort'>
		
		<div class='mt'><strong><a href="javascript:void(0)/">全部服务分类</a></strong><div class='extra'>&nbsp;</div></div>
		
		<div class='mc'>
			<div class='item fore'>
				<span><h3><a href="javascript:void(0)">行政</a></h3><s></s></span>
				<div class='i-mc'>
					<div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
					<div class='subitem'>
						<dl class='fore'>
							<dt>用印</dt>
							<dd>
								<em><a href='javascript:void(0)'>用印</a></em>
								<em><a href='javascript:void(0)'>用印</a></em>
							</dd>
						</dl>
						<dl>
							<dt>合同</dt>
							<dd>
								<em><a href='javascript:void(0)'>合同1</a></em>
								<em><a href='javascript:void(0)'>合同2</a></em>
								<em><a href='javascript:void(0)'>合同3</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			
			<div class='item'>
				<span><h3><a href="javascript:void(0)">人事</a></h3><s></s></span>
				<div class='i-mc'>
					<div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
					<div class='subitem'>
						<dl>
							<dt>请假</dt>
							<dd>
								<em><a href='javascript:void(0)'>请假1</a></em>
								<em><a href='javascript:void(0)'>请假2</a></em>
								<em><a href='javascript:void(0)'>请假3</a></em>
								<em><a href='javascript:void(0)'>请假4</a></em>
								<em><a href='javascript:void(0)'>请假5</a></em>
							</dd>
						</dl>
						<dl class='fore'>
							<dt>公出</dt>
							<dd>
								<em><a href='javascript:void(0)'>公出1</a></em>
								<em><a href='javascript:void(0)'>公出2</a></em>
								<em><a href='javascript:void(0)'>公出3</a></em>
								<em><a href='javascript:void(0)'>公出4</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			
			<div class='item'>
				<span><h3><a href="javascript:void(0)">IT</a></h3><s></s></span>
				<div class='i-mc'>
					<div class='close' onclick="$(this).parent().parent().removeClass('hover')"></div>
					<div class='subitem'>
						<dl class='fore'>
							<dt>任务</dt>
							<dd>
								<em><a href='javascript:void(0)'>任务</a></em>
								<em><a href='javascript:void(0)'>任务</a></em>
								<em><a href='javascript:void(0)'>任务</a></em>
							</dd>
						</dl>
						<dl>
							<dt>端口</dt>
							<dd>
								<em><a href='javascript:void(0)'>端口</a></em>
								<em><a href='javascript:void(0)'>端口</a></em>
								<em><a href='javascript:void(0)'>端口</a></em>
								<em><a href='javascript:void(0)'>端口</a></em>
								<em><a href='javascript:void(0)'>端口</a></em>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
		
	</div><!--allsort end-->
	
	<div class="searcbox"></div>
	
	<div class="carbox"></div>
	
</div>	
	
<script type="text/javascript"> 
$(".allsort").hoverForIE6({current:"allsorthover",delay:200});
$(".allsort .item").hoverForIE6({delay:150});
</script>    
	    
	    <div style="width:80%; text-align:center;margin-right: auto;margin-left:auto;display">
		<div style="width:100%; height:100px; background:#BAC7DA">
			
		</div>
		<div style="text-align:left;width:200px; height:400px; float:left; background:#BBC3D8">
			<div class="demopage">
		        <ul class="sidenav">
			    <li>
				<a href="javascript:void(0)">行政</a>
				<div><p>行政</p></div>
			    </li>
			    <li>
				<a href="javascript:void(0)">人事</a>
				<div><p>人事</p></div>
			    </li>
			    <li>
				<a href="javascript:void(0)">IT</a>
				<div><p>IT</p></div>
			</li>
		    </ul>
		    </div>
		</div>
		<div
			style="height:400px;float:left;overflow:hidden;">
			<!--右边-->
			<form action="guide/search" method="post">
		     <input type="text" name="guideSearch"/>
		     <input type="submit" value="搜索"/><br>
			<s:iterator value="guideList">
				<a href="guide/showGuide?guide.id=<s:property value='id' />"><s:property value="name" /></a>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:property value="description" />
				<br>
			</s:iterator>
		</div>
		<div style=" width:100%; height:150px; float:left; background:#FF0000;display:none">
			<!--底部-->
		</div>
		</div>
	</body>
</html>
