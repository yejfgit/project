<!--
var smallleftshowad = true;
var smallleftToppx = 450;   //上端位置
var smallleftAdDivW = 90;  //宽度
var smallleftAdDivH = 90;  //高度
var smallleftPageWidth = 800; //页面多少宽度象素下正好不出现左右滚动条
var smallleftMinScreenW = 1024; //显示广告的最小屏幕宽度象素 

var AdLeftHtml = '<div align="center" style="color:green;font-size:23pt;font-family:黑体;"><iframe id="LeftSmallAdvlr" name="showWnd" marginWidth="0" marginHeight="0" src="http://www.cmbchina.com/main/adv/smalladvlr/left.htm" frameBorder="no" width="90" scrolling="no" height="90"></iframe></div>';
var ClosebuttonHtml = '<div align="right" style="position: absolute;top:90px;right:0px;padding:4px;z-index:2000;width:90px;background-color:#f6f6f6"><a href="javascript:;" onclick="hidesmallleftad()" style="color:black;text-decoration:none;font-size:12px;">关闭</a></div>';
document.write ('<div id="smallLeftDiv" style="position: absolute;background-color:white;z-index:1000;width:'+smallleftAdDivW+'px;height:'+smallleftAdDivH+'px;top:-1000px;word-break:break-all;display:none;">'+AdLeftHtml+ClosebuttonHtml+'</div>');

function smallleftadv(){
 if(!smallleftshowad){return;}
 
 if (window.screen.width<smallleftMinScreenW){
  //alert("临时提示：\n\n显示器分辨率宽度小于"+MinScreenW+",不显示广告");
  smallleftshowad = false;
  document.getElementById("smallLeftDiv").style.display="none";  
  return;
 } 
  
 var Borderpx = ((window.screen.width-smallleftPageWidth)/2-smallleftAdDivW)/2; 
 
 document.getElementById("smallLeftDiv").style.display="";
 document.getElementById("smallLeftDiv").style.top=document.body.scrollTop+smallleftToppx;
 document.getElementById("smallLeftDiv").style.left=document.body.scrollLeft+Borderpx;
 
 setTimeout("smallleftadv();",20);  
}

function hidesmallleftad()
{
 smallleftshowad = false;
 document.getElementById("smallLeftDiv").style.display="none"; 
}
//window.onresize=smallscall;
//window.onload=scall;
smallleftadv();
//-->

