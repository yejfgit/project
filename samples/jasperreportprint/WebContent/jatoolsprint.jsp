<%@ page contentType="text/html; charset=UTF-8"%>
<%
String ctxpath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ctxpath+"/";

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="guide.css" />
<title>打印预览一个分页文档</title>
<script type="text/javascript" src="jatoolsPrinter.js"></script>
<script type="text/javascript">
function doPrint(how)
{
 
    //打印文档对象9
    var myDoc ={ 
                     
                    documents: document,    // 打印页面(div)们在本文档中
                    copyrights  :    '杰创软件拥有版权  www.jatools.com'         // 版权声明必须
                  };
    var jatoolsPrinter = getJatoolsPrinter();             
    // 调用打印方法
    if(how == '打印预览...')
        jatoolsPrinter.printPreview(myDoc );   // 打印预览
                  
    else if(how == '打印...')
        jatoolsPrinter.print(myDoc ,true);   // 打印前弹出打印设置对话框
                 
    else
        jatoolsPrinter.print(myDoc ,false);       // 不弹出对话框打印
 
 
       
}
</script>
</head>
<body>
<p> <span class="title">打印预览一个分页文档</span><span class="src"><a href='javascript:viewSource()'>查看源代码</a></span> </p>
<div class='pagecontainer'>
  <div id='page1' class='pagestyle'>文档第一页</div>
  <div id='page2' class='pagestyle'>文档第二页</div>
</div>
<br>
<input type="button" value="打印预览..." onClick="doPrint('打印预览...')">
<input type="button" value="打印..." onClick="doPrint('打印...')">
<input type="button" value="打印" onClick="doPrint('打印')">
<!-- 插入打印控件 -->
        <object id="ojatoolsPrinter" codebase="jatoolsPrinter.cab#version=5,4,0,0"
        classid="clsid:B43D3361-D075-4BE2-87FE-057188254255" width="0" height="0">
            <embed id="ejatoolsPrinter" type="application/x-vnd.jatoolsPrinter"
            pluginspage="jatoolsPrinter.exe" width="0" height="0"
            />
            </body>
</html>