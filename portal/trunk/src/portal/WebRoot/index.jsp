<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="/jsp/include/head.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>主界面</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />


    <script src="scripts/boot.js" type="text/javascript"></script> 
    
    <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    .header
    {
        background:url(images/header.gif) repeat-x 0 -1px;
    }
    .Note
    {
        background:url(Notes_Large.png) no-repeat;width:32px;height:32px;
    }
    .Reports
    {
        background:url(Reports_Large.png) no-repeat;width:32px;height:32px;
    }
    </style>    
</head>
<body >   

<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div class="header" region="north" height="70" showSplit="false" showHeader="false">
        <h1 style="margin:0;padding:15px;cursor:default;font-family:微软雅黑,黑体,宋体;">XXX应用管理系统<br /></h1>
        <div style="position:absolute;top:18px;right:10px;">
            <a class="mini-button mini-button-iconTop" iconCls="icon-add" onclick="onQuickClick" plain="true">快捷</a>    
            <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick"  plain="true" >首页</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-date" onclick="onClick"  plain="true" >消息</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick"  plain="true" >设置</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="onClick"  plain="true" >关闭</a>        
            
        </div>
        
    </div>

    <div title="south" region="south" showSplit="false" showHeader="false" height="30" >
        <div style="line-height:28px;text-align:center;cursor:default">Copyright &copy; ULIC </div>
    </div>
    
    <div showHeader="false" region="west" width="180" maxWidth="250" minWidth="100" >
        <!--OutlookMenu-->
        <div class="mini-outlookmenu" url="data/outlookmenu.txt" onitemselect="onItemSelect"
            idField="id" parentField="pid" textField="text" borderStyle="border:0" 
        >
        </div>
    </div>
    
    <div title="center" region="center" bodyStyle="overflow:hidden;">
        <iframe id="mainframe" frameborder="0" name="main" style="width:100%;height:100%;" border="0"></iframe>
    </div>
    
</div>
    
    <script type="text/javascript">
        mini.parse();

        //init iframe src
        var iframe = document.getElementById("mainframe");
        iframe.src = "userIndex"

        function onItemSelect(e) {
            var item = e.item;
            iframe.src = item.url;
        }
        
        
    </script>

</body>
</html>
